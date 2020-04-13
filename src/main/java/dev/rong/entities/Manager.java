package dev.rong.entities;

public class Manager {
	private int mid;
	private String username;
	private String password;
	private String name;
	
	public Manager(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public Manager() {
		super();
	}

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
		return "Manager [mid=" + mid + ", username=" + username + ", password=" + password + ", name=" + name + "]";
	}

	
	
}
