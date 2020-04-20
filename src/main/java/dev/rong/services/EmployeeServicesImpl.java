package dev.rong.services;

import java.util.List;

import dev.rong.dao.EmployeeDAO;
import dev.rong.dao.EmployeeDAOMaria;
import dev.rong.dao.ReimbursementDAO;
import dev.rong.dao.ReimbursementDAOMaria;
import dev.rong.entities.Employee;
import dev.rong.entities.Reimbursement;

public class EmployeeServicesImpl implements EmployeeServices{
	
	EmployeeDAO edao = new EmployeeDAOMaria();
	ReimbursementDAO rdao = new ReimbursementDAOMaria();
	
	@Override
	public Employee employeeLogin(String username, String password) {
		Employee e = edao.employeeLogin(username, password);
		if(e==null) {
			return null;
		}
		return e;
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
