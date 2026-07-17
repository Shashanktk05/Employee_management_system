package utilityLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDbConnection {

	public static Connection getConnectionObject() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fullstackprojects", "root",
					"Shashanktk@2003");
			System.out.println("DataBase Connection Successful");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

//	public static void main(String[] args) {
//		System.out.println(getConnectionObject());
//	}
}
