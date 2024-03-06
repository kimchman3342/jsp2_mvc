package day6.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import day6.project.dao.TblProductDao;
import day6.project.dto.ProductDto;


@WebServlet(urlPatterns = { "/productReg.cc" }, description = "상품 등록")
public class ProductRegServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ProductRegServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[Myinfo] 상품등록 화면 요청됨.");
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("/day3/productReg.jsp");
		dispatcher.forward(req, resp);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("[Myinfo] 상품등록 데이터 저장이 요청됨.");
		
		req.setCharacterEncoding("UTF-8");
		
		String pcode = req.getParameter("pcode");
		String category = req.getParameter("category");
		String pname = req.getParameter("pname");
		String temp = req.getParameter("price");

		int price = 0;
		if(temp.length() !=0) price = Integer.parseInt(temp);


		ProductDto vo = new ProductDto(pcode, category, pname, price);
		logger.info("\t 입력값 vo : {}",vo);
		
		TblProductDao dao = new TblProductDao();
		int result = dao.insert(vo);	
		
		//resp.sendRedirect("products.cc");		//=>대신에 alert 출력
		
		String message= "상품 등록이 완료되었습니다";
		if (result ==0) {
			message = "상품등록 오류가 발생했습니다";
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<script>");
		out.print("alert('"+message+"');");
		out.print("location.href='products.cc';");
		out.print("</script>");
	}
}
