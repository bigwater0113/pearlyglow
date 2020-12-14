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
	public ArrayList<MyOrder_Purchase_ItemsVo> PI_list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MyOrder_Purchase_ItemsVo> list=new ArrayList<MyOrder_Purchase_ItemsVo>();
		try {
			String sql="select p.id,p.pnum,d.inum,ii.imgName,i.iname,p.ptotal,p.pstatus,p.pdate " + 
					"from purchase p join pdetail d " + 
					"on p.pnum=d.pnum " + 
					"join items i  " + 
					"on d.inum=i.inum " + 
					"join items_image ii " + 
					"on i.inum=ii.inum";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MyOrder_Purchase_ItemsVo(
						rs.getString("id"), 
						rs.getInt("pNum"), 
						rs.getInt("iNum"), 
						rs.getString("imgName"), 
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
