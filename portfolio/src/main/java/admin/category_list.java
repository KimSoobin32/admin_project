package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class category_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public category_list() {

    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	String page = req.getParameter("page");
    	String search = req.getParameter("search");
    	String sel = req.getParameter("sel");
    	
    	
    	categoryDataLoad cdl = new categoryDataLoad();
    	cdl.setPage(page);
    	cdl.setSearchSel(search, sel);
    	ArrayList<categoryDataLoad> list = cdl.all_lists();
    	
    	req.setAttribute("pagenumber", cdl.pagenumber);   	
    	req.setAttribute("total", cdl.total);
    	req.setAttribute("search", cdl.search);
    	req.setAttribute("sel", cdl.sel);
    	
    	req.setAttribute("list", list);
    	RequestDispatcher rd = req.getRequestDispatcher("/admin/admin_category.jsp");
    	rd.forward(req, resp);
    }

    //
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
