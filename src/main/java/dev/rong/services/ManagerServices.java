package dev.rong.services;

import java.util.List;

import dev.rong.entities.Manager;
import dev.rong.entities.Reimbursement;

public interface ManagerServices {
	
	Manager managerLogin(String username, String password);
	
	List<Reimbursement> viewAllReimbursements();
	
	Reimbursement viewReimbursementById(int rid);
	
	List<Reimbursement> viewPendingReimbursements();
	
	List<Reimbursement> viewNonPendingReimbursements();
	
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
