package admin;

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

@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 1,	//1MB(파일 업로드 시 사용되는 메모리 임시크기 용량)
		maxFileSize = 1024 * 1024 * 2,	//2MB(업로드 파일 최대 크기값)
		maxRequestSize = 1024 * 1024 * 2	//2MB(전송에 따른 최대 크기값)
)

public class noticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String nidx,usenotice,ntitle,nwriter,ncontent;

    public noticeUpdate() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = null;
		String path = null;
		String upload = null;
		String url=null;
		String url2=null;
		//HTML에서 enctype을 확인함
		//String enctype = request.getMethod();	//form post형태
		String enctypec = request.getContentType();	//enctype
		//System.out.println(enctypec);
		
		Part part = null;
		
		if(enctypec.equals("application/x-www-form-urlencoded")) {
			this.usenotice = request.getParameter("usenotice");
			this.ntitle = request.getParameter("ntitle");
			this.nwriter = request.getParameter("nwriter");
			this.ncontent = request.getParameter("ncontent2");
		}else {
			//URLDecoder.decode : multipart/form-data 역해석, 문자셋 써줘야 안깨짐
			if(request.getParameter("usenotice")!=null) {				
				this.usenotice = URLDecoder.decode(request.getParameter("usenotice"),"UTF-8");
			}else {
				this.usenotice = "N";
			}
			this.nidx = URLDecoder.decode(request.getParameter("ck"),"UTF-8");
			this.ntitle = URLDecoder.decode(request.getParameter("ntitle"),"UTF-8");
			this.nwriter = URLDecoder.decode(request.getParameter("nwriter"),"UTF-8");
			this.ncontent = URLDecoder.decode(request.getParameter("ncontent2"),"UTF-8");
			part = request.getPart("nfile");
			filename=part.getSubmittedFileName().intern();
			
			
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		today now = new today();
		String nindate = now.getDateTimeNow();
		String viewcount = "0";
		if(filename=="") {
			url2 = null;
		}else {
			path = request.getServletContext().getRealPath("");
			upload = path+"upload/";	//실제 저장 공간
			
			File fe = new File(upload);	//디렉토리 생성
			if(!fe.exists()) {
				fe.mkdirs(); // 없으면 만든다. 있으면 패스 else 안적음.
			}
			
			url = upload+filename;
			
			url2 = url.replace("/jwe06120/tomcat/webapps/portfolio/", "./");
			
			
			InputStream is = part.getInputStream();
			FileOutputStream fo = new FileOutputStream(url);
			byte[] bf = new byte[1024*2];
			int size=0;
			while((size=is.read(bf))!=-1) {
				fo.write(bf,0,size);
			}
			fo.close();
			is.close();
			
			
		}
		
		
		
		
		String[] ndata = {this.nidx,this.usenotice,this.ntitle,this.nwriter,url2,this.ncontent,nindate,viewcount};
		ArrayList<String> ar = new ArrayList<String>(Arrays.asList(ndata));
		
		
		update_module um = new update_module();
		um.notiUpdate(ar);
		String memberUpdate_result = um.updateOk.intern();
		if(memberUpdate_result=="ok") {
			pr.print("<script>"
					+ "alert('공지수정이 완료되었습니다.'); location.href='./notice_list.do';"
					+ "</script>");
			
		}else {
			pr.print("<script>"
					+ "alert('올바른 값이 아닙니다.'); history.go(-1);"
					+ "</script>");
		}
		
	}
	

}
