package day6.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSaveController implements Controller{
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String test = request.getParameter("test");
		//POST 요청 처리 후에는 특정 url 로 리다이렉트 합니다.
		response.sendRedirect("modify?test="+test);
	}

}
