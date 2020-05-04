package dev.rong.servicetests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dev.rong.entities.Reimbursement;
import dev.rong.services.ManagerServices;
import dev.rong.services.ManagerServicesImpl;

public class ManagerServicesTest {
	ManagerServices mserv = new ManagerServicesImpl();
	@Test
	public void test() {
		List<Reimbursement> reimbursements = mserv.viewAllReimbursements();
		for(Reimbursement r : reimbursements) {
			System.out.println(r.getMid());
		}
		
		
	}

}
