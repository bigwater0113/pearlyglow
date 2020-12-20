package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.ReviewBoardVo;
import kr.co.pearlyglow.vo.join.Items_purchase_pdetailVo;
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
	public int getAvg() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select sum(score) totscore, count(pdnum) cnt from reviewboard";
		int totscore=0;
		int cnt=0;
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				totscore=rs.getInt("totscore");
				cnt=rs.getInt("cnt");
			}
			int avg=totscore/cnt;
			return avg;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public ArrayList<Reviewboard_Purchase_pDetail_ItemsVo> rList(int startRow, int endRow, String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Reviewboard_Purchase_pDetail_ItemsVo> list=new ArrayList<Reviewboard_Purchase_pDetail_ItemsVo>();
		String sql="select * \r\n" + 
					"from\r\n" + 
					"(\r\n" + 
					"	select aa.*,rownum rnum\r\n" + 
					"	from(\r\n" + 
					"		select r.rbnum,p.id,i.iname,r.savename,r.pdnum,r.score,r.rbcontent,r.rdate \r\n" + 
					"		from purchase p join pdetail d on p.pnum=d.pnum join items i on d.inum=i.inum \r\n" + 
					"		join reviewboard r on r.pdnum=d.pdnum;\r\n" + 
					"		)aa\r\n" + 
					")\r\n" + 
					"where rnum>=? and rnum<=?";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String buyerid=rs.getString("id");
				int rbnum=rs.getInt("rbdnum");
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
		
		public int getCount(String rsDesc,String rsAsc) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=DBCPBean.getConn();
				String sql="select NVL(count(pdnum),0) cnt from reviewboard";
				if(rsDesc!=null && rsAsc==null) {
					sql+=" order by score desc";
				}else if(rsAsc!=null && rsDesc==null) {
					sql+=" order by score asc";
				}
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
