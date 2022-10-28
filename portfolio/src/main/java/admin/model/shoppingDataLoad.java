package admin.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import admin.module.dbConfig;

public class shoppingDataLoad {
	private String coidx;
	private String conm;
	private String cokind;	
	private String costartdate;
	private String coenddate;
	private String cotype;
	private String codc;	
	private String co_minorderprice;
	
	public String getCoidx() {
		return coidx;
	}
	public void setCoidx(String coidx) {
		this.coidx = coidx;
	}
	public String getConm() {
		return conm;
	}
	public void setConm(String conm) {
		this.conm = conm;
	}
	public String getCokind() {
		return cokind;
	}
	public void setCokind(String cokind) {
		this.cokind = cokind;
	}
	public String getCostartdate() {
		return costartdate;
	}
	public void setCostartdate(String costartdate) {
		this.costartdate = costartdate;
	}
	public String getCoenddate() {
		return coenddate;
	}
	public void setCoenddate(String coenddate) {
		this.coenddate = coenddate;
	}
	public String getCotype() {
		return cotype;
	}
	public void setCotype(String cotype) {
		this.cotype = cotype;
	}
	public String getCodc() {
		return codc;
	}
	public void setCodc(String codc) {
		this.codc = codc;
	}
	public String getCo_minorderprice() {
		return co_minorderprice;
	}
	public void setCo_minorderprice(String co_minorderprice) {
		this.co_minorderprice = co_minorderprice;
	}
	
	public ArrayList<shoppingDataLoad> all_lists(){
		ArrayList<shoppingDataLoad> list = new ArrayList<shoppingDataLoad>();
		
		Connection ct = null;
		
		try {
			dbConfig db = new dbConfig();
			ct = db.cafe24();
			String sql = "select * from coupon_table order by coidx desc limit 0,5";
			PreparedStatement ps = ct.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				shoppingDataLoad sdl = new shoppingDataLoad();
				sdl.setCoidx(rs.getString("coidx"));
				sdl.setConm(rs.getString("conm"));
				sdl.setCokind(rs.getString("cokind"));
				sdl.setCostartdate(rs.getString("costartdate"));				
				sdl.setCoenddate(rs.getString("coenddate"));
				sdl.setCotype(rs.getString("cotype"));
				sdl.setCodc(rs.getString("codc"));
				sdl.setCo_minorderprice(rs.getString("co_minorderprice"));
				list.add(sdl);
				
				
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

	
	
	
}
