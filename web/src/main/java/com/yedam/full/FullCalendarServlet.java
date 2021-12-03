package com.yedam.full;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/FullCalendarServlet")
public class FullCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FullCalendarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");

		CalDAO dao = new CalDAO();
		List<CalendarVO> list = dao.getSchedules();

		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");

		String cmd = request.getParameter("cmd");
		String title = request.getParameter("title");
		String startDay = request.getParameter("start");
		String endDay = request.getParameter("end");

		CalDAO dao = new CalDAO();

		if (cmd.equals("add")) {
			try {
				dao.insertSchedule(title, startDay, endDay);
				// {"retCode":"Success"}
				response.getWriter().print(" {\"retCode\":\"Success\"}");
			} catch (Exception e) {
				// {"retCode":"Fail"}
				response.getWriter().print(" {\"retCode\":\"Fail\"}");
			}
		} else if (cmd.equals("delete")) {
			try {
				dao.deleteSchedule(title);
				response.getWriter().print(" {\"retCode\":\"Success\"}");
			} catch (Exception e) {
				// {"retCode":"Fail"}
				response.getWriter().print(" {\"retCode\":\"Fail\"}");
			}
		} else {

			response.getWriter().print(" {\"retCode\":\"잘못된 요청입니다.\"}");
		}

	}

}
