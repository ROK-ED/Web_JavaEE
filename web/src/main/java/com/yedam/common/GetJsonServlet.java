package com.yedam.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.emp.EmployeeVO;

/**
 * Servlet implementation class GetJsonServlet
 */
@WebServlet("/GetJsonServlet")
public class GetJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetJsonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmployees();
		int size = list.size();
		int cnt = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		while (true) {
			sb.append("{\"empId\":" + list.get(cnt).getEmplyeeId() + ",\"fname\":\"" + list.get(cnt).getFirstName()
					+ "\",\"lname\":\"" + list.get(cnt).getLastName() + "\",\"email\":\"" + list.get(cnt).getEmail()
					+ "\",\"hdate\":\"" + list.get(cnt).getHireDate() + "\",\"salary\":\"" + list.get(cnt).getSalary()
					+ "\"}");
			cnt++;
			if (cnt == size) {
				break;
			} else {
				sb.append(",\n");
			}
		}
		sb.append("]");
		System.out.println(sb.toString()); // 콘솔창 출력

		response.getWriter().println(sb.toString()); // 웹 페이지 출력
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String firstName = request.getParameter("fname");
//		String lastName = request.getParameter("lname");
//		String empId = request.getParameter("empId");

//		System.out.println("fname: " + firstName);
//		System.out.println("lname: " + lastName);
//		System.out.println("empId: " + empId);
//		

		String cmd = request.getParameter("cmd"); /////////////

		String empId = request.getParameter("a");
		String firstName = request.getParameter("b");
		String lastName = request.getParameter("c");
		String email = request.getParameter("d");
		String hireDate = request.getParameter("e");
		String jobId = request.getParameter("f");
		String salary = request.getParameter("g");

		System.out.println("b: " + firstName);
		System.out.println("c: " + lastName);
		System.out.println("a: " + empId);

		EmpDAO dao = new EmpDAO();

		EmployeeVO vo = new EmployeeVO();
//		vo.setEmployeeId(Integer.parseInt(empId));
//		vo.setFirstName(firstName);
//		vo.setLastName(lastName);
//		vo.setEmail("asdf@asdf.com");
//		vo.setJobId("IT_PROG");
//		vo.setHireDate("2020-05-05");
//		vo.setSalary(2000);

		vo.setEmployeeId(Integer.parseInt(empId));
		vo.setFirstName(firstName);
		vo.setLastName(lastName);
		vo.setEmail(email);
		vo.setJobId(jobId);
		vo.setHireDate(hireDate);
		if(!cmd.equals("delete")) {
			
			vo.setSalary(Integer.parseInt(salary));
		}

		// 처리결과 페이지에 출력
//		dao.insertEmp(empId, firstName, lastName, "test@meail.com", "IT_PROG", "2020-05-05");
		if (cmd.equals("insert")) {

			if (dao.insertEmp(vo)) {
				response.getWriter().println("{\"retCode\":\"Success\"}");
			} else {
				response.getWriter().println("{\"retCode\":\"Fail\"}");
			}
			// {"retCode":"
//		response.getWriter().println("");
		} else if (cmd.equals("update")) {

			// 처리결과 페이지에 출력
			if (dao.updateEmployee(vo) != null) {
				response.getWriter().println("{\"retCode\":\"Success\"}");
			} else {
				response.getWriter().println("{\"retCode\":\"Fail\"}");
			}

		} else if (cmd.equals("delete")) {

			// 처리결과 페이지에 출력
			if (dao.deleteEmployee(empId)) {
				response.getWriter().println("{\"retCode\":\"Success\"}");
			} else {
				response.getWriter().println("{\"retCode\":\"Fail\"}");
			}
		}
	}

}
