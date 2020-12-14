package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBConnection;
import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.Items_imageVo;

public class insertItemDAO {
	
	private insertItemDAO () {}
	private static insertItemDAO instance = new insertItemDAO();
	public static insertItemDAO getInstance(){
		return instance;
	}
	
	public int insert (ItemsVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		int n = 0;
		int items_seq_nextval = 0;
		try {
			con = DBConnection.getConn();
			
			ps2 = con.prepareStatement("select items_seq.nextval from dual");
			rs = ps2.executeQuery();
			if (rs.next()) {
				items_seq_nextval = rs.getInt(1);
			}
			
			
			ps = con.prepareStatement("insert into items values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, items_seq_nextval);
			ps.setString(2, vo.getiName());
			ps.setInt(3, vo.getPrice());
			ps.setString(4, vo.getiGender());
			ps.setString(5, vo.getiCategory());
			ps.setString(6, vo.getColor());
			ps.setString(7, vo.getiSize());
			ps.setInt(8, vo.getWeight());
			ps.setString(9, vo.getMaterial());
			ps.setString(10, vo.getkDetail());
			ps.setString(11, vo.geteDetail());
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
		
		return items_seq_nextval;
	}
	
	public int insertImg (String saveFileName, int items_seq_nextval) {
		Connection con = null;
		PreparedStatement ps = null;
		
		int n = 0;
		try {
			con = DBConnection.getConn();
			ps = con.prepareStatement("insert into items_image values(items_image_seq.nextval, ?, ?)");
			ps.setInt(1, items_seq_nextval);
			ps.setString(2, saveFileName);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(con, ps, null);
		}
		
		return n;
	}
}
