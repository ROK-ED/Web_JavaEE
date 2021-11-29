package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yedam.emp.EmployeeVO;

import emp.DAO;

class Employee {
	private int emplyeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String hireDate;
	private String jobId;
	private int salary;

	public Employee(int emplyeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate,
			String jobId, int salary) {
		super();
		this.emplyeeId = emplyeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
	}

	public int getEmplyeeId() {
		return emplyeeId;
	}

	public void setEmplyeeId(int emplyeeId) {
		this.emplyeeId = emplyeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [emplyeeId=" + emplyeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary="
				+ salary + "]";
	}

}

public class EmpDAO extends DAO {

	// 한건조회(사원번호).
	public EmployeeVO findEmployee(String empId) {
		String sql = "select * from emp_damo where EMPLOYEE_ID = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				EmployeeVO vo = new EmployeeVO();
				vo.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				vo.setFirstName(rs.getString("FIRST_NAME"));
				vo.setLastName(rs.getString("LAST_NAME"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setJobId(rs.getString("JOB_ID"));
				vo.setHireDate(rs.getString("HIRE_DATE"));
				vo.setSalary(rs.getInt("salary"));

				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return null;
	}

	// 삭제기능(사원번호)
	public boolean deleteEmployee(String empId) {
		String sql = "delete from empl_demo where employee_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, empId);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 수정기능(사원번호).
	public EmployeeVO updateEmployee(EmployeeVO vo) {
		String sql = "update empl_demo\r\n"//
				+ "set    first_name = ?,\r\n"//
				+ "       last_name = ?,\r\n"//
				+ "       email = ?,\r\n"//
				+ "       hire_date = ?,\r\n"//
				+ "       salary = ?\r\n"//
				+ "where employee_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setInt(5, vo.getSalary());
			psmt.setInt(6, vo.getEmployeeId());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
			if (r > 0) {
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 입력기능
//	public void insertEmp(String eid, String fn, String ln, String em, String ji, String hd) {
	public boolean insertEmp(EmployeeVO vo) {
		String sql = "insert into emp_demo(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, JOB_ID, HIRE_DATE, salary)"
				+ "values(?,?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getJobId());
			psmt.setString(6, vo.getHireDate());
			psmt.setInt(7, vo.getSalary());

			int r = psmt.executeUpdate();
			System.out.println(r + "건수 입력됨.");
			if (r < 1) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
	}

	// 전체조회
	public List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		String sql = "select * from emp_demo order by 1 desc";
		// 1. db연결.
		connect();
		// 2. 쿼리 결과
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"), rs.getString("EMAIL"), rs.getString("PHONE_NUMBER"),
						rs.getString("HIRE_DATE").substring(0, 10), // 시간 잘라냄
						rs.getString("JOB_ID"), rs.getInt("SALARY"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;

	}

	// 연습용

	public String getString(String name) {
		String something = "Hello, " + name;
		return something;
	}

	public List<String> getNames() {
		String[] names = { "홍길동", "김민기", "박정숙", "최근영" };
		List<String> reutrnList = new ArrayList<String>();
		for (String name : names) {
			reutrnList.add(name);
		}
		return reutrnList;
	}

	public Map<String, Integer> getScores() {
		String[] names = { "홍길동", "김민기", "박정숙", "최근영" };
		Map<String, Integer> map = new HashMap<String, Integer>();
		int score = 80;
		for (String name : names) {
			map.put(name, score++);
		}
		return map;
	}
}
