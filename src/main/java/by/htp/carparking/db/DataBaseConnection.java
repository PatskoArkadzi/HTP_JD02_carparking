package by.htp.carparking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DataBaseConnection {
	private static Connection connection = null;
	private static final String DB_CONNECT_PROPERTY = "db_config";
//	private static final Logger logger = LogManager.getLogger();

	public static Connection getDBConnection() {
		ResourceBundle rb = ResourceBundle.getBundle(DB_CONNECT_PROPERTY);
		try {
			Class.forName(rb.getString("db.driver"));
			connection = DriverManager.getConnection(rb.getString("db.url"), rb.getString("db.login"),
					rb.getString("db.pass"));
		} catch (ClassNotFoundException | SQLException e) {
//			logger.error("Exception", e);
		}
		return connection;
	}
}
