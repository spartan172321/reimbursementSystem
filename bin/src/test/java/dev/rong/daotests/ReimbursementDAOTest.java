package dev.rong.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.rong.dao.ReimbursementDAO;
import dev.rong.dao.ReimbursementDAOMaria;
import dev.rong.entities.Reimbursement;

public class ReimbursementDAOTest {
 
	ReimbursementDAO rdao = new ReimbursementDAOMaria();
	@Test
	public void createReimbursement() {
		Reimbursement r = new Reimbursement();
		r.setAmount(900.0);
		r.setDescription("Dinning expense");
		r.setEid(1);
		r.setStatus("Pending");
		rdao.createReimbursement(r);
	}
	
	@Test
	public void getReimbursementsByEid() {
		System.out.println(rdao.getReimbursementsByEid(1));
	}
	
	@Test
	public void getReimbursmentByMid() {
		System.out.println(rdao.getReimbursementsByMid(1));
	}
	
	@Test
	public void getAllReimbursements() {
		System.out.println(rdao.getAllReimbursements());
	}
	
	@Test
	public void updateReimbursementEntry() {
		Reimbursement r = rdao.getReimbursementByRid(1);
		r.setDescription("Alcohol Expense");
		r.setAmount(5000.0);
		rdao.updateReimbursementEntry(r);
	}
	
	@Test
	public void updateReimbursementStatus() {
		Reimbursement r = rdao.getReimbursementByRid(2);
		r.setStatus("Approved");
		rdao.updateReimbursementStatus(r);
	}
	
	
	
	
	
	
}
