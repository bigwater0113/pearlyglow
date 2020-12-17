package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.PDetailVo;
import kr.co.pearlyglow.vo.ReviewBoardVo;

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
}
