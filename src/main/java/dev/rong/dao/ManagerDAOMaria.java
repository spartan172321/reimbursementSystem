package dev.rong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.rong.entities.Manager;
import dev.rong.utils.ConnectionUtil;

public class ManagerDAOMaria implements ManagerDAO{
	public Manager managerLogin(String username, String password) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT*FROM reimbursementdb.MANAGER WHERE USERNAME = ? AND PASSWORD = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Manager m = new Manager();
			m.setMid(rs.getInt("MANAGER_ID"));
			m.setUsername(username);
			m.setPassword(password);
			m.setName(rs.getString("NAME"));
				
			return m;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
