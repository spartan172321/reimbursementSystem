package dev.rong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.rong.entities.Employee;
import dev.rong.entities.Reimbursement;
import dev.rong.utils.ConnectionUtil;

public class EmployeeDAOMaria implements EmployeeDAO{

	@Override
	public Employee employeeLogin(String username, String password) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT*FROM reimbursementdb.EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Employee e = new Employee();
			e.setEid(rs.getInt("EMPLOYEE_ID"));
			e.setUsername(username);
			e.setPassword(password);
			e.setName(rs.getString("NAME"));
				
			return e;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
