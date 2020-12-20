package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;

public class VisitCountDao {
	private static VisitCountDao instance=new VisitCountDao();
	
	private VisitCountDao() {}
	
	public static VisitCountDao getInstance() {
		return instance;
	}
	
	public int setTotalCnt() {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			String sql="insert into visit values(sysdate)";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	public int getTotalCnt() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select count(*) TotalCnt from visit";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("TotalCnt");
			}else {
				return -1;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	public int getTodayCnt() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select count(*) TodayCnt from visit where to_date(vDate,'yyyy/mm/dd')=to_date(sysdate,'yyyy/mm/dd')";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("TodayCnt");
			}else {
				return -1;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
}
