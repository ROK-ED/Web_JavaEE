package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

	Connection conn;

	protected void connect() {
		// 1.JDBC Driver 로딩하기.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.DB 서버 접속하기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, id, password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
