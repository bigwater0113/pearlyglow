package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.QnABoardVo;

public class BoardDao {
	public ArrayList<QnABoardVo> myinfo(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from QnABoard where id=?";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			ArrayList<QnABoardVo> list = new ArrayList<QnABoardVo>();
			while(rs.next()) {
				QnABoardVo vo=new QnABoardVo(
						rs.getInt("ibNum"),
						rs.getString("id"),
						rs.getInt("iNum"),
						rs.getString("qCategory"),
						rs.getString("qTitle"), 
						rs.getString("ibPwd"), 
						rs.getString("ibContent"), 
						rs.getString("orgName"), 
						rs.getString("saveName"), 
						rs.getDate("ibDate"),
						rs.getString("ans"),
						rs.getDate("ansDate"));
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
	
	public QnABoardVo getinfo(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from QnABoard where ibnum=?";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				QnABoardVo vo=new QnABoardVo(
						rs.getInt("ibNum"),
						rs.getString("id"),
						rs.getInt("iNum"),
						rs.getString("qCategory"),
						rs.getString("qTitle"), 
						rs.getString("ibPwd"), 
						rs.getString("ibContent"), 
						rs.getString("orgName"), 
						rs.getString("saveName"), 
						rs.getDate("ibDate"),
						rs.getString("ans"),
						rs.getDate("ansDate"));
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
	
	public int getCount(String field,String keyword) {
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	       con=DBCPBean.getConn();
	       String sql="select NVL(count(ibnum),0) cnt from QnABoard";
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

	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			con = DBCPBean.getConn();
			String sql = "select NVL(max(ibnum),0) maxnum from QnABoard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			rs.next();
			int maxnum = rs.getInt("maxnum");
			return maxnum;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public int insert(QnABoardVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into QnABoard values(?,?,?,?,?,?,?,?,?,sysdate,?,null)";
		try {
			con = DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, vo.getId());
			if(vo.getiNum()==0) {
				pstmt.setString(3, null);
			}else {
				pstmt.setInt(3, vo.getiNum());
			}
			pstmt.setString(4, vo.getqCategory());
			pstmt.setString(5, vo.getqTitle());
			pstmt.setString(6, vo.getIbPwd());
			pstmt.setString(7, vo.getIbContent());
			pstmt.setString(8, vo.getOrgName());
			pstmt.setString(9, vo.getSaveName());
			pstmt.setString(10, vo.getAns());
			pstmt.executeUpdate();
			return 1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	
	public ArrayList<QnABoardVo> list(int startRowNum, int endRowNum,String field,String keyword){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="";
		if(field!=null && !field.equals("")) {
			sql="select * from " + 
		        "(" + 
		           "  select aa.*,rownum rnum from" + 
		           "  ( " + 
		           "    select * from QnABoard  where "+ field + " like '%" + keyword +"%'" + 
		           "    order by ibnum desc " + 
		           "  )aa " + 
		           ") where rnum>=? and rnum<=?";                     
		}else {
			sql= "select * from " + 
		         "(" + 
		          "  select aa.*,rownum rnum from" + 
		          "  ( " + 
		          "    select * from QnABoard " + 
		          "    order by ibnum desc " + 
		          "  )aa " + 
		          ") where rnum>=? and rnum<=?";   
		}

		try {
			con = DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRowNum);
			pstmt.setInt(2, endRowNum);
			rs=pstmt.executeQuery();
			ArrayList<QnABoardVo> list = new ArrayList<QnABoardVo>();
			while(rs.next()) {
				int ibNum = rs.getInt("ibNum");
				String id = rs.getString("id");
				int iNum = rs.getInt("iNum");
				String qCategory = rs.getString("qCategory");
				String qTitle = rs.getString("qTitle");
				String ibPwd = rs.getString("ibPwd");
				String ibContent = rs.getString("ibContent");
				String orgName = rs.getString("orgName");
				String saveName = rs.getString("saveName");
				Date ibDate = rs.getDate("ibDate");
				String ans = rs.getString("ans");
				Date ansDate = rs.getDate("ansDate");
				QnABoardVo vo = new QnABoardVo(ibNum, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName,ibDate, ans, ansDate);
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
	
	public int delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from QnABoard where ibNum=?";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt,null);
		}
	}
	
	public int update(QnABoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update QnABoard set iNum=?,ibPwd=?,ibContent=? where ibNum=?";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			if(vo.getiNum()==0) {
				pstmt.setString(1, null);
			}else {
				pstmt.setInt(1, vo.getiNum());
			}
			pstmt.setString(2,vo.getIbPwd());
			pstmt.setString(3,vo.getIbContent());
			pstmt.setInt(4,vo.getIbNum());
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt,null);
		}
	}
	
	public QnABoardVo detail(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from QnABoard where ibNum = ?";
		try {
			con = DBCPBean.getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				int iNum = rs.getInt("iNum");
				String qCategory = rs.getString("qCategory");
				String qTitle = rs.getString("qTitle");
				String ibPwd = rs.getString("ibPwd");
				String ibContent = rs.getString("ibContent");
				String orgName = rs.getString("orgName");
				String saveName = rs.getString("saveName");
				Date ibDate = rs.getDate("ibDate");
				String ans = rs.getString("ans");
				Date ansDate = rs.getDate("ansDate");
				QnABoardVo vo = new QnABoardVo(num, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName, ibDate, ans, ansDate);
				return vo;
			}else {
				return null;
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		} finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public int answer(int num, String ans) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update QnABoard set ans=?, ansDate=sysdate where ibNum=?";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,ans);
			pstmt.setInt(2, num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt,null);
		}
	}
	
	public int a_delete(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="update QnABoard set ans=null, ansDate=null where ibNum=?";
		try {
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int n=pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt,null);
		}
	}
	
	public ArrayList<QnABoardVo> ansList(int startRowNum, int endRowNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql= "select * from " + 
	         "(" + 
	          "  select aa.*,rownum rnum from" + 
	          "  ( " + 
	          "    select * from QnABoard where ans IS NOT NULL" + 
	          "    order by ibnum desc " + 
	          "  )aa " + 
	          ") where rnum>=? and rnum<=?";   

		try {
			con = DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRowNum);
			pstmt.setInt(2, endRowNum);
			rs=pstmt.executeQuery();
			ArrayList<QnABoardVo> list = new ArrayList<QnABoardVo>();
			while(rs.next()) {
				int ibNum = rs.getInt("ibNum");
				String id = rs.getString("id");
				int iNum = rs.getInt("iNum");
				String qCategory = rs.getString("qCategory");
				String qTitle = rs.getString("qTitle");
				String ibPwd = rs.getString("ibPwd");
				String ibContent = rs.getString("ibContent");
				String orgName = rs.getString("orgName");
				String saveName = rs.getString("saveName");
				Date ibDate = rs.getDate("ibDate");
				String ans = rs.getString("ans");
				Date ansDate = rs.getDate("ansDate");
				QnABoardVo vo = new QnABoardVo(ibNum, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName, ibDate, ans, ansDate);
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
	
	public ArrayList<QnABoardVo> unAnsList(int startRowNum, int endRowNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql= "select * from " + 
		         "(" + 
		          "  select aa.*,rownum rnum from" + 
		          "  ( " + 
		          "    select * from QnABoard where ans IS NULL" + 
		          "    order by ibnum desc " + 
		          "  )aa " + 
		          ") where rnum>=? and rnum<=?";   

		try {
			con = DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,startRowNum);
			pstmt.setInt(2, endRowNum);
			rs=pstmt.executeQuery();
			ArrayList<QnABoardVo> list = new ArrayList<QnABoardVo>();
			while(rs.next()) {
				int ibNum = rs.getInt("ibNum");
				String id = rs.getString("id");
				int iNum = rs.getInt("iNum");
				String qCategory = rs.getString("qCategory");
				String qTitle = rs.getString("qTitle");
				String ibPwd = rs.getString("ibPwd");
				String ibContent = rs.getString("ibContent");
				String orgName = rs.getString("orgName");
				String saveName = rs.getString("saveName");
				Date ibDate = rs.getDate("ibDate");
				String ans = rs.getString("ans");
				Date ansDate = rs.getDate("ansDate");
				QnABoardVo vo = new QnABoardVo(ibNum, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName, ibDate, ans, ansDate);
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
}
