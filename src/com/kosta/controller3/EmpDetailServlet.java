package com.kosta.controller3;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmpService;
import com.kosta.model.EmployeeVO;
import com.kosta.util.DateUtil;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empdetail")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 직원정보 상세보기

		// 로그인하지않으면 업무불가
		// HttpSession session = request.getSession();
		// Object obj = session.getAttribute("member");
		// if (obj == null) {
		// System.out.println("업무불가");
		// response.sendRedirect("../html/loginpost");
		// return;
		// }
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

		int empid = Integer.parseInt(request.getParameter("empid"));
		EmpService service = new EmpService();
		request.setAttribute("emp", service.selectByEmpid(empid));
		RequestDispatcher rd = request.getRequestDispatcher("empdetail.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeVO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empUpdate(emp);
		// request.setAttribute("message", result > 0 ? "수정성공" : "수정실패");
		// response.addHeader("Refresh", "1;url=emplist");
		// RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		// rd.forward(request, response);
		response.sendRedirect("emplist"); // 다시요청한다. 요청재지정하기
		// 브라우저로 내려가서 다시 서버에 요청한다.
		// 서블릿으로 요청보내기...jps에 forward
	}

	private EmployeeVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
		//request.setCharacterEncoding("utf-8");
		int empid = Integer.parseInt(request.getParameter("employee_id"));
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		String job_id = request.getParameter("job_id");
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		Date hire_date = DateUtil.convertToDate(request.getParameter("hire_date"));

		EmployeeVO emp = new EmployeeVO();
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(department_id);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(manager_id);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		System.out.println(emp);
		return emp;
	}

}
