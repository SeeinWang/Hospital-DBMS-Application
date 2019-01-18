package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String DBUSER = "ora_z9d9";
	public static final String DBPASSWORD = "a26752139";

	public static final String DBURL = "jdbc:oracle:thin:@localhost:1522:ug";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DBDRIVER).newInstance();

			con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
