package dev.rong.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.rong.controller.ReimbursementController;
import dev.rong.dao.ReimbursementDAO;
import dev.rong.dao.ReimbursementDAOMaria;
import dev.rong.entities.Reimbursement;
import dev.rong.services.ManagerServices;
import dev.rong.services.ManagerServicesImpl;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    ReimbursementController rcontrol = new ReimbursementController();
    
    public HomeServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		switch(uri) {
		case "/ReimbursementProject/home/viewReimbursements":
			rcontrol.getAllReimbursements(request, response);
			break;
		case "/ReimbursementProject/home/viewReimbursementByEid":
			rcontrol.getReimbursementsByEid(request, response);
			break;
		case "/ReimbursementProject/home/viewPendingReimbursements":
			rcontrol.getPendingReimbursements(request, response);
			break;
		case "/ReimbursementProject/home/viewNonPendingReimbursements":
			rcontrol.getNonPendingReimbursements(request, response);
			break;
		case "/ReimbursementProject/home/addReimbursement":
			System.out.println("it works here");
			rcontrol.addReimbursement(request,response);
			break;
		case "/ReimbursementProject/home/updateReimbursement":
			rcontrol.updateReimbursements(request, response);
			break;
		default:
			response.getWriter().append("your request uri did not match anything");
			break;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
