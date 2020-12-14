package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBConnection;
import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.join.Stock_Items_ItemsImageVO;

public class StockDAO {
	
	private StockDAO() {}
	private static StockDAO instance = new StockDAO(); 
	public static StockDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Stock_Items_ItemsImageVO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<Stock_Items_ItemsImageVO> vo = new ArrayList<Stock_Items_ItemsImageVO>();
		
		try {
			con = DBConnection.getConn();
			ps = con.prepareStatement("select * from items i, items_image ii, stock s where i.inum = ii.inum and ii.inum = s.inum");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("meterial");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				
				String imgName = rs.getString("imgName");
				
				vo.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material, kDetail, eDetail, iThumbnail));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}
		
		return vo;
		
	}
}
