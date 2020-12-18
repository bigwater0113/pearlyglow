package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.DeliveryVo;
import kr.co.pearlyglow.vo.join.MyDeliveryVo;

public class myDeliveryDao {
	private static myDeliveryDao instance=new myDeliveryDao();
	
	private myDeliveryDao() {}
	
	public static myDeliveryDao getInstance() {
		return instance;
	}
	
	public MyDeliveryVo select(String id,int pNum) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select p.id,p.receiver,p.paddress,d.pnum,d.dcompany,d.trackingnum,d.dstatus " + 
					"from purchase p join delivery d " + 
					"on p.pnum=d.pnum " + 
					"where id='"+id+"' and p.pNum=?";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				MyDeliveryVo vo=new MyDeliveryVo(
						rs.getString("id"),
						rs.getString("receiver"),
						rs.getString("pAddress"), 
						rs.getInt("pNum"), 
						rs.getString("dCompany"), 
						rs.getLong("trackingNum"), 
						rs.getString("dStatus"));
				return vo;
			}else {
				return null;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
}
