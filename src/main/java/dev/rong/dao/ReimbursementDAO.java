package dev.rong.dao;

import java.util.List;

import dev.rong.entities.Reimbursement;

public interface ReimbursementDAO {
	
	Reimbursement createReimbursement(Reimbursement r);
	
	Reimbursement getReimbursementByRid(int rid);
	
	List<Reimbursement> getReimbursementsByEid(int eid);
	
	List<Reimbursement> getReimbursementsByMid(int mid);
	
	List<Reimbursement> getAllReimbursements();
	
	List<Reimbursement> getPendingReimbursements();
	
	List<Reimbursement> getNonPendingReimbursements();
	
	Reimbursement updateReimbursementEntry(Reimbursement r);
	
	Reimbursement updateReimbursementStatus(Reimbursement r);

}
