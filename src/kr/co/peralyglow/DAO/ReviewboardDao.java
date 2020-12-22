package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.ReviewBoardVo;
import kr.co.pearlyglow.vo.join.Reviewboard_Purchase_pDetail_ItemsVo;

public class ReviewboardDao {
	private static ReviewboardDao instance = new ReviewboardDao();

	private ReviewboardDao() {
	}

	public static ReviewboardDao getInstance() {
		return instance;
	}

	public int insert(ReviewBoardVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBCPBean.getConn();
			String sql = "insert into reviewboard values(reviewboard_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPdNum());
			pstmt.setInt(2, vo.getScore());
			pstmt.setString(3, vo.getRbContent());
			pstmt.setString(4, vo.getOrgName());
			pstmt.setString(5, vo.getSaveName());
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException s) {
			s.printStackTrace();
			return -1;
		} finally {
			DBCPBean.close(con, pstmt, null);
		}
	}

	public ReviewBoardVo reviewInfo(int pdNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from reviewboard where pdnum=?";
			con = DBCPBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pdNum);
			rs = pstmt.executeQuery();
			ReviewBoardVo vo = null;
			if (rs.next()) {
				vo = new ReviewBoardVo(rs.getInt("rbNum"), rs.getInt("pdNum"), rs.getInt("score"),
						rs.getString("rbContent"), rs.getString("orgName"), rs.getString("saveName"),
						rs.getDate("rDate"));
				return vo;
			} else {
				return null;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}

	public int update(ReviewBoardVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			if(vo.getOrgName()==null) {
				String sql = "update reviewboard set score=?, rbContent=?,rDate=sysdate where pdNum=?";
				con = DBCPBean.getConn();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, vo.getScore());
				pstmt.setString(2, vo.getRbContent());
//				pstmt.setString(3, vo.getOrgName());
//				pstmt.setString(4, vo.getSaveName());
				pstmt.setInt(3, vo.getPdNum());
				int n = pstmt.executeUpdate();
				return n;
			}else {
				String sql = "update reviewboard set score=?, rbContent=?,orgName=?,saveName=?,rDate=sysdate where pdNum=?";
				con = DBCPBean.getConn();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, vo.getScore());
				pstmt.setString(2, vo.getRbContent());
				pstmt.setString(3, vo.getOrgName());
				pstmt.setString(4, vo.getSaveName());
				pstmt.setInt(5, vo.getPdNum());
				int n = pstmt.executeUpdate();
				return n;
			}
			
		} catch (SQLException s) {
			s.printStackTrace();
			return -1;
		} finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	public int delete(int pdNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from reviewboard where pdNum=?";
			con = DBCPBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pdNum);
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException s) {
			s.printStackTrace();
			return -1;
		} finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	public int deleteRb(int rbnum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from reviewboard where rbnum=?";
			con = DBCPBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rbnum);
			int n = pstmt.executeUpdate();
			return n;
		} catch (SQLException s) {
			s.printStackTrace();
			return -1;
		} finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	public double getAvg() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select sum(score) totscore, count(pdnum) cnt from reviewboard";
		int totscore=0;
		int cnt=0;
		double avg=0;
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totscore=rs.getInt("totscore");
				cnt=rs.getInt("cnt");
			}
			if(cnt==0) {
				avg=0;
			}else {
				avg=totscore/cnt;
			}
			return avg;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public double getAvg(int inum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select NVL(sum(r.score),0) totscore, count(r.pdnum) cntt "
				+ "from reviewboard r join pdetail d on r.pdnum=d.pdnum where d.inum=?";
		double totscore=0;
		double cntt=0;
		double avg=0;
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, inum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totscore=rs.getInt("totscore");
				cntt=rs.getInt("cntt");
			}
			if(cntt==0) {
				avg=0;
			}else {
				avg=Math.round((totscore/cntt)*10)/10.0;
			}
			return avg;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<Reviewboard_Purchase_pDetail_ItemsVo> rList(String rsDesc, String rsAsc, int startRow, int endRow, String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Reviewboard_Purchase_pDetail_ItemsVo> list=new ArrayList<Reviewboard_Purchase_pDetail_ItemsVo>();
		String sql="";
		if(rsDesc!=null && !rsDesc.equals("")) {
			sql="select * \r\n" + 
					"from\r\n" + 
					"(\r\n" + 
					"	select aa.*,rownum rnum\r\n" + 
					"	from(\r\n" + 
					"		select r.rbnum,p.id,i.iname,r.savename,r.pdnum,r.score,r.rbcontent,r.rdate \r\n" + 
					"		from purchase p join pdetail d on p.pnum=d.pnum join items i on d.inum=i.inum \r\n" + 
					"		join reviewboard r on r.pdnum=d.pdnum\r\n" + 
					"		order by score desc)aa\r\n" + 
					")\r\n" + 
					"where rnum>=? and rnum<=?";
		}else if(rsAsc!=null && !rsAsc.equals("")) {
			sql="select * \r\n" + 
					"from\r\n" + 
					"(\r\n" + 
					"	select aa.*,rownum rnum\r\n" + 
					"	from(\r\n" + 
					"		select r.rbnum,p.id,i.iname,r.savename,r.pdnum,r.score,r.rbcontent,r.rdate \r\n" + 
					"		from purchase p join pdetail d on p.pnum=d.pnum join items i on d.inum=i.inum \r\n" + 
					"		join reviewboard r on r.pdnum=d.pdnum\r\n" + 
					"		order by score asc)aa\r\n" + 
					")\r\n" + 
					"where rnum>=? and rnum<=?";
		}else {
			sql="select * \r\n" + 
						"from\r\n" + 
						"(\r\n" + 
						"	select aa.*,rownum rnum\r\n" + 
						"	from(\r\n" + 
						"		select r.rbnum,p.id,i.iname,r.savename,r.pdnum,r.score,r.rbcontent,r.rdate \r\n" + 
						"		from purchase p join pdetail d on p.pnum=d.pnum join items i on d.inum=i.inum \r\n" + 
						"		join reviewboard r on r.pdnum=d.pdnum order by r.rdate desc\r\n" + 
						"		)aa\r\n" + 
						")\r\n" + 
						"where rnum>=? and rnum<=?";
		}
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String buyerid=rs.getString("id");
				int rbnum=rs.getInt("rbnum");
				int pdnum=rs.getInt("pdnum");
				int score=rs.getInt("score");
				String iname=rs.getString("iname");
				String savename=rs.getString("savename");
				String rbcontent=rs.getString("rbcontent");
				Date rdate=rs.getDate("rdate");
				Reviewboard_Purchase_pDetail_ItemsVo vo=new Reviewboard_Purchase_pDetail_ItemsVo(buyerid,rbnum, savename, iname, pdnum, score, rbcontent, rdate);
				list.add(vo);
			}
			return list;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
		public int getCount() {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=DBCPBean.getConn();
				String sql="select NVL(count(pdnum),0) cnt from reviewboard";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				rs.next();
				int cnt=rs.getInt(1);
				return cnt;
			}catch(SQLException se) {
				se.printStackTrace();
				return -1;
			}finally {
				DBCPBean.close(con, pstmt, rs);
			}
	}
}
