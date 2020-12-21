package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.pearlyglow.db.DBCPBean;
import kr.co.pearlyglow.vo.ItemsVo;
import kr.co.pearlyglow.vo.Items_imageVo;

public class itemsDAO {

	private itemsDAO() {
	}

	private static itemsDAO instance = new itemsDAO();

	public static itemsDAO getInstance() {
		return instance;
	}

	public ArrayList<String> searchList() {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ArrayList<String> list = new ArrayList<String>();

		try {
			String sql1 = "select distinct icategory from items";
			con = DBCPBean.getConn();
			pstmt1=con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				list.add(rs1.getString(1));
			}
			
			String sql2 = "select distinct iname from items order by iname asc";
			pstmt2=con.prepareStatement(sql2);
			rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				list.add(rs2.getString(1));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBCPBean.close(null, pstmt2, rs2);
			DBCPBean.close(con, pstmt1, rs1);
		}
	}
	
	public ArrayList<ItemsVo> selectAll(int startItemNum, int endItemnum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();

		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select *\r\n" + 
					"from\r\n" + 
					"(\r\n" + 
					"    select aa.*, rownum rnum\r\n" + 
					"    from\r\n" + 
					"    (\r\n" + 
					"        select * \r\n" + 
					"        from items\r\n" + 
					"        order by iNum desc" +
					"    ) aa\r\n" + 
					")\r\n" + 
					"where rnum >= ? and rnum <= ?");
			ps.setInt(1, startItemNum);
			ps.setInt(2, endItemnum);
			rs = ps.executeQuery();
			while (rs.next()) {
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				String bodyText = rs.getString("bodyText");
				String caution = rs.getString("caution");

				list.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material,
						kDetail, eDetail, iThumbnail, total, bodyText, caution));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return list;
	}

	public ArrayList<ItemsVo> selectGender(String gender) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();

		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select * from items where igender = ? order by iNum desc");
			ps.setString(1, gender);
			rs = ps.executeQuery();
			while (rs.next()) {
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				String bodyText = rs.getString("bodyText");
				String caution = rs.getString("caution");

				list.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material,
						kDetail, eDetail, iThumbnail, total, bodyText, caution));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return list;
	}

	public ItemsVo select(int iNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ItemsVo vo = null;

		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select * from items where iNum = ?");
			ps.setInt(1, iNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				String bodyText = rs.getString("bodyText");
				String caution = rs.getString("caution");

				vo = new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material, kDetail,
						eDetail, iThumbnail, total, bodyText, caution);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return vo;
	}

	public Items_imageVo selectImg(int iNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Items_imageVo vo = null;

		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select * from items_image where iNum = ?");
			ps.setInt(1, iNum);
			rs = ps.executeQuery();
			if (rs.next()) {
				int imgNum = rs.getInt("imgNum");
				String file1 = rs.getString("file1");
				String file2 = rs.getString("file2");
				String file3 = rs.getString("file3");

				vo = new Items_imageVo(imgNum, iNum, file1, file2, file3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return vo;
	}

	public ArrayList<String> selectOptionList(String colunm) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();

		try {
			con = DBCPBean.getConn();
			if (colunm.equals("color")) {
				ps = con.prepareStatement("select color from items group by color");
			} else if (colunm.equals("material")) {
				ps = con.prepareStatement("select material from items group by material");
			} else {
				System.out.println("not found colunm");
				return null;
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return list;

	}

	public ArrayList<ItemsVo> selectSearchItems(String searchCategory, String searchGender, String searchColor,
			String searchMaterial, String searchStock, String searchText, int startItemNum, int endItemNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();

		String sql = "select *\r\n" + 
				"from\r\n" + 
				"(\r\n" + 
				"    select aa.*, rownum rnum\r\n" + 
				"    from\r\n" + 
				"    (\r\n" + 
				"        select * \r\n" + 
				"        from items\r\n" + 
				"        where iNum>0";
		if (!searchCategory.equals("categoryAll")) {
			sql += " and iCategory = '" + searchCategory + "'";
		}
		if (!searchGender.equals("genderAll")) {
			sql += " and iGender = '" + searchGender + "'";
		}
		if (!searchColor.equals("colorAll")) {
			sql += " and color = '" + searchColor + "'";
		}
		if (!searchMaterial.equals("materialAll")) {
			sql += " and material = '" + searchMaterial + "'";
		}
		if (!searchStock.equals("")) {
			sql += " and total < " + searchStock;
		}
		if (!searchText.equals("")) {
			sql += " and iName like '%" + searchText + "%'";
		}
		
		sql +=  " order by iNum desc" +
				"    ) aa\r\n" + 
				")\r\n" + 
				"where rnum >= ? and rnum <= ?";
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, startItemNum);
			ps.setInt(2, endItemNum);
			rs = ps.executeQuery();
			while (rs.next()) {
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				String bodyText = rs.getString("bodyText");
				String caution = rs.getString("caution");
				list.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material,
						kDetail, eDetail, iThumbnail, total, bodyText, caution));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return list;

	}
	
	public int getSearchMaxNum (String searchCategory, String searchGender, String searchColor,
			String searchMaterial, String searchStock, String searchText, int startItemNum, int endItemNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int maxNum = 0;
		
		String sql = "select count(*)\r\n" + 
				"from items\r\n" + 
				"where iNum>0";
		if (!searchCategory.equals("categoryAll")) {
			sql += " and iCategory = '" + searchCategory + "'";
		}
		if (!searchGender.equals("genderAll")) {
			sql += " and iGender = '" + searchGender + "'";
		}
		if (!searchColor.equals("colorAll")) {
			sql += " and color = '" + searchColor + "'";
		}
		if (!searchMaterial.equals("materialAll")) {
			sql += " and material = '" + searchMaterial + "'";
		}
		if (!searchStock.equals("")) {
			sql += " and total < " + searchStock;
		}
		if (!searchText.equals("")) {
			sql += " and iName like '%" + searchText + "%'";
		}
		
		
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				maxNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}
		
		return maxNum;
		
	}

	public int update(ItemsVo vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("update items set iName =  ?, price = ?, iGender = ?, iCategory = ?, color = ?,"
					+ "iSize = ?, weight = ?, material = ?, Kdetail = ?, eDetail = ?, total = ?, bodyText = ?, caution = ? where iNum = ?");
			ps.setString(1, vo.getiName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getiGender());
			ps.setString(4, vo.getiCategory());
			ps.setString(5, vo.getColor());
			ps.setString(6, vo.getiSize());
			ps.setInt(7, vo.getWeight());
			ps.setString(8, vo.getMaterial());
			ps.setString(9, vo.getkDetail());
			ps.setString(10, vo.geteDetail());
			ps.setInt(11, vo.getTotal());
			ps.setString(12, vo.getBodyText());
			ps.setString(13, vo.getCaution());
			ps.setInt(14, vo.getiNum());

			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return n;
	}

	public int delete(int iNum) {
		Connection con = null;
		PreparedStatement ps = null;

		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("delete from items where inum = ?");
			ps.setInt(1, iNum);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, null);
		}

		return n;
	}

	public int deleteImg(int iNum) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("delete from items_image where inum = ?");
			ps.setInt(1, iNum);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, null);
		}

		return n;
	}

	public int getTotalMaxNum() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;

		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select nvl(count(iNum), 0) count from items");
			rs = ps.executeQuery();
			if (rs.next()) {
				n = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}

		return n;
	}

	public int getGenderMaxNum(String gender) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select NVL(count(iNum), 0) count from items where igender = ?");
			ps.setString(1, gender);
			rs = ps.executeQuery();

			if (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}
		return n;
	}

	public ArrayList<ItemsVo> selectGenderPageContents(int startItemNum, int endItemNum, String gender) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();

		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select *\r\n"+ "from\r\n" + "(\r\n" + "    select tt.*, rownum rnum\r\n"
					+ "    from \r\n" + "    (\r\n" + "            select *\r\n" + "            from items\r\n"
					+ "			 where iGender = ?" + " order by iNum desc" + "    ) tt\r\n" + ")\r\n" + "where rnum >= ? and rnum <= ?");
			ps.setString(1, gender);
			ps.setInt(2, startItemNum);
			ps.setInt(3, endItemNum);
			rs = ps.executeQuery();

			while (rs.next()) {
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				String bodyText = rs.getString("bodyText");
				String caution = rs.getString("caution");

				list.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material,
						kDetail, eDetail, iThumbnail, total, bodyText, caution));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}
		return list;
	}

	public int getCategoryMaxNum(String category) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		int n = 0;
		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select NVL(count(iNum), 0) count from items where iCategory = ?");
			ps.setString(1, category);
			rs = ps.executeQuery();

			if (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}
		return n;
	}

	public ArrayList<ItemsVo> selectCategoryPageContents(int startItemNum, int endItemNum, String category) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<ItemsVo> list = new ArrayList<ItemsVo>();

		try {
			con = DBCPBean.getConn();
			ps = con.prepareStatement("select *\r\n" + "from\r\n" + "(\r\n" + "    select tt.*, rownum rnum\r\n"
					+ "    from \r\n" + "    (\r\n" + "            select *\r\n" + "            from items\r\n"
					+ "			 where iCategory = ?" + " order by iNum desc" + "    ) tt\r\n" + ")\r\n" + "where rnum >= ? and rnum <= ?");
			ps.setString(1, category);
			ps.setInt(2, startItemNum);
			ps.setInt(3, endItemNum);
			rs = ps.executeQuery();

			while (rs.next()) {
				int iNum = rs.getInt("iNum");
				String iName = rs.getString("iName");
				int price = rs.getInt("price");
				int iSale = rs.getInt("iSale");
				String iGender = rs.getString("iGender");
				String iCategory = rs.getString("iCategory");
				String color = rs.getString("color");
				String iSize = rs.getString("iSize");
				int weight = rs.getInt("weight");
				String material = rs.getString("material");
				String kDetail = rs.getString("kDetail");
				String eDetail = rs.getString("eDetail");
				String iThumbnail = rs.getString("iThumbnail");
				int total = rs.getInt("total");
				String bodyText = rs.getString("bodyText");
				String caution = rs.getString("caution");

				list.add(new ItemsVo(iNum, iName, price, iSale, iGender, iCategory, color, iSize, weight, material,
						kDetail, eDetail, iThumbnail, total, bodyText, caution));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCPBean.close(con, ps, rs);
		}
		return list;
	}
}
