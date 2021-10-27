package com.kosta.controller.pro12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmployeeVO;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/pro12/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		// �����̾����� ������ �����ϰ� ������ ���
		// ������ ó������ : ����������
		// �������� �����־ �ٸ���û�� �ϰ��־���. ������ ���
		HttpSession session = request.getSession();
		session.setAttribute("name", "�̼���");
		session.setAttribute("age", "100");
		EmployeeVO emp = new EmployeeVO();
		emp.setFirst_name("������");
		session.setAttribute("emp", emp);

		pw.println("<html><body>");
		pw.println("<h1>���ǿ� �̸��� ���ε��մϴ�.</h1>");
		pw.println("<a href='test01/session1.jsp'>ù��° �������� �̵��ϱ� </a>");
		pw.println("</body></html>");

	}

}
