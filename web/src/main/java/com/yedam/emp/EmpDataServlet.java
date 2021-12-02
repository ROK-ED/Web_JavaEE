package com.yedam.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.yedam.common.EmpDAO;
import com.yedam.common.Employee;



public class EmpDataServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init()");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init(config)");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.service(req, res);
		System.out.println("service(ServletRequest)");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		System.out.println("service(HttpServletRequest)");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		//resp.getWriter().print("Hello");
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmployees();
		
		JSONArray outAry = new JSONArray();
		for(Employee emp : list) {
			JsonArray inAry = new JsonArray();
			inAry.add(emp.getEmployeeId());
			inAry.add(emp.getFirstName());
			inAry.add(emp.getLastName());
			inAry.add(emp.getEmail());
			inAry.add(emp.getHireDate());
			inAry.add(emp.getSalary());
			
			outAry.add(inAry);
		}
		
		JSONObject obj = new JSONObject();
		obj.put("data", outAry);
		resp.getWriter().print(obj.toString());
		
		//Gson gson = new GsonBuilder().setPrettyPrinting().create();
		//resp.getWriter().print(gson.toJson(list).toString());
	}
}
