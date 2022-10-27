package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class productDataLoad {
	private String pridx;
	private String b_prcatecode;
	private String s_prcatecode;
	private String productcode;
	private String prnm;
	private String praddex;
	private String prprice;
	private String prdcpercent;
	private String prdcprice;
	private String prstock;
	private String usesell;
	private String usesoldout;
	private String primg1;
	private String primg2;
	private String primg3;
	private String prdetailex;
	private String prindate;

	private String page;
	public int pagenumber;
	public int startpage;
	public int total;

	public String search;
	public String sel;

	public String getPridx() {
		return pridx;
	}

	public void setPridx(String pridx) {
		this.pridx = pridx;
	}

	public String getB_prcatecode() {
		return b_prcatecode;
	}

	public void setB_prcatecode(String b_prcatecode) {
		this.b_prcatecode = b_prcatecode;
	}

	public String getS_prcatecode() {
		return s_prcatecode;
	}

	public void setS_prcatecode(String s_prcatecode) {
		this.s_prcatecode = s_prcatecode;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getPrnm() {
		return prnm;
	}

	public void setPrnm(String prnm) {
		this.prnm = prnm;
	}

	public String getPraddex() {
		return praddex;
	}

	public void setPraddex(String praddex) {
		this.praddex = praddex;
	}

	public String getPrprice() {
		return prprice;
	}

	public void setPrprice(String prprice) {
		this.prprice = prprice;
	}

	public String getPrdcpercent() {
		return prdcpercent;
	}

	public void setPrdcpercent(String prdcpercent) {
		this.prdcpercent = prdcpercent;
	}

	public String getPrdcprice() {
		return prdcprice;
	}

	public void setPrdcprice(String prdcprice) {
		this.prdcprice = prdcprice;
	}

	public String getPrstock() {
		return prstock;
	}

	public void setPrstock(String prstock) {
		this.prstock = prstock;
	}

	public String getUsesell() {
		return usesell;
	}

	public void setUsesell(String usesell) {
		this.usesell = usesell;
	}

	public String getUsesoldout() {
		return usesoldout;
	}

	public void setUsesoldout(String usesoldout) {
		this.usesoldout = usesoldout;
	}

	public String getPrimg1() {
		return primg1;
	}

	public void setPrimg1(String primg1) {
		this.primg1 = primg1;
	}

	public String getPrimg2() {
		return primg2;
	}

	public void setPrimg2(String primg2) {
		this.primg2 = primg2;
	}

	public String getPrimg3() {
		return primg3;
	}

	public void setPrimg3(String primg3) {
		this.primg3 = primg3;
	}

	public String getPrdetailex() {
		return prdetailex;
	}

	public void setPrdetailex(String prdetailex) {
		this.prdetailex = prdetailex;
	}

	public String getPrindate() {
		return prindate;
	}

	public void setPrindate(String prindate) {
		this.prindate = prindate;
	}

	// pageing
	public void setPage(String p) {
		this.page = p;
	}

	public void setPagenumber(int pagenum) {
		this.pagenumber = pagenum;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	// search
	public void setSearchSel(String search, String sel) {
		this.search = search;
		this.sel = sel;
	}

	public ArrayList<productDataLoad> all_lists() {
		ArrayList<productDataLoad> list = new ArrayList<productDataLoad>();
		dbConfig db = new dbConfig();

		
		 int pageview =2; 
		 int startpage =0; 
		 int pagenumber = 1;
		 
		 String andsql = ""; //검색할 때 사용 
		 if(this.search==null){ 
			 andsql = ""; 

		 }else if(this.sel.intern()=="prnm"){ 
			 andsql ="where prnm like '%"+this.search+"%' or prnm like '%"+this.search+"%'";
		 
		 }else { 
			 andsql ="where productcode like '%"+this.search+"%' or productcode like '%"+this.search+"%'"; 
		}
		 
		 Connection ct = null;
		 String totalSql = "select count(*) as ct from product_table "+andsql;
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
		 
		 

		// data
		Connection con = null;
		String sql = "select * from product_table "+andsql+" order by pridx desc limit ?,?";

		try {
			con = db.cafe24();

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, startpage);
			ps.setInt(2, pageview);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				productDataLoad pdl = new productDataLoad();
				pdl.setPridx(rs.getString("pridx"));
				pdl.setB_prcatecode(rs.getString("b_prcatecode"));
				pdl.setS_prcatecode(rs.getString("s_prcatecode"));
				pdl.setProductcode(rs.getString("productcode"));
				pdl.setPrnm(rs.getString("prnm"));
				pdl.setPraddex(rs.getString("praddex"));

				pdl.setPrprice(rs.getString("prprice"));
				pdl.setPrdcpercent(rs.getString("prdcpercent"));
				pdl.setPrdcprice(rs.getString("prdcprice"));
				pdl.setPrstock(rs.getString("prstock"));
				pdl.setUsesell(rs.getString("usesell"));
				pdl.setUsesoldout(rs.getString("usesoldout"));
				pdl.setPrimg1(rs.getString("primg1"));
				pdl.setPrimg2(rs.getString("primg2"));
				pdl.setPrimg3(rs.getString("primg3"));

				pdl.setPrdetailex(rs.getString("prdetailex"));
				pdl.setPrindate(rs.getString("prindate"));
				list.add(pdl);

			}
			// System.out.println(list);
		} catch (Exception e) {
			System.out.println("db error1");
		} finally {

			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("db error2");
			}
		}

		return list;
	}

}
