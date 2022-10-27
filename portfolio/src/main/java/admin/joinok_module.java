package admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class joinok_module {
	String insertOk = null;
	public void insert(ArrayList<String> datas) {
		
		
		today t = new today();
		String today = t.getDateTimeNow();
		
		String outdate = "0001-01-01 01:00:00";
		String login_accept = "N";
		
		Connection con = null;
		try {
			dbConfig db = new dbConfig();
			con = db.cafe24();
			
			String sql = "insert into admin_member values('0',?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			int w=1;
			while(w<=datas.size()) {
				
				ps.setString(w, datas.get(w-1));
				
				w++;
			}
			ps.setString(8, login_accept);
			ps.setString(9, today);
			ps.setString(10, outdate);
			
			int n = 0;
			n = ps.executeUpdate();
			if(n>0) {
				this.insertOk = "ok";
			}else {
				throw new Exception("error");
			}
			
			
		}catch (Exception e) {
			System.out.println("데이터베이스 오류1");
			this.insertOk = "no";
			
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				System.out.println("데이터베이스 오류2");
			}
		}
		
		
		
	}
	
	public String join_msg() {
		return this.insertOk;
	}
	
}
