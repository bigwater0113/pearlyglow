package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.join.MyOrder_Purchase_ItemsVo;

public class myOrderDao {
	private static myOrderDao instance=new myOrderDao();
	
	private myOrderDao() {}
	
	public static myOrderDao getInstance() {
		return instance;
	}
	public int getCount(String id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DBCPBean.getConn();
			String sql="select count(pDate) " + 
					"from " + 
					"( " + 
					"    select p.id,p.pnum,d.inum,i.ithumbnail,i.iname,p.ptotal,p.pstatus,p.pdate " + 
					"    from purchase p join pdetail d  " + 
					"    on p.pnum=d.pnum " + 
					"    join items i " + 
					"    on d.inum=i.inum " + 
					"    where id=\'"+id+"\' " + 
					"    order by pdate desc " + 
					")";
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
	public ArrayList<MyOrder_Purchase_ItemsVo> PI_list(String id,int startRow,int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MyOrder_Purchase_ItemsVo> list=new ArrayList<MyOrder_Purchase_ItemsVo>();
		try {
			String sql="select * " + 
					"from " + 
					"(  " + 
					"    select rownum rnum, a.*  " + 
					"    from " + 
					"    ( " + 
					"        select p.id,p.pnum,d.inum,i.ithumbnail,i.iname,p.ptotal,p.pstatus,p.pdate " + 
					"        from purchase p join pdetail d " + 
					"        on p.pnum=d.pnum " + 
					"        join items i " + 
					"        on d.inum=i.inum " + 
					"        where id=\'"+id+"\' " + 
					"        order by pdate desc " + 
					"    ) a " + 
					") " + 
					"where rnum>=? and rnum<=?";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MyOrder_Purchase_ItemsVo(
						rs.getString("id"), 
						rs.getInt("pNum"), 
						rs.getInt("iNum"), 
						rs.getString("iThumbnail"), 
						rs.getString("iName"), 
						rs.getInt("pTotal"), 
						rs.getString("pStatus"), 
						rs.getDate("pDate")));
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
