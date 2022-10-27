package admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginck_module {
	public String idSearch(String aid){
		String res = null;
		Connection con = null;
		try {
			dbConfig db = new dbConfig();
			con = db.cafe24();
			
			String sql = "select * from admin_member where aid='"+aid+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
						
			if(rs.next()==true) {	//true : 데이터가 있음
				res = "no";
			}else {	//false: 데이터가 없음
				res = "ok";
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 오류1");
		} finally {
			try {				
				con.close();
			} catch (SQLException e) {
				System.out.println("데이터베이스 오류2");
			}
		}
		
		
		
		
		
		return res;
	}
}
