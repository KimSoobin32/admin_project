package admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class delete_module {
	protected String msg = null;
	dbConfig db = null;
	Connection ct = null;
	
	protected String delete(ArrayList<String> data) {
		//System.out.println(data);
		String tableName = data.get(0);
		
		
		
		String colName = data.get(1);
		String sql = "delete from "+tableName+" where "+colName+"=";
		int w = 2;
		while(w<data.size()) {
			int d = data.size()-2;
			
			if(w==data.size()-1) {
				sql += "?";
			}else {
				sql += "? or "+colName+"=";
				
			}
			
			w++;
		}
		
		try {
			this.db = new dbConfig();
			this.ct = db.cafe24();
			PreparedStatement ps = this.ct.prepareStatement(sql);
			
			int ww=2;
			while(ww<data.size()) {
				
				ps.setString(ww-1, data.get(ww));
				
				ww++;
			};
			//System.out.println(ps);
			int n=0;
			n=ps.executeUpdate();
			
			if(n>0) {
				this.msg="ok";
			}else {
				throw new Exception("error");
			}
			
			
		} catch (Exception e) {
			this.msg = "no";
			
		}finally {
			
			try {
				this.ct.close();
				System.out.println("close");
			} catch (Exception e2) {
				System.out.println("db delete error");
			}
		}
		
		
		return this.msg;
	}
	
	
}
