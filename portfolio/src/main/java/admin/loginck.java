package admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.module.loginck_module;


public class loginck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loginck() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		String aid = request.getParameter("userid");
		
		loginck_module lm = new loginck_module();
		String loginck_result = lm.idSearch(aid);
		
		if(loginck_result==null) {
			pw.print("데이터베이스 오류");
		}else {
			pw.print(loginck_result);
		}
		
		
	
			
		
	}

}
