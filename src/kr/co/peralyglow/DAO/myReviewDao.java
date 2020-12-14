package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.join.MyReviewVo;

public class myReviewDao {
	private static myReviewDao instance=new myReviewDao();
	
	private myReviewDao() {}
	
	public static myReviewDao getInstance() {
		return instance;
	}
	
	public ArrayList<MyReviewVo> MR_list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MyReviewVo> list=new ArrayList<MyReviewVo>();
		try {
			String sql="select " + 
					"    p.id, p.pNum, p.pStatus, p.pDate, pd.pdNum, i.iNum,i.iName, " + 
					"    i.iThumbnail,pd.pCnt, pd.pPay, rb.score,rb.rbContent,rb.saveName,rb.rDate " + 
					"from purchase p join pdetail pd " + 
					"on p.pnum=pd.pnum " + 
					"join reviewboard rb " + 
					"on pd.pdnum=rb.pdnum " + 
					"join items i " + 
					"on pd.inum=i.inum";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MyReviewVo(
						rs.getString("id"), 
						rs.getInt("pNum"), 
						rs.getString("pStatus"), 
						rs.getDate("pDate"), 
						rs.getInt("pdNum"), 
						rs.getInt("iNum"), 
						rs.getString("iName"),
						rs.getString("iThumbnail"), 
						rs.getInt("pCnt"), 
						rs.getInt("pPay"), 
						rs.getInt("score"), 
						rs.getString("rbContent"), 
						rs.getString("saveName"), 
						rs.getDate("rDate")));
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
}
