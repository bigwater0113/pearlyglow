package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBConnection;
import kr.co.pearlyglow.vo.ItemsVo;

public class itemsDAO {

	private itemsDAO() {
	}

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

				list.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material,
						kDetail, eDetail, iThumbnail, total));
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

				vo = new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material, kDetail,
						eDetail, iThumbnail, total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}

		return vo;
	}

	public int update(ItemsVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		con = DBConnection.getConn();
		try {
			ps = con.prepareStatement(
					"update items set iName =  ?, price = ?, iGender = ?, iCategory = ?, color = ?,"
					+ "iSize = ?, weight = ?, material = ?, Kdetail = ?, eDetail = ?, total = ? where iNum = ?");
			ps.setString(1, vo.getiName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getiGender());
			ps.setString(4, vo.getiCategory());
			ps.setString(5, vo.getColor());
			ps.setString(6, vo.getiSize());
			ps.setInt(7, vo.getWeight());
			ps.setString(8, vo.getMaterial());
			ps.setString(9, vo.getkDetail());
			ps.setString(10, vo.geteDetail());
			ps.setInt(11, vo.getTotal());
			ps.setInt(12, vo.getiNum());
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, rs);
		}

		return n;
	}
	
	/*
	public int delete(int iNum) {
		Connection con = null;
		PreparedStatement ps = null;
		
		con = DBConnection.getConn();
		ps = con.prepareStatement("delete from items")
	}
	*/
	
	
	public void deleteImg (int iNum) {
		
	}
}






