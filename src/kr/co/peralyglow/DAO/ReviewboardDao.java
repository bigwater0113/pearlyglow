package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.PDetailVo;
import kr.co.pearlyglow.vo.ReviewBoardVo;


public class ReviewboardDao {
	private static ReviewboardDao instance=new ReviewboardDao();
	private ReviewboardDao() {}
	public static ReviewboardDao getInstance() {
		return instance;
	}

	public int insert(ReviewBoardVo vo) {
	      Connection con=null;
	      PreparedStatement pstmt=null;
	      try {
	         con=DBCPBean.getConn();
	         String sql = "insert into reviewboard values(reviewboard_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
	         pstmt=con.prepareStatement(sql);
	         pstmt.setInt(1, vo.getPdNum());
	         pstmt.setInt(2, vo.getScore());
	         pstmt.setString(3, vo.getRbContent());
	         pstmt.setString(4, vo.getOrgName());
	         pstmt.setString(5, vo.getSaveName());
	         int n = pstmt.executeUpdate();
	         return n;
	      }catch(SQLException s) {
	         s.printStackTrace();
	         return -1;
	      }finally {
	         DBCPBean.close(con, pstmt, null);
	      }
	   }
}
