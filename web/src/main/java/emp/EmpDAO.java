package emp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class EmpDAO extends DAO {
	PreparedStatement psmt;

	public void insertEmp(Map<String, String> map) {
		connect();
		String sql = "insert into emp_demo (employee_id, last_name, email, hire_date, job_id)\r\n"
				+ "values(?,?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, map.get("id"));
			psmt.setString(2, map.get("name"));
			psmt.setString(3, map.get("email"));
			psmt.setString(4, map.get("hire"));
			psmt.setString(5, map.get("job"));
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}// end of finally

	}
}
