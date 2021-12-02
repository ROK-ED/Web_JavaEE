package com.yedam.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.EmpDAO;
import com.yedam.common.Employee;

@WebServlet("/serverSide")
//@WebServlet("/serverSide.html") //html 처럼 보이기만 할뿐
public class EmpServerSideServ extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			PrintWriter out = resp.getWriter();
			StringBuffer sb = new StringBuffer();
			
			String page = req.getParameter("page"); // ?page=https://www.daum.net
			
			//resp.sendRedirect(page);//다른페이지로 넘기겠다는 의미
			
			resp.sendRedirect("./emp/employee.html");//이쪽 페이지로 던짐 (이건 오류가없음)
		    /*RequestDispatcher rd = req.getRequestDispatcher("./emp/employee.html");//이쪽 페이지로 던짐 (이건 UTF 설정등 다시 다해야됨)
			rd.forward(req, resp);*/
			
//			System.out.println("요청방식: "+ req.getMethod());
//
//			EmpDAO dao = new EmpDAO();
//			List<Employee> list = dao.getEmployees();
//			for (Employee emp : list) {
//				sb.append("<p>" + emp.getEmployeeId() + ", " + emp.getFirstName() + ", " + emp.getLastName() + "</p>");
//			}
//			
//			sb.append("<script>");
//			sb.append("alert('javascript');");
//			sb.append("</script>");
//
//			out.print(sb.toString());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("Post Request");
	}

}
