package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.MembersVo;

public class MembersDao {
	public ArrayList<MembersVo> list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from members";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<MembersVo> memberlist=new ArrayList<MembersVo>();
			while(rs.next()) {
				MembersVo vo=new MembersVo(
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name"),
						rs.getDate("birth"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phone"), 
						rs.getString("address"),
						rs.getString("isSleep"),
						rs.getDate("recentAcc"));
				memberlist.add(vo);
			}
			return memberlist;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public int insert(MembersVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="insert into members values(?,?,?,?,?,?,?,?,?,sysdate)";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getPwd());
			pstmt.setString(3,vo.getName());
			pstmt.setDate(4, vo.getBirth());
			pstmt.setString(5,vo.getGender());
			pstmt.setString(6,vo.getEmail());
			pstmt.setString(7,vo.getPhone());
			pstmt.setString(8,vo.getAddress());
			pstmt.setString(9,vo.getIssleep());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt,null);
		}
	}
	
	public int delete(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from members where id=?";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt,null);
		}
	}
	public MembersVo getinfo(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from members where id=?";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				MembersVo vo=new MembersVo(
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name"),
						rs.getDate("birth"),
						rs.getString("gender"),
						rs.getString("email"),
						rs.getString("phone"), 
						rs.getString("address"),
						rs.getString("isSleep"),
						rs.getDate("recentAcc"));
				return vo;
			}
			return null;
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	public int update(MembersVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update members set pwd=?,email=?,phone=?,address=?,isSleep=?,recentAcc=sysdate where id=?";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,vo.getPwd());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3,vo.getPhone());
			pstmt.setString(4,vo.getAddress());
			pstmt.setString(5, vo.getIssleep());
			pstmt.setString(6, vo.getId());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt,null);
		}
	}
}

















