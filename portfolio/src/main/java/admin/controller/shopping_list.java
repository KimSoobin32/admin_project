package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.vo.shoppingDataLoad;


public class shopping_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public shopping_list() {

    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	shoppingDataLoad sdl = new shoppingDataLoad();
    	ArrayList<shoppingDataLoad> coList = sdl.all_lists();
    	
    	req.setAttribute("coupon_list", coList);
    	RequestDispatcher rd = req.getRequestDispatcher("/admin/admin_shopping.jsp");
    	rd.forward(req, resp);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
