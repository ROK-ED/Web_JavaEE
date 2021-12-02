package com.yedam.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.yedam.common.EmpDAO;
import com.yedam.common.Employee;

public class EmpSubSideServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
		// get, post 요청방식 상관없이 실행
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmployees();

		JSONArray outAry = new JSONArray();
		for (Employee emp : list) {
			JSONArray inAry = new JSONArray();
			inAry.add(emp.getEmployeeId());
			inAry.add(emp.getFirstName());
			inAry.add(emp.getLastName());
			inAry.add(emp.getEmail());
			inAry.add(emp.getHireDate());
			inAry.add(emp.getSalary());

			outAry.add(inAry);
		}
		
		JSONObject obj = new JSONObject();

		obj.put("draw", "1");
		obj.put("recordsTotal", "57");
		obj.put("recordsFiltered", "57");
		obj.put("data", outAry);
		resp.getWriter().print(obj.toString());
	}

}
