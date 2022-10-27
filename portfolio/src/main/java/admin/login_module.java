package admin;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_module {
	protected Connection ct = null;
	String uname = null;
	String uid = null;
	String uemail = null;
	String utel = null;
	String upart = null;
	String uposition = null;
	String login_accept = null;
	String msg = null;
	
	public void setUserinfo(String uid,String uname,String uemail,String utel,String upart,String uposition, String login_accept) {
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.utel = utel;
		this.upart = upart;
		this.uposition = uposition;
		this.login_accept = login_accept;
		
	}
	
	public void setMessage(String msg) {
		this.msg = msg;
	}
	
	
	public login_module getter(String userid, String userpw) {
		
		login_module ld = null;
		
		
		try {
			dbConfig dc = new dbConfig();
			
			this.ct = dc.cafe24();
			
			ld = new login_module();
			
			String sql = "select aid,aname,aemail,atel,apart,aposition,login_accept from admin_member where aid=? and apw=?";
			PreparedStatement ps = this.ct.prepareStatement(sql);
			
			ps.setString(1, userid);
			ps.setString(2, userpw);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()==false) {	//해당 사용자 없음
				ld.setMessage("no");
			}else {	//해당 사용자 있음
				ld.setMessage("ok");
				String aid = rs.getString("aid");
				String aname = rs.getString("aname");
				String aemail = rs.getString("aemail");
				String atel = rs.getString("atel");
				String apart = rs.getString("apart");
				String aposition = rs.getString("aposition");
				String login_accept = rs.getString("login_accept");
				
				ld.setUserinfo(aid,aname,aemail,atel,apart,aposition,login_accept);
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println("데이터베이스 오류1");
		}finally {
			try {
				
				this.ct.close();
			} catch (SQLException e) {
				System.out.println("데이터베이스 오류2");
			}
		}
		
		
		return ld;
	}
	
	
	public void saveLoginHistory(String uid) {
		
		today t = new today();
		String today = t.getDateTimeNow();
		
		
		try {
			dbConfig db = new dbConfig();
			this.ct = db.cafe24();
			String sql_loginhistory = "insert into loginhistory values('0','"+uid+"','"+today+"')";
			PreparedStatement ps = this.ct.prepareStatement(sql_loginhistory);

			int n = 0;
			n = ps.executeUpdate();
			
			if(n>0) {
				//System.out.println("loginhistory save complete");
			}else {
				throw new Exception("error");
			}
			
			
		} catch (Exception e) {
			System.out.println("데이터베이스 loginhistory 오류1");
			
		}finally {
			
			try {
				this.ct.close();
				
			} catch (Exception e2) {
				System.out.println("데이터베이스 loginhistory 오류2");
			}
		}
		
		
		
	}
	
}
