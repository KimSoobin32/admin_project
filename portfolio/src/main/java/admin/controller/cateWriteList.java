package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.categoryDataLoad;


public class cateWriteList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public cateWriteList() {

    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	categoryDataLoad cdl = new categoryDataLoad();
    	ArrayList<categoryDataLoad> list = cdl.cate_lists();
    	req.setAttribute("list", list);
    	RequestDispatcher rd = req.getRequestDispatcher("/admin/admin_category_write.jsp");
    	rd.forward(req, resp);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
