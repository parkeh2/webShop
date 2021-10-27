package com.kosta.controller3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmpService;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empdelete")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//////////////////////////////////////////////////////////////
		// 세션에 저장된 멤버가 없다면 로그인 안한것
		// 로그인없이 직원정보 보기 불가
//		HttpSession session = request.getSession();
//		Object obj = session.getAttribute("member");
//		if (obj == null) {
//			System.out.println("로그인없이 직원정보 보기 불가");
//			response.sendRedirect("../pro09/memberlogin");
//			return;
//		}
		/////////////////////////////////////////////////////////////

		// 직원정보 삭제
		int empid = Integer.parseInt(request.getParameter("empid"));
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		// request.setAttribute("emp", service.empDelete(empid) > 0 ? "삭제성공" : "삭제실패");
		// RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		// rd.forward(request, response);
		String message = result >= 0 ? "success" : "fail";
		// 2.sendRedirect
		// 한글 인코딩 필요
		response.sendRedirect("emplist?message=" + message);

	}

}