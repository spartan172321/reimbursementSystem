package dev.rong.entities;

public class Reimbursement {
	private int rid;
	private double amount;
	private String description;
	private int eid;
	private int mid;
	
	public Reimbursement(double amount, String description, int eid) {
		super();
		this.amount = amount;
		this.description = description;
		this.eid = eid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Reimbursement [rid=" + rid + ", amount=" + amount + ", description=" + description + ", eid=" + eid
				+ ", mid=" + mid + "]";
	}
	
	
	
}
