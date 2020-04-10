package dev.rong.entities;

public class Manager {
	private int mid;
	private String name;
	private String password;
	
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

	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
