package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.vo.dataLoad;


public class member_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public member_list() {

    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	dataLoad dl = new dataLoad();
    	ArrayList<dataLoad> list = dl.all_lists();
    	
    	req.setAttribute("list", list);
    	
    	RequestDispatcher rd = req.getRequestDispatcher("/admin/admin_main.jsp");
    	rd.forward(req, resp);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
