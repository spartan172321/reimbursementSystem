package dev.rong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.rong.entities.Reimbursement;
import dev.rong.services.EmployeeServices;
import dev.rong.services.EmployeeServicesImpl;
import dev.rong.services.ManagerServices;
import dev.rong.services.ManagerServicesImpl;


public class ReimbursementController {
	
	EmployeeServices eserv = new EmployeeServicesImpl();
	ManagerServices mserv = new ManagerServicesImpl();
	
	
	public void getAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Reimbursement> rList = mserv.viewAllReimbursements();
		System.out.println(rList);
		Gson gson = new Gson();
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(rList);
		pw.append(json);
		
	}
	
	public void getReimbursementsByEid(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession sess = request.getSession();
		int eid = (Integer) sess.getAttribute("eid");
		List<Reimbursement> rList = eserv.viewAllEmployeeReimbursements(eid);
		System.out.println(rList);
		Gson gson = new Gson();
		PrintWriter pw = response.getWriter();
		String json = gson.toJson(rList);
		pw.append(json);

	}
	
	public void addReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession sess = request.getSession();
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement r = gson.fromJson(body, Reimbursement.class);
		r.setEid((Integer)(sess.getAttribute("eid")));
		eserv.createReimbursement(r);
		response.getWriter().append("Success!!!");
	}

	public void updateReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession sess = request.getSession();
		String body = request.getReader().lines().reduce("", (accumulator,actual) ->accumulator+actual);
		Gson gson = new Gson();
		Reimbursement r = gson.fromJson(body, Reimbursement.class);
		r.setMid((Integer)(sess.getAttribute("mid")));
		System.out.println(r);
		mserv.updateReimbursementStatus(r);
		response.getWriter().append("Successful update!!!");
	}
}
