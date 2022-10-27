package admin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import admin.insert_module;
import admin.module.today;

@MultipartConfig(	//파일 업로드 기능 처리 시 사용되는 어노테이션 속성		
		fileSizeThreshold = 1024 * 1024 * 1,	//1MB(파일 업로드 시 사용되는 메모리 임시크기 용량)
		maxFileSize = 1024 * 1024 * 2,	//2MB(업로드 파일 최대 크기값)
		maxRequestSize = 1024 * 1024 * 2	//2MB(전송에 따른 최대 크기값)
)

public class couponWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public couponWrite() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = null;
		String path = null;
		String url=null;
		String newUrl=null;
		
		String conm = URLDecoder.decode(request.getParameter("conm"),"UTF-8");
		String cokind = URLDecoder.decode(request.getParameter("cokind"),"UTF-8");
		String costartdate = URLDecoder.decode(request.getParameter("costartdate"),"UTF-8");
		String coenddate = URLDecoder.decode(request.getParameter("coenddate"),"UTF-8")+" 23:59:59";
		//coenddate = coenddate+" 23:59:59";
	
		String cotype = URLDecoder.decode(request.getParameter("cotype"),"UTF-8");
		String codc = URLDecoder.decode(request.getParameter("codc"),"UTF-8");
		String co_minorderprice = URLDecoder.decode(request.getParameter("co_minorderprice"),"UTF-8");
		Part part = request.getPart("coimg");
		filename = part.getSubmittedFileName().intern();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		today now = new today();
		String coindate = now.getDateTimeNow();
		String coupdate = null;
		
		path = request.getServletContext().getRealPath("");
		File fe = new File(path+"upload/");
		if(!fe.exists()) {
			fe.mkdirs();
		}
		url = path+"upload/"+filename;

		newUrl = url.replace("/jwe06120/tomcat/webapps/", "./");
		InputStream is = part.getInputStream();
		FileOutputStream fo = new FileOutputStream(url);
		byte[] bf = new byte[1024*2];
		int size=0;
		while((size=is.read(bf))!=-1) {
			fo.write(bf,0,size);
		}
		fo.close();
		is.close();
		
		String[] codata = {"coupon_table",conm,cokind,costartdate,coenddate,cotype,codc,co_minorderprice,newUrl,coindate,coupdate};
		ArrayList<String> ar = new ArrayList<String>(Arrays.asList(codata));
		
		
		insert_module im = new insert_module();
		String result_sign = im.insert(ar).intern();
		if(result_sign=="ok") {
			pr.print("<script>"
					+ "alert('쿠폰등록이 완료되었습니다.'); location.href='./shopping_list.do';"
					+ "</script>");
			
		}else {
			pr.print("<script>"
					+ "alert('올바른 값이 아닙니다.'); history.go(-1);"
					+ "</script>");
		}
		
	}

}
