package admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.dbConfig;

public class noticeDataLoad {
	private String nidx;
	private String usenotice;
	private String ntitle;
	private String nwriter;
	private String nfile;
	private String ncontent;
	private String nindate;
	private int viewcount;
	
	private String page;
	public int pagenumber;
	public int startpage;
	public int total;
	
	public String getNidx() {
		return nidx;
	}
	public void setNidx(String nidx) {
		this.nidx = nidx;
	}
	public String getUsenotice() {
		return usenotice;
	}
	public void setUsenotice(String usenotice) {
		this.usenotice = usenotice;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNwriter() {
		return nwriter;
	}
	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}
	public String getNfile() {
		return nfile;
	}
	public void setNfile(String nfile) {
		this.nfile = nfile;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNindate() {
		return nindate;
	}
	public void setNindate(String nindate) {
		this.nindate = nindate;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
	
	
	//파라미터 받는 메소드 생성..
	
	public void setPage(String p) {		
		this.page=p;
		
	}
	public String getPage() {
		return this.page;
	}
	
	public void setPagenumber(int pagenum) {
		this.pagenumber = pagenum;
	}
	public int getPagenumber() {
		return this.pagenumber;
	}
	
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
	public int getStartpage() {
		return this.startpage;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
	public ArrayList<noticeDataLoad> all_lists(){
		ArrayList<noticeDataLoad> list = new ArrayList<noticeDataLoad>();
		
		
		int pageview = 5;	//한 페이지당 보여지는 데이터 개수
		int startpage = 0;	//시작 페이지 값
		int pagenumber = 1;	//페이지 개수
		
		
		
		Connection con = null;
		//String totalSql = "select count(*) as ct from notice_write";
		String totalSql = "select count(*) as ct, count(case when usenotice='Y' then 1 end) as un from notice_write";
		PreparedStatement psct = null;
		int total = 0;
		int un = 0;
		try {
			dbConfig db = new dbConfig();
			con = db.cafe24();
			psct = con.prepareStatement(totalSql);
			ResultSet rsct = psct.executeQuery();		
			while(rsct.next()){
				total = rsct.getInt("ct");
				un = rsct.getInt("un");
			}
			//pageview = pageview-un;
			if(this.page==null || this.page==""){
				startpage = 0;
			}else{	//페이지 2번부터 적용되는 사항
				startpage = (Integer.parseInt(this.page)-1) * pageview;
			}
			
			if(total%pageview==0){
				pagenumber = total/pageview;
			}else{
				pagenumber = (total/pageview)+1;
			}
			
			
			
			setPagenumber(pagenumber);
			setStartpage(startpage);
			setTotal(total);
			
		} catch (Exception e) {
			System.out.println("db error11");
		}finally {
			
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("db error22");
			}
		}
		
		
		
		Connection ct = null;
		try {
			
			dbConfig db = new dbConfig();
			ct = db.cafe24();
			String sql = "select * from notice_write order by nidx desc limit ?,?";
			
			
			PreparedStatement ps = ct.prepareStatement(sql);
			ps.setInt(1, startpage);
			//ps.setInt(2, pageview);
			ps.setInt(2, pageview);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				noticeDataLoad ndl = new noticeDataLoad();
				ndl.setNidx(rs.getString("nidx"));
				ndl.setUsenotice(rs.getString("usenotice"));
				ndl.setNtitle(rs.getString("ntitle"));
				ndl.setNwriter(rs.getString("nwriter"));
				ndl.setNfile(rs.getString("nfile"));
				ndl.setNcontent(rs.getString("ncontent"));
				ndl.setNindate(rs.getString("nindate"));
				ndl.setViewcount(rs.getInt("viewcount"));
				
				list.add(ndl);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("db error1");
		}finally {
			
			try {
				ct.close();
			} catch (Exception e2) {
				System.out.println("db error2");
			}
		}
		
		
		
		return list;
		
	}
	
	
	public ArrayList<noticeDataLoad> notice_lists(){
		ArrayList<noticeDataLoad> nlist = new ArrayList<noticeDataLoad>();
		Connection ct = null;
		try {
			
			dbConfig db = new dbConfig();
			ct = db.cafe24();
			String nsql = "select * from notice_write where usenotice='Y'";
			
			PreparedStatement ps = ct.prepareStatement(nsql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				noticeDataLoad ndl = new noticeDataLoad();
				ndl.setNidx(rs.getString("nidx"));
				ndl.setUsenotice(rs.getString("usenotice"));
				ndl.setNtitle(rs.getString("ntitle"));
				ndl.setNwriter(rs.getString("nwriter"));
				ndl.setNfile(rs.getString("nfile"));
				ndl.setNcontent(rs.getString("ncontent"));
				ndl.setNindate(rs.getString("nindate"));
				ndl.setViewcount(rs.getInt("viewcount"));
				
				nlist.add(ndl);
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("db error1");
		}finally {
			
			try {
				ct.close();
			} catch (Exception e2) {
				System.out.println("db error2");
			}
		}
		
		return nlist;
	}
	
	
	public ArrayList<String> noticeOne(String nidx){
		ArrayList<String> noti = new ArrayList<String>();
		Connection ct = null;
		try {
			
			dbConfig db = new dbConfig();
			ct = db.cafe24();
			String nsql = "select * from notice_write where nidx='"+nidx+"'";
			
			PreparedStatement ps = ct.prepareStatement(nsql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				noti.add(rs.getString("nidx"));
				noti.add(rs.getString("usenotice"));
				noti.add(rs.getString("ntitle"));
				noti.add(rs.getString("nwriter"));
				noti.add(rs.getString("nfile"));
				noti.add(rs.getString("ncontent"));

				
				//조회수 +1
				//String vsql = "update notice_write set viewcount = viewcount+1 where nidx='"+nidx+"'";
				
				String vsql2 = "update notice_write as a join (select max(viewcount)+1 as maxvc from notice_write where nidx='"+nidx+"')"
						+ " as b set a.viewcount = b.maxvc where a.nidx='"+nidx+"'";
				
				PreparedStatement vps = ct.prepareStatement(vsql2);
				int vres = vps.executeUpdate();
				if(vres<=0) {
					throw new Exception("error");
				}
				
				
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("db error1");
		}finally {
			
			try {
				ct.close();
			} catch (Exception e2) {
				System.out.println("db error2");
			}
		}
		return noti;
	}

	
	
}
