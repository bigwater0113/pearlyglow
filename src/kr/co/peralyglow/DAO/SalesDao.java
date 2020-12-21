package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;

public class SalesDao {
	private static SalesDao instance=new SalesDao();
	
	private SalesDao() {}
	
	public static SalesDao getInstance() {
		return instance;
	}
	public int getSalesYear(String category,String gender,int year,int month) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			
			StringBuffer sql=new StringBuffer("");
			sql.append("select NVL(sum(ppay),0) " + 
					"from ( select i.inum,i.igender,i.icategory,pd.ppay,p.pdate " + 
					"from items i join pdetail pd " + 
					"on i.inum=pd.inum " + 
					"join purchase p " + 
					"on p.pnum=pd.pnum " +
					"where icategory like '%"+category+"%' and igender like '%"+ gender +"%' " + 
					"and pdate>=to_date('"+year+"/"+month+"','yyyy/mm') ");
					if (month==12) {
						month=0;
						year++;
					}
					sql.append("and pdate<to_date('"+year+"/"+(month+1)+"','yyyy/mm')-1)");
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt("NVL(sum(ppay),0)");
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	public int getSalesMonth(String category,String gender,int year,int month,int day) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select NVL(sum(ppay),0) " + 
					"from ( select i.inum,i.igender,i.icategory,pd.ppay,p.pdate " + 
					"from items i join pdetail pd " + 
					"on i.inum=pd.inum " + 
					"join purchase p " + 
					"on p.pnum=pd.pnum " +
					"where icategory like '%"+category+"%' and igender like '%"+ gender +"%' "+
					"and pdate>=to_date('"+year+"/"+month+"/"+day+"','yyyy/mm/dd') and pdate<to_date('"+year+"/"+month+"/"+day+"','yyyy/mm/dd')+1)";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			rs.next();
			return rs.getInt("NVL(sum(ppay),0)");
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
}
