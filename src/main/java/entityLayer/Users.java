package entityLayer;

import java.security.Timestamp;

public class Users {

	private int id;
	private String email;
	private String password;
	private String role;
	private int empId;
	private boolean isActive;

	
	public Users(int id, String email, String password, String role, int empId) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + ", empId=" + empId
				+ ", isActive=" + isActive + ", createdAt=" + createdAt + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String email, String password, String role, int empId, boolean isActive, Timestamp createdAt) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.empId = empId;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}

	private Timestamp createdAt;

}
