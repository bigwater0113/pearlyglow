package kr.co.peralyglow.DAO;

import java.sql.Connection;
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
	
	public ArrayList<Items_purchase_pdetailVo> pList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Items_purchase_pdetailVo> list=new ArrayList<Items_purchase_pdetailVo>();
		try {
			String sql="select p.pnum, d.pdnum, i.iname, i.ithumbnail, d.pcnt, "
					+ "p.pdate from purchase p join pdetail d on p.pnum=d.pnum join "
					+ "items on d.inum=d.inum";
			con=DBCPBean.getConn();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int pnum=rs.getInt("pnum");
				int pdnum=rs.getInt("pdnum");
				String iname=rs.getString("iname");
				String ithumbnail=rs.getString("ithumbnail");
				int pcnt=rs.getInt("pcnt");
				String pdate=rs.getString("pdate");
				Items_purchase_pdetailVo vo=new Items_purchase_pdetailVo();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
