package dev.rong.entities;

public class Employee {
	private int eid;
	private String username;
	private String password;
	private String name;
	
	
	
	public Employee(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", username=" + username + ", password=" + password + ", name=" + name + "]";
	}
	
	
}
