package com.kosta.controller4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet("/InitParamServlet")
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext app = getServletContext();

		String diver = app.getInitParameter("driver");
		String userid = app.getInitParameter("userid");
		String userpass = app.getInitParameter("userpass");

		System.out.println(diver);
		System.out.println(userid);
		System.out.println(userpass);

		// 파일 읽기
		InputStream is = app.getResourceAsStream("/WEB-INF/web.xml");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str;
		while ((str = br.readLine()) != null) {
			System.err.println(str);
		}
		br.close();
		is.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
