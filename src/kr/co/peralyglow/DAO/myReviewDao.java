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
	public int getCount(String status) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBCPBean.getConn();
			String isnull=" is not null ";
			if(status.trim()==null || status.trim().equals("") || status.equals("1")) {
				isnull=" is null ";
			}
			String sql="select count(pDate) " + 
					"from " + 
					"( " + 
					"select " + 
					"        p.id, p.pNum, p.pStatus, p.pDate, pd.pdNum, i.iNum,i.iName,i.iThumbnail,pd.pCnt, pd.pPay,rb.score,rb.rbContent,rb.saveName,rb.rDate " + 
					"        from purchase p join pdetail pd  " + 
					"        on p.pnum=pd.pnum  " + 
					"        join items i  " + 
					"        on pd.inum=i.inum " + 
					"        full outer join reviewBoard rb " + 
					"        on pd.pdnum=rb.pdnum " + 
					"        where p.id='test' and rb.rDate " + isnull + 
					"        order by pdate desc " + 
					"        )";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int cnt=rs.getInt("count(pDate)");
			return cnt;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	public ArrayList<MyReviewVo> MR_list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MyReviewVo> list=new ArrayList<MyReviewVo>();
		try {
			String sql="select " + 
					"p.id, p.pNum, p.pStatus, p.pDate, pd.pdNum, i.iNum,i.iName, " + 
					"i.iThumbnail,pd.pCnt, pd.pPay, rb.score,rb.rbContent,rb.saveName,rb.rDate " + 
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
	public ArrayList<MyReviewVo> MR_list_BA(String status,int startRow,int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MyReviewVo> list=new ArrayList<MyReviewVo>();
		String sql="";
		try {
			if(status.trim()==null || status.trim().equals("") || status.equals("1")) {
				sql="select * " + 
					"from " + 
					"( " + 
					"    select rownum rnum,a.* " + 
					"    from " + 
					"    ( " + 
					"        select " + 
					"        p.id, p.pNum, p.pStatus, p.pDate, pd.pdNum, i.iNum,i.iName,i.iThumbnail,pd.pCnt, pd.pPay,rb.score,rb.rbContent,rb.saveName,rb.rDate " + 
					"        from purchase p join pdetail pd  " + 
					"        on p.pnum=pd.pnum  " + 
					"        join items i  " + 
					"        on pd.inum=i.inum " + 
					"        full outer join reviewBoard rb " + 
					"        on pd.pdnum=rb.pdnum " + 
					"        where p.id='test' and rb.rDate is null " + // is null
					"        order by pdate desc " + 
					"    ) a " + 
					") " + 
					"where rnum between ? and ?";
			}else if(status.equals("2")){
				sql="select * " + 
						"from " + 
						"( " + 
						"    select rownum rnum,a.* " + 
						"    from " + 
						"    ( " + 
						"        select " + 
						"        p.id, p.pNum, p.pStatus, p.pDate, pd.pdNum, i.iNum,i.iName,i.iThumbnail,pd.pCnt, pd.pPay,rb.score,rb.rbContent,rb.saveName,rb.rDate " + 
						"        from purchase p join pdetail pd  " + 
						"        on p.pnum=pd.pnum  " + 
						"        join items i  " + 
						"        on pd.inum=i.inum " + 
						"        full outer join reviewBoard rb " + 
						"        on pd.pdnum=rb.pdnum " + 
						"        where p.id='test' and rb.rDate is not null " + // is not null
						"        order by pdate desc " + 
						"    ) a " + 
						") " + 
						"where rnum between ? and ?";
			}
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
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
