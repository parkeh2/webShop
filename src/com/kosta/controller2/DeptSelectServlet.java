package com.kosta.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptDTO;
import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptSelectServlet
 */
@WebServlet("/dept/deptlist")
public class DeptSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	    
		//�����α׷������� ������ ...���������� �޶��� 
		String path = getServletContext().getRealPath(".");
		System.out.println(path);
 
		DeptService service = new DeptService(path);
 	    List<DeptDTO> deptlist = service.selectAllService();
 	    request.setAttribute("deptlistInfo", deptlist);
	    RequestDispatcher rd;
	    rd = request.getRequestDispatcher("deptAll.jsp");
	    rd.forward(request, response);
	}
}
