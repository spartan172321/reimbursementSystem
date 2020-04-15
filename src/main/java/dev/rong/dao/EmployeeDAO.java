package dev.rong.dao;

import dev.rong.entities.Employee;

public interface EmployeeDAO {
	Employee employeeLogin(String username, String password);
}
