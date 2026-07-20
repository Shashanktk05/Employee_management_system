package daoLayers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entityLayer.Users;
import utilityLayer.GetDbConnection;

public class UsersDao {

	static Connection con = GetDbConnection.getConnectionObject();

	public static List<String> fetchAllEmails() {

		String s = "Select email from users";
		try {
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(s);
			List<String> ls = new ArrayList<String>();
			while (res.next()) {
				ls.add(res.getString("email"));
			}

			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Users getDetails(String email) {
		String s = "Select * from users where email=?";

		try {
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, email);
			pstmt.execute();
			ResultSet res = pstmt.getResultSet();
			Users u = null;
			if (res.next()) {
				u = new Users(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
