package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.noticeDataLoad;


public class noticeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public noticeView() {

    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	String nidx = req.getParameter("nidx");
    	
    	noticeDataLoad ndl = new noticeDataLoad();
    	ArrayList<String> list = ndl.noticeOne(nidx);
    	
    	req.setAttribute("list", list);
    	RequestDispatcher rd = req.getRequestDispatcher("/admin/admin_notice_view.jsp");
    	rd.forward(req, resp);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
