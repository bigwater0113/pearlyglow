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
	public int getCount(String id,int pDate) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String ppDate="";
		try {
			con=DBCPBean.getConn();
			if(pDate==6) {
				ppDate=" and p.pdate>=(sysdate-180) and p.pdate<=(sysdate) ";
			}else if(pDate==2020){
				ppDate=" and p.pdate>=to_date('2020/01/01','yyyy/mm/dd') and p.pdate<to_date('2021/01/01','yyyy/mm/dd') ";
			}else if(pDate==2019) {
				ppDate=" and p.pdate>=to_date('2019/01/01','yyyy/mm/dd') and p.pdate<to_date('2020/01/01','yyyy/mm/dd') ";
			}else if(pDate==2018) {
				ppDate=" and p.pdate>=to_date('2018/01/01','yyyy/mm/dd') and p.pdate<to_date('2019/01/01','yyyy/mm/dd') ";
			}
			String sql="select count(pDate) " + 
					"from " + 
					"( " + 
					"    select p.id,p.pnum,pd.inum,i.ithumbnail,i.iname,pd.pPay,p.pstatus,p.pdate,d.dcompany,d.trackingnum " + 
					"	from purchase p join pdetail pd   " + 
					"	on p.pnum=pd.pnum  " + 
					"	join items i  " + 
					"	on pd.inum=i.inum  " + 
					"	join delivery d " + 
					"	on p.pnum=d.pnum " + 
					"   where id=\'"+id+"\' " + ppDate +
					"	order by pdate desc " + 
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
	public ArrayList<MyOrder_Purchase_ItemsVo> PI_list(String id,int pDate,int startRow,int endRow){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MyOrder_Purchase_ItemsVo> list=new ArrayList<MyOrder_Purchase_ItemsVo>();
		String ppDate="";
		try {
			if(pDate==6) {
				ppDate=" and p.pdate>=(sysdate-180) and p.pdate<=(sysdate) ";
			}else if(pDate==2020){
				ppDate=" and p.pdate>=to_date('2020/01/01','yyyy/mm/dd') and p.pdate<to_date('2021/01/01','yyyy/mm/dd') ";
			}else if(pDate==2019) {
				ppDate=" and p.pdate>=to_date('2019/01/01','yyyy/mm/dd') and p.pdate<to_date('2020/01/01','yyyy/mm/dd') ";
			}else if(pDate==2018) {
				ppDate=" and p.pdate>=to_date('2018/01/01','yyyy/mm/dd') and p.pdate<to_date('2019/01/01','yyyy/mm/dd') ";
			}
			String sql="select * " + 
					"from " + 
					"( " + 
					"    select rownum rnum, a.*  " + 
					"    from  " + 
					"    (  " + 
					"        select p.id,p.pnum,pd.inum,i.ithumbnail,i.iname,pd.pPay,p.pstatus,p.pdate,d.dcompany,d.trackingnum " + 
					"        from purchase p join pdetail pd " + 
					"        on p.pnum=pd.pnum " + 
					"        join items i  " + 
					"        on pd.inum=i.inum  " + 
					"        join delivery d  " + 
					"        on p.pnum=d.pnum  " + 
					"        where id='"+id+"' " + ppDate +
					"        order by pdate desc " + 
					"    ) a " + 
					")  " + 
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
						rs.getInt("pPay"), 
						rs.getString("pStatus"), 
						rs.getDate("pDate"),
						rs.getString("dCompany"),
						rs.getLong("trackingNum")));
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
