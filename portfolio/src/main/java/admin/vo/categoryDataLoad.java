package admin.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.module.dbConfig;

public class categoryDataLoad {
	private String cidx;
	private String categorycode;
	private String b_catecode;
	private String b_catenm;
	private String s_catecode;
	private String s_catenm;
	private String usecate;
	private String cindate;
	
	private String page;
	public int pagenumber;
	public int startpage;
	public int total;
	
	public String search;
	public String sel;
	
	public String getCidx() {
		return cidx;
	}
	public void setCidx(String cidx) {
		this.cidx = cidx;
	}
	public String getCategorycode() {
		return categorycode;
	}
	public void setCategorycode(String categorycode) {
		this.categorycode = categorycode;
	}
	public String getB_catecode() {
		return b_catecode;
	}
	public void setB_catecode(String b_catecode) {
		this.b_catecode = b_catecode;
	}
	public String getB_catenm() {
		return b_catenm;
	}
	public void setB_catenm(String b_catenm) {
		this.b_catenm = b_catenm;
	}
	public String getS_catecode() {
		return s_catecode;
	}
	public void setS_catecode(String s_catecode) {
		this.s_catecode = s_catecode;
	}
	public String getS_catenm() {
		return s_catenm;
	}
	public void setS_catenm(String s_catenm) {
		this.s_catenm = s_catenm;
	}
	public String getUsecate() {
		return usecate;
	}
	public void setUsecate(String usecate) {
		this.usecate = usecate;
	}
	public String getCindate() {
		return cindate;
	}
	public void setCindate(String cindate) {
		this.cindate = cindate;
	}
	
	//pageing
	public void setPage(String p) {		
		this.page=p;
		
	}

	
	public void setPagenumber(int pagenum) {
		this.pagenumber = pagenum;
	}

	
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	//search
	public void setSearchSel(String search, String sel) {
		this.search = search;
		this.sel = sel;
	}
	
	
	
	public ArrayList<categoryDataLoad> all_lists(){
		ArrayList<categoryDataLoad> list = new ArrayList<categoryDataLoad>();
		dbConfig db = new dbConfig();
		
		int pageview = 3;	//한 페이지당 보여지는 데이터 개수
		int startpage = 0;	//시작 페이지 값
		int pagenumber = 1;	//페이지 개수
		
		
		//search
		
		String andsql = "";	//검색할 때 사용
		if(this.search==null){
			andsql = "";	//sql 문법 상 띄어쓰기가 적용 되도록 주의
		}else if(this.sel.intern()=="catenm"){
			andsql = "where b_catenm like '%"+this.search+"%' or s_catenm like '%"+this.search+"%'";
			
		}else {
			andsql = "where b_catecode like '%"+this.search+"%' or s_catecode like '%"+this.search+"%'";
		}
		
		
		
		Connection ct = null;
		String totalSql = "select count(*) as ct from category_table "+andsql;
		PreparedStatement psct = null;
		int total = 0;
		
		
		try {
			ct = db.cafe24();
			psct = ct.prepareStatement(totalSql);
			ResultSet rsct = psct.executeQuery();
			while(rsct.next()) {
				total = rsct.getInt("ct");
			}
			
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
			setTotal(total);
			
			
		} catch (Exception e) {
			System.out.println("db error111");
		}finally {
			
			try {
				ct.close();
			} catch (Exception e2) {
				System.out.println("db error222");
			}
		}
		
		
		
		
		
		
		
		//데이터
		Connection con = null;
		String sql = "select * from category_table "+andsql+" order by cidx desc limit ?,?";
		
		
		try {
			//dbConfig db = new dbConfig();
			con = db.cafe24();
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, startpage);
			ps.setInt(2, pageview);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				categoryDataLoad cdl = new categoryDataLoad();
				cdl.setCidx(rs.getString("cidx"));
				cdl.setCategorycode(rs.getString("categorycode"));
				cdl.setB_catecode(rs.getString("b_catecode"));
				cdl.setB_catenm(rs.getString("b_catenm"));
				cdl.setS_catecode(rs.getString("s_catecode"));
				cdl.setS_catenm(rs.getString("s_catenm"));
				cdl.setUsecate(rs.getString("usecate"));
				cdl.setCindate(rs.getString("cindate"));
				list.add(cdl);
			}
			
			
		} catch (Exception e) {
			System.out.println("db error1");
		}finally {
			
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("db error2");
			}
		}
		
		return list;
	}
	
	public ArrayList<categoryDataLoad> cate_lists(){
		ArrayList<categoryDataLoad> list = new ArrayList<categoryDataLoad>();
		dbConfig db = new dbConfig();
		Connection con = null;
		String sql = "select distinct b_catecode, s_catecode from category_table";
		
		
		try {
			//dbConfig db = new dbConfig();
			con = db.cafe24();
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				categoryDataLoad cdl = new categoryDataLoad();				
				cdl.setB_catecode(rs.getString("b_catecode"));
				cdl.setS_catecode(rs.getString("s_catecode"));
				list.add(cdl);
			}
						
		} catch (Exception e) {
			System.out.println("db error1");
		}finally {
			
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("db error2");
			}
		}
		
		return list;
	}

	
}
