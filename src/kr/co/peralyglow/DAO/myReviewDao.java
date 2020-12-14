package kr.co.peralyglow.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.pearlyglow.vo.join.MyReviewVo;

public class myReviewDao {
	private static myReviewDao instance=new myReviewDao();
	
	private myReviewDao() {}
	
	public static myReviewDao getInstance() {
		return instance;
	}
	
	public ArrayList<MyReviewVo> MR_list(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<MyReviewVo> list=new ArrayList<MyReviewVo>();
		try {
			
		}
	}
}
