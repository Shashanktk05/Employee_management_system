package daoLayers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entityLayer.Employee;
import utilityLayer.GetDbConnection;

public class EmployeeDao {

	Connection con = GetDbConnection.getConnectionObject();

	public boolean insertDetails(Employee e) {
		if (con == null) {
			return false;
		}

		String query = "INSERT INTO `EMPLOYEE` VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, e.getName());
			pstmt.setInt(3, e.getAge());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getPhoneNumber());
			pstmt.setString(6, e.getAddress());
			pstmt.setDouble(7, e.getSalary());
			pstmt.setBoolean(8, e.isActive());
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean deleteDetailsById(int value) {
		String query = "DELETE FROM `EMPLOYEE` WHERE `ID`=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, value);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteDetailsByEmail(String value) {
		String query = "DELETE FROM `EMPLOYEE` WHERE `email`=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteDetailsByPhno(String value) {
		String query = "DELETE FROM `EMPLOYEE` WHERE `phoneNumber`=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateAdress(int id, String value) {
		String query = "UPDATE  `EMPLOYEE` SET `ADDRESS`=? WHERE `ID`=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateName(int id, String value) {
		String query = "UPDATE  `EMPLOYEE` SET `NAME`=? WHERE `ID`=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateEmail(int id, String value) {
		String query = "UPDATE  `EMPLOYEE` SET `EMAIL`=? WHERE `ID`=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatePhno(int id, String value) {
		String query = "UPDATE  `EMPLOYEE` SET `PHONENUMBER`=? WHERE `ID`=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, value);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateAge(int id, String value) {
		String query = "UPDATE  `EMPLOYEE` SET `age`=? WHERE `ID`=?";
		int age = Integer.parseInt(value);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, age);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateSalary(int id, String value) {
		String query = "UPDATE  `EMPLOYEE` SET `SALARY`=? WHERE `ID`=?";
		double sal = Double.parseDouble(value);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, sal);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateState(int id, String value) {
		String query = "UPDATE  `EMPLOYEE` SET `isactive`=? WHERE `ID`=?";
		boolean val = Boolean.parseBoolean(value);
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setBoolean(1, val);
			pstmt.setInt(2, id);
			int i = pstmt.executeUpdate();
			return i > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Employee selectDetailsById(int id) {
		String query = "SELECT * FROM `EMPLOYEE` WHERE `ID`=?";
		Employee emp = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
			}
			return emp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectDetailsByIdAsc() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			Collections.sort(al, (o1, o2) -> Integer.valueOf(o1.getId()).compareTo(o2.getId()));
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectDetailsBySalAsc() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			Collections.sort(al, (o1, o2) -> Double.valueOf(o1.getSalary()).compareTo(o2.getSalary()));
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectDetailsBySalDesc() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			Collections.sort(al, (o1, o2) -> -1 * Double.valueOf(o1.getSalary()).compareTo(o2.getSalary()));
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectDetailsByIdDesc() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			Collections.sort(al, (o1, o2) -> -1 * Integer.valueOf(o1.getId()).compareTo(o2.getId()));
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectDetailsByNameAsc() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			Collections.sort(al, (o1, o2) -> o1.getName().compareTo(o2.getName()));
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> selectDetailsByNameDesc() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			Collections.sort(al, (o1, o2) -> -1 * o1.getName().compareTo(o2.getName()));
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Employee> selectAllDetails() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			return al;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Employee> selectDetailsByActive() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			List<Employee> activeList = new ArrayList<>();

			for (Employee e : al) {
			    if (e.isActive()) {
			        activeList.add(e);
			    }
			}
			return activeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> selectDetailsByNotActive() {
		String query = "SELECT * FROM `EMPLOYEE`";
		Employee emp = null;
		List<Employee> al = new ArrayList<Employee>();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				emp = new Employee(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5),
						res.getString(6), res.getDouble(7), res.getBoolean(8));
				al.add(emp);
			}
			List<Employee> activeList = new ArrayList<>();

			for (Employee e : al) {
			    if (!e.isActive()) {
			        activeList.add(e);
			    }
			}
			return activeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
