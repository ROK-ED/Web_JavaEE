package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	// 입력기능
	public void insertEmp(String eid, String fn, String ln, String em, String ji, String hd) {
		String sql = "insert into emp_demo(EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, JOB_ID, HIRE_DATE)"
				+ "values(?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, eid);
			psmt.setString(2, fn);
			psmt.setString(3, ln);
			psmt.setString(4, em);
			psmt.setString(5, ji);
			psmt.setString(6, hd);
			int r = psmt.executeUpdate();
			System.out.println(r + "건수 입력됨.");
		} catch (SQLException e) {
			e.printStackTrace();
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
						rs.getString("HIRE_DATE"), rs.getString("JOB_ID"), rs.getInt("SALARY"));
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
