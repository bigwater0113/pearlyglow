package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;

public class PurchaseListDao {
	private static PurchaseListDao instance=new PurchaseListDao();
	private PurchaseListDao() {}
	public static PurchaseListDao getInstance() {
		return instance;
	}
	//구매번호 받아서 리뷰작성페이지에  구매상세번호 자동입력되게끔  넘기기
	public int getPdnum(int pnum) {
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	      try {
	         con=DBCPBean.getConn();
	         String sql = "select pdnum from pdetail where pnum="+pnum;
	         pstmt=con.prepareStatement(sql);
	         rs=pstmt.executeQuery();
	         if(rs.next()) {
	        	 int pdnum=rs.getInt("pdnum");
	        	 return pdnum;
	         }
	      }catch(SQLException s) {
	         s.printStackTrace();
	      }finally {
	         DBCPBean.close(con, pstmt, null);
	      }
	}
	
	
	
}
