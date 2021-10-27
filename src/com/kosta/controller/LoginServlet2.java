package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String ad = request.getParameter("user_address");
		System.out.println(id);
		System.out.println(pw);
		System.out.println(ad);
		request.setAttribute("major", "컴공");
		request.setAttribute("phone", "010-1234-5678");

		// 요청재지정...주소창은 바뀌지않고 전달받은 요청과 응답정보를 다른곳으로 위임한다
		RequestDispatcher rd = request.getRequestDispatcher("jsp/result.jsp");
		rd.forward(request, response);

	}

}
