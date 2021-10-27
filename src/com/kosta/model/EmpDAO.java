package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kosta.util.DBUtil2;
import com.kosta.util.DateUtil;

//DAO(Data Access Object)
//Repository역할 
public class EmpDAO {

	// DML(Data Manipulation Languaeg)--insert, update, delete

	public int empDelete(int empid) {
		int result = 0; // delete건수
		String sql = " delete from employees where EMPLOYEE_ID = ?";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}

	public int empUpdate2(EmployeeVO emp) {
		int result = 0; // update건수
		String sql = "update employees set EMPLOYEE_ID =" + emp.getEmployee_id();
		String whereSQL = " where EMPLOYEE_ID =" + emp.getEmployee_id();
		String fnameSQL = " ", lnameSQL = " ", emailSQL = " ", phoneSQL = " ", jobSQL = " ", salSQL = " ",
				commSQL = " ";
		if (emp.getFirst_name() != null)
			fnameSQL = ",first_name='" + emp.getFirst_name() + "'";
		if (emp.getLast_name() != null)
			lnameSQL = ",last_name='" + emp.getLast_name() + "'";
		if (emp.getEmail() != null)
			emailSQL = ",email='" + emp.getEmail() + "'";
		if (emp.getPhone_number() != null)
			phoneSQL = ",phone_number='" + emp.getPhone_number() + "'";
		if (emp.getJob_id() != null)
			jobSQL = ",job_id='" + emp.getJob_id() + "'";
		if (emp.getSalary() >= 0)
			salSQL = ",salary=" + emp.getSalary();
		if (emp.getCommission_pct() >= 0)
			commSQL = ",Commission_pct=" + emp.getCommission_pct();

		sql += fnameSQL + lnameSQL + emailSQL + phoneSQL + jobSQL + salSQL + commSQL + whereSQL;
		System.out.println("SQL문:" + sql);
		Connection conn = DBUtil2.dbConnect();
		Statement st = null;
		try {
			st = conn.createStatement();
			result = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}

	public int empUpdate(EmployeeVO emp) {
		int result = 0; // insert건수
		String sql = "update employees set " + " FIRST_NAME=?," + " LAST_NAME=?," + " EMAIL=?," + " PHONE_NUMBER=?,"
				+ " HIRE_DATE=?," + " JOB_ID=?," + " SALARY=?," + " COMMISSION_PCT=?," + " MANAGER_ID=?,"
				+ " DEPARTMENT_ID=?" + " where EMPLOYEE_ID = ?";

		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(11, emp.getEmployee_id());
			st.setString(1, emp.getFirst_name());
			st.setString(2, emp.getLast_name());
			st.setString(3, emp.getEmail());
			st.setString(4, emp.getPhone_number());
			st.setDate(5, emp.getHire_date());
			st.setString(6, emp.getJob_id());
			st.setInt(7, emp.getSalary());
			st.setDouble(8, emp.getCommission_pct());
			st.setInt(9, emp.getManager_id());
			st.setInt(10, emp.getDepartment_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}

	public int empInsert(EmployeeVO emp) {
		int result = 0; // insert건수
		String sql = "insert into employees " + "values(?,?,?,?,?,?,?,?,?,?,?)";

		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone_number());
			st.setDate(6, emp.getHire_date());
			st.setString(7, emp.getJob_id());
			st.setInt(8, emp.getSalary());
			st.setDouble(9, emp.getCommission_pct());
			st.setInt(10, emp.getManager_id());
			st.setInt(11, emp.getDepartment_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, null);
		}
		return result;
	}

	// 이체하기서비스: (계좌에서 출금하기 기능, 계좌에서 입금하기 기능)
	public void withdraw() {
		System.out.println("출금한다.");
	}

	public void deposit() {
		System.out.println("입금한다.");
	}

	// 모든직원조회
	public List<EmployeeVO> selectAll() {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees order by 1";
		Connection conn = DBUtil2.dbConnect();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	// 특정부서의 직원조회
	public List<EmployeeVO> selectById(int deptid) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees where department_id=?";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);// sql문 준비한다.
			st.setInt(1, deptid); // 첫번째?에 부서번호를 넣어라~
			rs = st.executeQuery();// 실행
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	// salary가 특정금액 이상인 직원들 조회
	public List<EmployeeVO> selectBySalary(int sal) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees where salary >= ?";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); // sql문에 ?도있어
			st.setInt(1, sal);// 첫번째 ?에 sal를 할당
			rs = st.executeQuery(); // sql문 실행
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	// job_id가 특정값인 직원들 조회
	public List<EmployeeVO> selectByJob(String jobid) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees where job_id = ? ";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); // sql문에 ?가있다.
			st.setString(1, jobid); // 첫번째 ?에 jobid가 setting
			rs = st.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	// 부서코드, 직책, 급여, 입사일
	public List<EmployeeVO> selectByCondition(int deptid, String jobid, int sal, String hdate) {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select * from Employees " + " where department_id=? " + " and job_id = ? " + " and salary>=? "
				+ " and hire_date>=? ";
		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); // sql문에 ?가있다.
			st.setInt(1, deptid);
			st.setString(2, jobid);
			st.setInt(3, sal);
			st.setDate(4, DateUtil.convertToDate(hdate));
			rs = st.executeQuery();
			while (rs.next()) {
				emplist.add(makeEmp(rs));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 오류여부와 상관없이 무조건 수행
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

	private EmployeeVO makeEmp(ResultSet rs) throws SQLException {
		// DB가 사용하는 객체와 JAVA가 사용가 사용하는 객체가 다르다. 자동으로 setting불가
		// 개발자가 ResultSet를 읽어서 자바의 객체에 setting해야한다.
		EmployeeVO emp = new EmployeeVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getInt("Salary"));
		return emp;
	}

	public EmployeeVO selectByEmpid(int empid) {
		EmployeeVO emp = null;
		String sql = "select * from Employees where Employee_id=? ";

		Connection conn = DBUtil2.dbConnect();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql); // sql문에 ?가있다.
			st.setInt(1, empid);
			rs = st.executeQuery();
			while (rs.next()) {
				emp = makeEmp(rs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 오류여부와 상관없이 무조건 수행
			DBUtil2.dbClose(conn, st, rs);
		}

		return emp;
	}

	// 특정부서직원들 조회

	// 모든 매니저 조회하기
	public List<EmployeeVO> selectAllManager() {
		List<EmployeeVO> emplist = new ArrayList<>();
		String sql = "select distinct emp.manager_id , manager.first_name"
				+ " from employees emp join employees manager on (emp.manager_id = manager.employee_id)"
				+ " where emp.manager_id is not null order by 1";
		Connection conn = DBUtil2.dbConnect();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmployee_id(rs.getInt(1));
				emp.setFirst_name(rs.getString(2));
				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil2.dbClose(conn, st, rs);
		}
		return emplist;
	}

}
