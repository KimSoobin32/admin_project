package admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import admin.module.insert_module;
import admin.module.today;

@MultipartConfig(	//파일 업로드 기능 처리 시 사용되는 어노테이션 속성		
		fileSizeThreshold = 1024 * 1024 * 1,	//1MB(파일 업로드 시 사용되는 메모리 임시크기 용량)
		maxFileSize = 1024 * 1024 * 2,	//2MB(업로드 파일 최대 크기값)
		maxRequestSize = 1024 * 1024 * 2	//2MB(전송에 따른 최대 크기값)
)


public class productWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public productWrite() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = null;
		String path = null;
		String url=null;
		String newUrl=null;
		
		String filename2 = null;
		String path2 = null;
		String url2=null;
		String newUrl2=null;
		
		String filename3 = null;
		String path3 = null;
		String url3=null;
		String newUrl3=null;
		
		
		String b_prcatecode = URLDecoder.decode(request.getParameter("b_prcatecode"),"UTF-8");
		String s_prcatecode = URLDecoder.decode(request.getParameter("s_prcatecode"),"UTF-8");
		String prcategorycode = b_prcatecode + s_prcatecode;
		String productcode = URLDecoder.decode(request.getParameter("productcode"),"UTF-8");
		String prnm = URLDecoder.decode(request.getParameter("prnm"),"UTF-8");
		String praddex = URLDecoder.decode(request.getParameter("praddex"),"UTF-8");
		String prprice = URLDecoder.decode(request.getParameter("prprice"),"UTF-8");
		String prdcpercent = URLDecoder.decode(request.getParameter("prdcpercent"),"UTF-8");	
		String prdcprice = URLDecoder.decode(request.getParameter("prdcprice"),"UTF-8");
		String prstock = URLDecoder.decode(request.getParameter("prstock"),"UTF-8");
		String usesell = URLDecoder.decode(request.getParameter("usesell"),"UTF-8");
		String usesoldout = URLDecoder.decode(request.getParameter("usesoldout"),"UTF-8");
		String prdetailex = URLDecoder.decode(request.getParameter("contents"),"UTF-8");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pr = response.getWriter();
		today now = new today();
		String prindate = now.getDateTimeNow();
		String prupdate = null;
		
		path = request.getServletContext().getRealPath("");
		File fe = new File(path+"product/");	//디렉토리 생성
		if(!fe.exists()) {
			fe.mkdirs(); // 없으면 만든다. 있으면 패스 else 안적음.
		}
		url = path+"product/";
		
		//방법 2		
		Collection<Part> p = request.getParts();	//여러파일 업로드 시..
		
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = sf.format(date);
		
		
		for(Part part : p){
			
			//part.getName() : 첨부파일 파일 name (p_img1...)
			String fileName = part.getSubmittedFileName();	//첨부파일명
			String names = part.getName();
			String imgurl = "";
			
			if(fileName != null && !fileName.equals("")){	//조건 없으면 null파일도 생성됨..
				part.write(url+time+fileName);	
				imgurl = "./portfolio/product/"+time+fileName;
				//System.out.println(url+time+fileName);
			}else {
				imgurl = "";
			}
			
			switch(names) {
			case "primg1":
				newUrl = imgurl;
				break;
			case "primg2":
				newUrl2 = imgurl;
				break;
			case "primg3":
				newUrl3 = imgurl;
				break;
			}
			
			
		}
		
		
		String[] prdata = {"product_table",prcategorycode,b_prcatecode,s_prcatecode,productcode,prnm,praddex,prprice,prdcpercent,prdcprice,prstock,usesell,usesoldout,newUrl,newUrl2,newUrl3,prdetailex,prindate,prupdate};
		ArrayList<String> ar = new ArrayList<>(Arrays.asList(prdata));

		
		insert_module im = new insert_module();
		String result_sign = im.insert(ar).intern();
		if(result_sign=="ok") {
			pr.print("<script>"
					+ "alert('상품등록이 완료되었습니다.'); location.href='./product_list.do';"
					+ "</script>");
			
		}else {
			pr.print("<script>"
					+ "alert('올바른 값이 아닙니다.'); history.go(-1);"
					+ "</script>");
		}
		
		
	}

}
