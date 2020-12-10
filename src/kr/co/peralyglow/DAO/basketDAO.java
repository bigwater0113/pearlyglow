package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.join.ShoppingBasket_ItemsVo;

public class basketDAO {
	
	private basketDAO() {}
	private static basketDAO instance = new basketDAO();
	public static basketDAO getInstance() {
		return instance;
	}
	
	
	public int insert(String id, int iNum, int sbCnt) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("insert into shoppingbasket values(shoppingbasket_seq.nextval, ?, ?, ?)");
			ps.setString(1, id);
			ps.setInt(2, iNum);
			ps.setInt(3, sbCnt);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}
		
		return n;
	}
	
	public ArrayList<ShoppingBasket_ItemsVo> selectAll(String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ShoppingBasket_ItemsVo> ShoppingBasket_ItemsVo = new ArrayList<ShoppingBasket_ItemsVo>();
		
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select * from shoppingbasket s, items i, items_image ii where id = ? and s.inum = i.inum and i.inum = ii.inum");
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int sbNum = rs.getInt("sbNum");
				int sbCnt = rs.getInt("sbCnt");
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int imgNum = rs.getInt("imgNum");
				String imgName = rs.getString("imgName");
				
				ShoppingBasket_ItemsVo.add(new ShoppingBasket_ItemsVo(sbNum, id, iNum, sbCnt, iName, price, iGender, iCategory, color, iSize, imgNum, imgName));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}
		
		return ShoppingBasket_ItemsVo;
	}
}











