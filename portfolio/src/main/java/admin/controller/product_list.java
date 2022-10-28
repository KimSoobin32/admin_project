package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.productDataLoad;


public class product_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public product_list() {

    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	 
    	String page = req.getParameter("page");
    	String search = req.getParameter("searchinput");
    	String sel = req.getParameter("sel");
    	
    	productDataLoad pdl = new productDataLoad();
    	pdl.setPage(page);
    	pdl.setSearchSel(search, sel);
    	ArrayList<productDataLoad> list = pdl.all_lists();
    	//System.out.println(list);
    	req.setAttribute("pagenumber", pdl.pagenumber);
    	req.setAttribute("total", pdl.total);
    	req.setAttribute("search", pdl.search);
    	req.setAttribute("sel", pdl.sel);
    	req.setAttribute("list", list);
    	RequestDispatcher rd = req.getRequestDispatcher("/admin/admin_product.jsp");
    	rd.forward(req, resp);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
