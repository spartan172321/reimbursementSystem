package dev.rong.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.rong.dao.EmployeeDAO;
import dev.rong.dao.EmployeeDAOMaria;

public class EmployeeDAOTest {
	
	EmployeeDAO edao = new EmployeeDAOMaria();
	@Test
	public void test() {
		System.out.println(edao.employeeLogin("kimble", "12345"));
	}

}
