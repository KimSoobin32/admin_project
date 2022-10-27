package admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class update_module {
	String updateOk = null;
	public void memUpdate(ArrayList<String> datas) {
		
		today t = new today();
		String up_date = t.getDateTimeNow();
		
		
		Connection con = null;
		try {
			dbConfig db = new dbConfig();
			con = db.cafe24();
			
			String sql = "update admin_member set apw=?, aname=?, aemail=?, atel=?, apart=?, aposition=?, aoutdate=? where aid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			int w=1;
			while(w<datas.size()) {
				
				ps.setString(w, datas.get(w));
				
				w++;
			}
			
			ps.setString(7, up_date);
			ps.setString(8, datas.get(0));			
			
			
			int n = 0;
			n = ps.executeUpdate();
			if(n>0) {
				this.updateOk = "ok";
			}else {
				throw new Exception("error");
			}
			
			
		}catch (Exception e) {
			System.out.println("데이터베이스 오류1");
			this.updateOk = "no";
			
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println("데이터베이스 오류2");
			}
		}
	}
	
	public void notiUpdate(ArrayList<String> datas) {
		
		//today t = new today();
		//String up_date = t.getDateTimeNow();
		
		
		Connection con = null;
		try {
			dbConfig db = new dbConfig();
			con = db.cafe24();
			//추후 수정일자 컬럼 추가 필?
			String sql = "update notice_write set usenotice=?, ntitle=?, nwriter=?, nfile=?, ncontent=?, nindate=? where nidx=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			int w=1;
			while(w<datas.size()) {
				
				ps.setString(w, datas.get(w));
				
				w++;
			}
			
			//ps.setString(7, up_date);
			ps.setString(7, datas.get(0));
			
			
			int n = 0;
			n = ps.executeUpdate();
			if(n>0) {
				this.updateOk = "ok";
			}else {
				throw new Exception("error");
			}
			
			
		}catch (Exception e) {
			System.out.println("데이터베이스 오류1");
			this.updateOk = "no";
			
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println("데이터베이스 오류2");
			}
		}
	}
}
