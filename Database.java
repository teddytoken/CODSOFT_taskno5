package registration;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public static Connection provideConnection() {
		Connection conn = null;
		try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_registration","root","Snehal@#123");
		}catch(Exception e) {
			e.printStackTrace();
		}
	return conn;
	}
}
