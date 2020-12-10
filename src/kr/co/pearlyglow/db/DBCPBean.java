package kr.co.pearlyglow.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
Context initContext = new InitialContext();
Context envContext  = (Context)initContext.lookup("java:/comp/env");
DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
 */

public class DBCPBean {
	private static DataSource ds;
	//static블록 - static멤버변수를 초기화할때 사용
	static {
		try {
			System.out.println("static블록실행...");
			Context initContext;
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}
	public static Connection getConn() throws SQLException{
		Connection con=ds.getConnection();
		return con;
	}
}
