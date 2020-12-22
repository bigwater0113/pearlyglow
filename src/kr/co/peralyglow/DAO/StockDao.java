package kr.co.peralyglow.DAO;

import kr.co.pearlyglow.db.DBCPBean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.sql.Connection;

public class StockDao {
	private StockDao() {}
	private static StockDao instance = new StockDao();
	public  static StockDao getInstance () {
		return instance;
	}
	
	public int insert (int iNum, int rs, int sbCnt) {
		Connection con = null;
		PreparedStatement ps = null;
		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("insert into stock values(stock_seq.nextval, ?, ?, ?, sysdate)");
			ps.setInt(1, iNum);
			ps.setInt(2, rs);
			ps.setInt(3, sbCnt);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, null);
		}
		return n;
	}
}
