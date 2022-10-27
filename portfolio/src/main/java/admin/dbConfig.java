package admin;

import java.sql.*;
public class dbConfig {
	private static String dbdriver = "com.mysql.jdbc.Driver";
	static String dburl = null;
	static String dbuser = null;
	static String dbpw = null;
	
	public static Connection cafe24() throws ClassNotFoundException,SQLException{
		
		
		dburl = "jdbc:mysql://umj7-016.cafe24.com/jwe06120";
		//dburl = "jdbc:mysql://localhost:3306/jwe06120";
		dbuser = "jwe06120";
		dbpw ="code926535";
		
		Class.forName(dbdriver);
		
		Connection con = DriverManager.getConnection(dburl, dbuser, dbpw);
		
		
		return con;
	}
	
}
