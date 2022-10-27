package admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sameck_module {
	public String sameSearch(String table,String col,String data) {
		String res = null;
		Connection con = null;
		
		try {
			dbConfig db = new dbConfig();
			con = db.cafe24();
			String sql = "select * from "+table+" where "+col+" = "+data;
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()==true) {	//데이터 있음
				res="no";
			}else {
				res="ok";
			}
			
		} catch (Exception e) {
			System.out.println("데이터베이스 오류1");
		}finally {
			
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("데이터베이스 오류2");
			}
		}
		
		
		return res;
	}

}
