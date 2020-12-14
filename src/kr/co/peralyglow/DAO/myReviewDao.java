package kr.co.peralyglow.DAO;

import java.util.ArrayList;

import kr.co.pearlyglow.vo.join.MyReviewVo;

public class myReviewDao {
	private static myReviewDao instance=new myReviewDao();
	
	private myReviewDao() {}
	
	public static myReviewDao getInstance() {
		return instance;
	}
	
	public ArrayList<MyReviewVo> MR_list(){
		
	}
}
