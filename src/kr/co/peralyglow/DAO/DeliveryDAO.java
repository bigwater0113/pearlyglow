package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;

public class DeliveryDAO {
	public int insert (int pNum) {
		Connection con = null;
		PreparedStatement ps = null;
		
		long trackingNum = System.currentTimeMillis();
		
		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("insert into delivery values(delivery_seq.nextval, ?, '우체국', ?, '상품준비중')");
			ps.setInt(1, pNum);
			ps.setLong(2, trackingNum);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			DBCPBean.close(con, ps, null);
		}
		return n;
	}
}
