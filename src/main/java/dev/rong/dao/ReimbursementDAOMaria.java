package dev.rong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dev.rong.entities.Reimbursement;
import dev.rong.utils.ConnectionUtil;

public class ReimbursementDAOMaria implements ReimbursementDAO{

	public Reimbursement createReimbursement(Reimbursement r) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "INSERT INTO reimbursementdb.REIMBURSEMENT(AMOUNT,DESCRIPTION,STATUS,MANAGER_ID,EMPLOYEE_ID) VALUES (?, ?, ? , null, ?)";
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setString(3, r.getStatus());
			ps.setInt(4, r.getEid());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int key = rs.getInt("REIMBURSEMENT_ID");
			
			r.setRid(key);
			
			return r;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Reimbursement> getReimbursementsByEid(int eid) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT*FROM reimbursementdb.REIMBURSEMENT WHERE EMPLOYEE_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setRid(rs.getInt("REIMBURSEMENT_ID"));
				r.setAmount(rs.getDouble("AMOUNT"));
				r.setDescription(rs.getString("DESCRIPTION"));
				r.setStatus(rs.getString("STATUS"));
				r.setMid(rs.getInt("MANAGER_ID"));
				r.setEid(rs.getInt("EMPLOYEE_ID"));
				allReimbursements.add(r);
			}
			
			return allReimbursements;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Reimbursement> getReimbursementsByMid(int mid) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT*FROM reimbursementdb.REIMBURSEMENT WHERE MANAGER_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setRid(rs.getInt("REIMBURSEMENT_ID"));
				r.setAmount(rs.getDouble("AMOUNT"));
				r.setDescription(rs.getString("DESCRIPTION"));
				r.setStatus(rs.getString("STATUS"));
				r.setMid(rs.getInt("MANAGER_ID"));
				r.setEid(rs.getInt("EMPLOYEE_ID"));
				allReimbursements.add(r);
			}
			
			return allReimbursements;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Reimbursement> getAllReimbursements() {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "SELECT*FROM reimbursementdb.REIMBURSEMENT";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			List<Reimbursement> allReimbursements = new ArrayList<Reimbursement>();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setRid(rs.getInt("REIMBURSEMENT_ID"));
				r.setAmount(rs.getDouble("AMOUNT"));
				r.setDescription(rs.getString("DESCRIPTION"));
				r.setStatus(rs.getString("STATUS"));
				r.setMid(rs.getInt("MANAGER_ID"));
				r.setEid(rs.getInt("EMPLOYEE_ID"));
				allReimbursements.add(r);
			}
			
			return allReimbursements;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Reimbursement updateReimbursementEntry(Reimbursement r) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE reimbursementdb.REIMBURSEMENT SET AMOUNT=?, DESCRIPTION=? WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, r.getAmount());
			ps.setString(2, r.getDescription());
			ps.setInt(3, r.getRid());
			
			boolean success = ps.execute();
			
			return r;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Reimbursement updateReimbursementStatus(Reimbursement r) {
		try(Connection conn = ConnectionUtil.createConnection()){
			String sql = "UPDATE reimbursementdb.REIMBURSEMENT SET STATUS=? WHERE REIMBURSEMENT_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getStatus());
			ps.setInt(2, r.getRid());
			
			boolean success = ps.execute();
			
			return r;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
