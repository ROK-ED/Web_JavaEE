package com.yedam.full;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emp.DAO;

public class CalDAO extends DAO {
	// 삭제
	public void deleteSchedule(String title) throws Exception {
		String sql = "delete from full_calender where title = ?";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("알수 없는 오류입니다.");

		} finally {
			disconnect();
		}
	}

	// 입력
	public void insertSchedule(String title, String start, String end) throws Exception {
		String sql = "insert into full_calender(title, start_day, end_day) values(?,?,?)";
		connect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, start);
			psmt.setString(3, end);

			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("알수 없는 오류입니다.");

		} finally {
			disconnect();
		}

	}

	// 전체조회
	public List<CalendarVO> getSchedules() {
		List<CalendarVO> list = new ArrayList<>();
		String sql = "select * from full_calender";
		connect();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setEndDay(rs.getString("end_day"));
				vo.setGroupId(rs.getInt("group_id"));
				vo.setStartDay(rs.getString("start_day"));
				vo.setTitle(rs.getString("title"));
				vo.setUrl(rs.getString("url"));

				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
