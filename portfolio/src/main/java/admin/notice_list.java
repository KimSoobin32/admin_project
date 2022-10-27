package admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public notice_list() {

    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	String page = req.getParameter("page");
    	
    	noticeDataLoad ndl = new noticeDataLoad();
    	ndl.setPage(page);
    	ArrayList<noticeDataLoad> list = ndl.all_lists();
    	
    	//ArrayList<noticeDataLoad> nlist = ndl.notice_lists();
    	
    	
    	int pn = ndl.pagenumber;
    	int sp = ndl.startpage;
    	int tot = ndl.total;
    	
    	req.setAttribute("pagenumber", pn);
    	req.setAttribute("startpage", sp);
    	req.setAttribute("total", tot);
    	req.setAttribute("list", list);
    	//req.setAttribute("nlist", nlist);
    	RequestDispatcher rd = req.getRequestDispatcher("/admin/admin_notice.jsp");
    	rd.forward(req, resp);
    	
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
