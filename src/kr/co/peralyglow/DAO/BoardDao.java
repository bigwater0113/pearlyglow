package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.QnABoardVo;

public class BoardDao {
	public ArrayList<ItemsVo> iNumList(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();
		
		try {
			String sql = "select inum,iname from items";
			con = DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ItemsVo vo = new ItemsVo(Integer.parseInt(rs.getString("iNum")), rs.getString("iName"), 0, 0, null, null, null, null, 0, null, null, null, null, 0, null, null);
				list.add(vo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public int myinfoGetCount(String id) {
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	       con=DBCPBean.getConn();
	       String sql="select count(ibNum) from QnABoard where ref in (select ref from QnABoard where id=? and lev=0) order by ref desc, step asc";
	       pstmt=con.prepareStatement(sql);
	       pstmt.setString(1, id);
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
	
	public ArrayList<QnABoardVo> myinfo(String id,int startRowNum, int endRowNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from " + 
			         "(" + 
			          "  select aa.*,rownum rnum from" + 
			          "  ( " + 
			          "select * from QnABoard where ref in (select ref from QnABoard where id=? and lev=0) order by ref desc, step asc"+
			          "  )aa " + 
			          ") where rnum>=? and rnum<=?";   
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRowNum);
			pstmt.setInt(3, endRowNum);
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
						rs.getDate("ansDate"),
						rs.getInt("ref"),
						rs.getInt("lev"),
						rs.getInt("step"));
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
						rs.getDate("ansDate"),
						rs.getInt("ref"),
						rs.getInt("lev"),
						rs.getInt("step"));
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
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con = DBCPBean.getConn();
			int ibnum=getMaxNum()+1; //등록될 글번호
			int num = vo.getIbNum();
			int ref = vo.getRef();
			int lev = vo.getLev();
			int step = vo.getStep();
			if(num==0) { //새글인경우
				ref=ibnum;
			}else { //답글인경우
				String sql1="update QnABoard set step=step+1 where ref=? and step>?";
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, ref);
				pstmt1.setInt(2, step);
				pstmt1.executeUpdate();
				lev += 1;
				step += 1;
			}
			num = ibnum;
			
			String sql = "insert into QnABoard values(?,?,?,?,?,?,?,?,?,sysdate,?,null,?,?,?)";
			pstmt2=con.prepareStatement(sql);
			pstmt2.setInt(1, ibnum);
			pstmt2.setString(2, vo.getId());
			if(vo.getiNum()==0) {
				pstmt2.setString(3, null);
			}else {
				pstmt2.setInt(3, vo.getiNum());
			}
			pstmt2.setString(4, vo.getqCategory());
			pstmt2.setString(5, vo.getqTitle());
			pstmt2.setString(6, vo.getIbPwd());
			pstmt2.setString(7, vo.getIbContent());
			pstmt2.setString(8, vo.getOrgName());
			pstmt2.setString(9, vo.getSaveName());
			pstmt2.setString(10, vo.getAns());
			pstmt2.setInt(11, ref);
			pstmt2.setInt(12, lev);
			pstmt2.setInt(13, step);
			pstmt2.executeUpdate();
			return 1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(pstmt1);
			DBCPBean.close(con, pstmt2, null);
		}
	}
	
	public ArrayList<QnABoardVo> list(int startRowNum, int endRowNum,String field,String keyword){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="";
		if(field!=null && !field.equals("")) {
			if(field.equals("noId")) {
				sql="select * from " + 
				        "(" + 
				           "  select aa.*,rownum rnum from" + 
				           "  ( " + 
				           "    select * from QnABoard  where id is null" + 
				           "    order by ref desc, step asc " + 
				           "  )aa " + 
				           ") where rnum>=? and rnum<=?";  
			}else {
				sql="select * from " + 
			        "(" + 
			           "  select aa.*,rownum rnum from" + 
			           "  ( " + 
			           "    select * from QnABoard  where "+ field + " like '%" + keyword +"%'" + 
			           "    order by ref desc, step asc " + 
			           "  )aa " + 
			           ") where rnum>=? and rnum<=?";  
			}
		}else {
			sql= "select * from " + 
		         "(" + 
		          "  select aa.*,rownum rnum from" + 
		          "  ( " + 
		          "    select * from QnABoard " + 
		          "    order by ref desc, step asc " + 
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
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
				QnABoardVo vo = new QnABoardVo(ibNum, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName,ibDate, ans, ansDate,ref,lev,step);
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
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
				QnABoardVo vo = new QnABoardVo(num, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName, ibDate, ans, ansDate, ref, lev, step);
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
	
	public int answer(QnABoardVo vo) {
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=DBCPBean.getConn();
			int ibNum=getMaxNum()+1; //등록될 글번호
			int num = vo.getIbNum();
			int ref = vo.getRef();
			int lev = vo.getLev();
			int step = vo.getStep();
			if(num==0) { //새글인경우
				ref=ibNum;
			}else { //답글인경우
				String sql1="update QnABoard set step=step+1, ansDate=sysdate where ref=? and step>?";
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setInt(1, ref);
				pstmt1.setInt(2, step);
				pstmt1.executeUpdate();
				lev += 1;
				step += 1;
			}
			num=ibNum;
			
			String sql = "insert into QnABoard values(?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?)";
			pstmt2=con.prepareStatement(sql);
			pstmt2.setInt(1, ibNum);
			pstmt2.setString(2, vo.getId());
			if(vo.getiNum()==0) {
				pstmt2.setString(3, null);
			}else {
				pstmt2.setInt(3, vo.getiNum());
			}
			pstmt2.setString(4, vo.getqCategory());
			pstmt2.setString(5, vo.getqTitle());
			pstmt2.setString(6, vo.getIbPwd());
			pstmt2.setString(7, vo.getIbContent());
			pstmt2.setString(8, vo.getOrgName());
			pstmt2.setString(9, vo.getSaveName());
			pstmt2.setDate(10, vo.getIbDate());
			pstmt2.setString(11, vo.getAns());
			pstmt2.setInt(12, ref);
			pstmt2.setInt(13, lev);
			pstmt2.setInt(14, step);
			pstmt2.executeUpdate();
			return 1;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(pstmt1);
			DBCPBean.close(con, pstmt2, null);
		}
	}
	public int u_answer(int num, String ans) {
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
	          "    select * from qnaboard where ref in" + 
	          "    (select distinct ref from qnaboard group by ref,lev having lev>0)" + 
	          "  	order by ref desc, step asc " + 
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
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
				QnABoardVo vo = new QnABoardVo(ibNum, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName, ibDate, ans, ansDate, ref, lev, step);
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
	
	public int AnsgetCount() {
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	       con=DBCPBean.getConn();
	       String sql="select NVL(count(ibnum),0) cnt from qnaboard where ref in " + 
	       		"(select distinct ref from qnaboard group by ref,lev having lev>0) " + 
	       		"order by ref desc, step asc";
	       
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
	
	public ArrayList<QnABoardVo> unAnsList(int startRowNum, int endRowNum){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql= "select * from " + 
		         "(" + 
		          "  select aa.*,rownum rnum from" + 
		          "  ( " + 
		          "    select * from qnaboard where not ref in" + 
		          "    (select distinct ref from qnaboard group by ref,lev having lev>0) " + 
		          "  	order by ref asc, step asc " + 
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
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int step=rs.getInt("step");
				QnABoardVo vo = new QnABoardVo(ibNum, id, iNum, qCategory, qTitle, ibPwd, ibContent, orgName, saveName, ibDate, ans, ansDate, ref, lev, step);
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
	
	public int unAnsgetCount() {
		Connection con=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    try {
	       con=DBCPBean.getConn();
	       String sql="select NVL(count(ibnum),0) cnt from qnaboard where not ref in " + 
	       		"(select distinct ref from qnaboard group by ref,lev having lev>0) " + 
	       		"order by ref asc, step asc";
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
