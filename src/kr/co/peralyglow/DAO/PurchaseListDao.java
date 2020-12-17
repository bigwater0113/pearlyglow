package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.join.Items_purchase_pdetailVo;

public class PurchaseListDao {
	private static PurchaseListDao instance=new PurchaseListDao();
	private PurchaseListDao() {}
	public static PurchaseListDao getInstance() {
		return instance;
	}
	
	public ArrayList<Items_purchase_pdetailVo> pList(int startrow, int endrow, String p_date){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="";
		ArrayList<Items_purchase_pdetailVo> list=new ArrayList<Items_purchase_pdetailVo>();
		if(p_date!=null && !p_date.equals("")) {
			sql="select * \r\n" + 
					"from\r\n" + 
					"(" + 
					"	select aa.*,rownum rnum \r\n" + 
					"	from(" + 
					"		select p.pnum, d.pdnum, i.iname, d.pcnt, d.ppay, p.ptotal,i.ithumbnail,p.pdate \r\n" + 
					"		from purchase p join pdetail d on p.pnum=d.pnum join items i on i.inum=d.inum\r\n" + 
					"		where '"+p_date+"' = p.pdate \r\n" + 
					"		order by p.pdate desc\r\n" + 
					"		)aa" + 
					")\r\n" + 
					"where rnum>=? and rnum<=?";
		}else { 
			sql="select * \r\n" + 
					"from\r\n" + 
					"(\r\n" + 
					"	select aa.*,rownum rnum \r\n" + 
					"	from(" + 
					"		select p.pnum, d.pdnum, i.iname, d.pcnt, d.ppay, p.ptotal,i.ithumbnail,p.pdate \r\n" + 
					"		from purchase p join pdetail d on p.pnum=d.pnum join items i on i.inum=d.inum\r\n" + 
					"		order by p.pdate desc" + 
					"		)aa" + 
					")" + 
					"where rnum>=? and rnum<=?";
		}
			try {
				con=DBCPBean.getConn();
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next()) {
				int pnum=rs.getInt("pnum");
				int pdnum=rs.getInt("pdnum");
				String iname=rs.getString("iname");
				int ppay=rs.getInt("ppay");
				int pcnt=rs.getInt("pcnt");
				int ptotal=rs.getInt("ptotal");
				String ithumbnail=rs.getString("ithumbnail");
				Date pdate=rs.getDate("pdate");
				Items_purchase_pdetailVo vo=new Items_purchase_pdetailVo(pnum,pdnum,iname,pcnt,ppay,ptotal,ithumbnail,pdate);
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
		public int getCount(String p_date) {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=DBCPBean.getConn();
				String sql="select NVL(count(pdnum),0) pdnum from pdetail";
				if(p_date!=null && !p_date.equals("")) {
					sql += " where "+p_date+"==pdate";
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
