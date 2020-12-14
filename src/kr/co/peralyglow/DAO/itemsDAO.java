package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBConnection;
import kr.co.pearlyglow.vo.ItemsVo;

public class itemsDAO {
	
	private itemsDAO() {}
	private static itemsDAO instance = new itemsDAO();
	public static itemsDAO getInstance() {
		return instance;
	}
	
	public ArrayList<ItemsVo> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();
		
		con = DBConnection.getConn();
		try {
			ps = con.prepareStatement("select * from items");
			rs = ps.executeQuery();
			while (rs.next()) {
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");				
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				
				list.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material, kDetail, eDetail, iThumbnail, total));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}
		
		return list;
	}
	
	public ItemsVo select(int iNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ItemsVo vo = null;
		
		con = DBConnection.getConn();
		try {
			ps = con.prepareStatement("select * from items where iNum = ?");
			ps.setInt(1, iNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				String iName = rs.getString("iName");				
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				
				vo = new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material, kDetail, eDetail, iThumbnail, total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}
		
		return vo;
	}
}
