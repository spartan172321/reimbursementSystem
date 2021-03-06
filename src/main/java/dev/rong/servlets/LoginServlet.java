package dev.rong.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.rong.entities.Employee;
import dev.rong.entities.Manager;
import dev.rong.services.EmployeeServices;
import dev.rong.services.EmployeeServicesImpl;
import dev.rong.services.ManagerServices;
import dev.rong.services.ManagerServicesImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeServices eserv = new EmployeeServicesImpl();
    ManagerServices mserv = new ManagerServicesImpl();
	
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		HttpSession sess = request.getSession();
		
		if(uri.equals("/ReimbursementProject/login/manager")) {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			Manager m = mserv.managerLogin(user, pass);
			
			if(m!=null) {
				int mid = m.getMid();
				sess.setAttribute("mid", mid);
				response.getWriter().append("true");
			}
			
		}else if(uri.equals("/ReimbursementProject/login/employee")) {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			Employee e = eserv.employeeLogin(user, pass);
			if(e!=null) {
				int eid = e.getEid();
				sess.setAttribute("eid", eid);
				response.getWriter().append("true");
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
