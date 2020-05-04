package dev.rong.services;

import java.util.List;

import dev.rong.dao.EmployeeDAO;
import dev.rong.dao.EmployeeDAOMaria;
import dev.rong.dao.ReimbursementDAO;
import dev.rong.dao.ReimbursementDAOMaria;
import dev.rong.entities.Reimbursement;

public class EmployeeServicesImpl implements EmployeeServices{
	
	EmployeeDAO edao = new EmployeeDAOMaria();
	ReimbursementDAO rdao = new ReimbursementDAOMaria();
	
	@Override
	public boolean employeeLogin(String username, String password) {
		if(edao.employeeLogin(username, password)==null) {
			return false;
		}
		return true;
	}

	@Override
	public Reimbursement createReimbursement(Reimbursement r) {
		return rdao.createReimbursement(r);
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement r) {
		return rdao.updateReimbursementEntry(r);
	}

	@Override
	public List<Reimbursement> viewAllEmployeeReimbursements(int eid) {
		return rdao.getReimbursementsByEid(eid);
	}



}
