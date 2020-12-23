package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;

public class PurchaseDao {
	
	private PurchaseDao () {}
	private static PurchaseDao instance = new PurchaseDao();
	public static PurchaseDao getInstance () {
		return instance;
	}
	
	public int insertAndReturnSeqVal (String id, String receiver, String receiverEmail, String receiverPhone, String pAddress, String pWay, int pTotal) {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		int nextVal = 0;
		
		try {
			con = DBCPBean.getConn();
			
			
			ps = con.prepareStatement("insert into purchase values(purchase_seq.nextval, ?, ?, ?, ?, ?, ?, sysdate, '상품준비중', ?)");
			//ps.setInt(1, nextVal);
			ps.setString(1, id);
			ps.setString(2, receiver);
			ps.setString(3, receiverEmail);
			ps.setString(4, receiverPhone);
			ps.setString(5, pAddress);
			ps.setString(6, pWay);
			ps.setInt(7, pTotal);
			ps.executeUpdate();
			
			ps2 = con.prepareStatement("select purchase_seq.currval from dual");
			rs = ps2.executeQuery();
			if (rs.next()) {
				nextVal = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
			DBCPBean.close(ps2);
		}
		
		return nextVal;
	}
}
