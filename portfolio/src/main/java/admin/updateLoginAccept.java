package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import admin.module.dbConfig;

public class updateLoginAccept {
	public String changeAccept(String aidx, String sign) {
		String res = null;
		Connection con = null;
		try {
			dbConfig db = new dbConfig();
			con = db.cafe24();
			String sql = "update admin_member set login_accept='"+sign+"' where aidx='"+aidx+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			int n = ps.executeUpdate();
			if(n>0) {
				res = "ok";
			}else {
				throw new Exception("error");
			}
			
		} catch (Exception e) {
			System.out.println("db error change accept1");
		}finally {
			
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("db error change accept2");
			}
		}
		
		return res;
	}
}
