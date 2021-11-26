package com.yedam.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
					+ "\",\"lname\":\"" + list.get(cnt).getLastName() + "\"}");
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

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String empId = request.getParameter("empId");

		System.out.println("fname: " + firstName);
		System.out.println("lname: " + lastName);
		System.out.println("empId: " + empId);

		EmpDAO dao = new EmpDAO();
		dao.insertEmp(empId, firstName, lastName, "test@meail.com", "IT_PROG", "2020-05-05");
		// {"retCode":"
		response.getWriter().println("");

	}

}
