package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/cim_system";
		try {
			con = DriverManager.getConnection(url, "root", "karan2004");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

}
