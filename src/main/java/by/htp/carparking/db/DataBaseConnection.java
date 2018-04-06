package by.htp.carparking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseConnection {
	private static Connection connection = null;
	private static final String DB_CONNECT_PROPERTY = "db_config";

	public static Connection getDBConnection() {
		ResourceBundle rb = ResourceBundle.getBundle(DB_CONNECT_PROPERTY);
		try {
			Class.forName(rb.getString("db.driver"));
			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(rb.getString("db.url"), rb.getString("db.login"),
					rb.getString("db.pass"));
//			connection = 
//					DriverManager.getConnection(
//					"jdbc:mysql://127.0.0.1:2016/jd02?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false",
//					"root","");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
