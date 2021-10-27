package com.kosta.controller2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/day1018/InputServlet")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("day1018/input.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post요청입니다.");
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String[] subject = request.getParameterValues("subject");

		System.out.println(user_id);
		System.out.println(user_pw);
		System.out.println(Arrays.toString(subject));

		// 파라메터의 갯수가 가변인경우(여러개인 경우)
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("파라메터 이름" + name);

			String[] values = request.getParameterValues(name);
			System.out.println(Arrays.toString(values));
		}

		request.setAttribute("message", Arrays.toString(subject));
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
		rd.forward(request, response);

	}

}
