package dev.rong.services;

import java.util.List;

import dev.rong.dao.ManagerDAO;
import dev.rong.dao.ManagerDAOMaria;
import dev.rong.dao.ReimbursementDAO;
import dev.rong.dao.ReimbursementDAOMaria;
import dev.rong.entities.Manager;
import dev.rong.entities.Reimbursement;

public class ManagerServicesImpl implements ManagerServices{
	
	ManagerDAO mdao = new ManagerDAOMaria();
	ReimbursementDAO rdao = new ReimbursementDAOMaria();
	
	@Override
	public Manager managerLogin(String username, String password) {
		Manager m = mdao.managerLogin(username, password);
		if(m==null) {
			return null;
		}
		return m;
	}

	@Override
	public List<Reimbursement> viewAllReimbursements() {
		return rdao.getAllReimbursements();
	}

	@Override
	public Reimbursement viewReimbursementById(int rid) {
		return rdao.getReimbursementByRid(rid);
	}
	@Override
	public List<Reimbursement> viewPendingReimbursements() {
		return rdao.getPendingReimbursements();
	}
	@Override
	public List<Reimbursement> viewNonPendingReimbursements() {
		return rdao.getNonPendingReimbursements();
	}

	@Override
	public Reimbursement updateReimbursementStatus(Reimbursement r) {
		return rdao.updateReimbursementStatus(r);
	}
	
	

//	@Override
//	public List<Integer> reimbursementsApprovedPerManager() {
//		List<Integer>
//	}
//
//	@Override
//	public List<Integer> reimbursementsDeniedPerManager() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Double> totalAmountApprovedPerManager() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Integer> reimbursementsPerEmployee() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Double> totalAmountApprovedPerEmployee() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int AveReimbursementAmount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
