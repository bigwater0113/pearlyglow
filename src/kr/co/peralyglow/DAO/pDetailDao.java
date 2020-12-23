package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;

public class pDetailDao {
	
	private pDetailDao() {}
	private static pDetailDao instance = new pDetailDao();
	public static pDetailDao getInstance () {
		return instance;
	}
	
	public int insert (int pNum, int iNum, int pCnt, int pPay) {

		Connection con = null;
		PreparedStatement ps = null;
		
		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("insert into pDetail values(pDetail_seq.nextval, ?, ?, ?, ?)");
			ps.setInt(1, iNum);
			ps.setInt(2, pNum);
			ps.setInt(3, pCnt);
			ps.setInt(4, pPay);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, null);
		}
		
		return n;
		
	}
}
