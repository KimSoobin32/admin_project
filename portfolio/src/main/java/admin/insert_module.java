package admin;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.fabric.Response;

public class insert_module {
	protected String msg = null;
	dbConfig db = null;
	Connection ct = null;
	
	
	protected String insert(ArrayList<String> data) {
		
		String tableName = data.get(0);
		
		
		int w = 1;
		String sql = "insert into "+tableName+" values('0',";
		while(w<data.size()) {
			if(w==data.size()-1) {
				sql += "?)";
			}else {
				sql += "?,";
			}
			
			w++;
		}
		
		try {
			this.db = new dbConfig();
			this.ct = db.cafe24();
			
			
			//
			if(tableName=="category_table") {
				String check_sql = "select count(*) as cnt from category_table where categorycode=?";
				PreparedStatement pr2 = this.ct.prepareStatement(check_sql);
				pr2.setString(1, data.get(1));
				ResultSet rs = pr2.executeQuery();
				String sqlno = null;
				while(rs.next()) {
					sqlno = rs.getString("cnt");
				}
				if(!sqlno.equals("0")) {
					this.msg = "double";
					
					throw new Exception("double");
					
				}
				//System.out.println(sqlno);
			}
			
			//
			
			PreparedStatement ps = this.ct.prepareStatement(sql);
			int ww=1;
			while(ww<data.size()) {
				
				ps.setString(ww, data.get(ww));
				
				ww++;
			};
			int n = 0;
			n=ps.executeUpdate();
			
			if(n>0) {
				this.msg="ok";
			}else {
				throw new Exception("error");
			}
			
		}catch (Exception e) {
			//this.msg = "no";
			this.msg = e.getMessage();
			
		}finally {
			
			try {
				this.ct.close();
			} catch (Exception e2) {
				System.out.println("db insert error");
			}
		}
		
		
		return this.msg;
	}

}
