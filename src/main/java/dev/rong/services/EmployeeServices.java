package dev.rong.services;

import java.util.List;

import dev.rong.entities.Employee;
import dev.rong.entities.Reimbursement;

public interface EmployeeServices {
	
	Employee employeeLogin(String username, String password);
	Reimbursement createReimbursement(Reimbursement r);
	Reimbursement updateReimbursement(Reimbursement r);
	List<Reimbursement> viewAllEmployeeReimbursements(int eid);
}
