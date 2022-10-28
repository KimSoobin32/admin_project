package admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.module.dbConfig;

public class dataLoad {
	private String aidx;
	private String aid;
	private String apw;
	private String aname;
	private String aemail;
	private String atel;
	private String apart;
	private String aposition;
	private String login_accept;
	private String aindate;
	private String aoutdate;
	
	
	public String getAidx() {
		return aidx;
	}
	public void setAidx(String aidx) {
		this.aidx = aidx;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getApw() {
		return apw;
	}
	public void setApw(String apw) {
		this.apw = apw;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getApart() {
		return apart;
	}
	public void setApart(String apart) {
		this.apart = apart;
	}
	public String getAposition() {
		return aposition;
	}
	public void setAposition(String aposition) {
		this.aposition = aposition;
	}
	public String getLogin_accept() {
		return login_accept;
	}
	public void setLogin_accept(String login_accept) {
		this.login_accept = login_accept;
	}
	public String getAindate() {
		return aindate;
	}
	public void setAindate(String aindate) {
		this.aindate = aindate;
	}
	public String getAoutdate() {
		return aoutdate;
	}
	public void setAoutdate(String aoutdate) {
		this.aoutdate = aoutdate;
	}
	
	public ArrayList<dataLoad> all_lists() {
		
		ArrayList<dataLoad> list = new ArrayList<dataLoad>();
		
		Connection ct = null;
		try {
			dbConfig db = new dbConfig();
			ct = db.cafe24();
			String sql = "select * from admin_member order by aidx desc";
			PreparedStatement ps = ct.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				dataLoad dl = new dataLoad();
				dl.setAidx(rs.getString("aidx"));
				dl.setAid(rs.getString("aid"));
				dl.setApw(rs.getString("apw"));
				dl.setAname(rs.getString("aname"));
				dl.setAemail(rs.getString("aemail"));
				dl.setAtel(rs.getString("atel"));
				dl.setApart(rs.getString("apart"));
				dl.setAposition(rs.getString("aposition"));
				dl.setAindate(rs.getString("aindate"));
				dl.setAoutdate(rs.getString("aoutdate"));
				
				//System.out.println(rs.getString("aid"));
				
				list.add(dl);
			}
			//System.out.println(this.aid);
			
		} catch (Exception e) {
			System.out.println("db error1");
		}finally {
			try {
				ct.close();
			} catch (Exception e) {
				System.out.println("db error2");
			}
		}
		
		return list;
		
	}

	
	
	
}
