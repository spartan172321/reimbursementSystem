package dev.rong.services;

import java.util.List;

import dev.rong.entities.Reimbursement;

public interface ManagerServices {
	
	boolean managerLogin(String username, String password);
	
	List<Reimbursement> viewAllReimbursements();
	
	Reimbursement viewReimbursementById(int rid);
	
	Reimbursement updateReimbursementStatus(Reimbursement r);
	
//	List<Integer> reimbursementsApprovedPerManager();
//	List<Integer> reimbursementsDeniedPerManager();
//	List<Double> totalAmountApprovedPerManager();
//	
//	List<Integer> reimbursementsPerEmployee();
//	List<Double> totalAmountApprovedPerEmployee();
//	
//	int AveReimbursementAmount();
	
	
}
