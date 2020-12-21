package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.MembersVo;

public class MembersDao {
	public int lockN(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update members set issleep='N' where id=?";
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
	
	public int lockY(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update members set issleep='Y' where id=?";
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
	
	public ArrayList<MembersVo> lock() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from members where sysdate-recentacc>=200";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			ArrayList<MembersVo> list=new ArrayList<MembersVo>();
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
	
	public ArrayList<MembersVo> list(int startRowNum, int endRowNum,String field,String keyword){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		if(field!=null && !field.equals("")) {
			if(field.equals("gender") || field.equals("issleep")) {
				sql="select * from " + 
				        "(" + 
				           "  select aa.*,rownum rnum from" + 
				           "  ( " + 
				           "    select * from members  where "+ field + "= '" + keyword.toUpperCase() + "'"+ 
				           "    order by recentAcc desc " + 
				           "  )aa " + 
				           ") where rnum>=? and rnum<=?"; 
			}else {
				sql="select * from " + 
			        "(" + 
			           "  select aa.*,rownum rnum from" + 
			           "  ( " + 
			           "    select * from members  where "+ field + " like '%" + keyword +"%'" + 
			           "    order by recentAcc desc " + 
			           "  )aa " + 
			           ") where rnum>=? and rnum<=?";   
			}
		}else {
			sql= "select * from " + 
		         "(" + 
		          "  select aa.*,rownum rnum from" + 
		          "  ( " + 
		          "    select * from members " + 
		          "    order by recentAcc desc " + 
		          "  )aa " + 
		          ") where rnum>=? and rnum<=?";   
		}
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRowNum);
			pstmt.setInt(2, endRowNum);
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
	
	public int getCount(String field,String keyword) {
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	       con=DBCPBean.getConn();
	       String sql="select NVL(count(id),0) cnt from members";
	       if(field!=null && !field.equals("")) {
	          sql += " where "+ field + " like '%"+ keyword + "%'";
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
	
	// **************************** Èñ±Ç **********************************
	
	public MembersVo select (String id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MembersVo vo = null;
		
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select * from members where id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				vo = new MembersVo(id, null, name, null, null, email, phone, address, null, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
		
	}
}

















