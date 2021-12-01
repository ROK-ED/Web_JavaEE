package com.yedam.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/GetEmpByDeptServ")
public class GetEmpByDeptServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetEmpByDeptServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		Map<String, Integer> map = dao.getEmpByDepartment();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.getWriter().print(gson.toJson(map).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
