package dev.rong.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			System.out.println("here");
			Manager m = mserv.managerLogin(user, pass);
			System.out.println(m);
			if(m!=null) {
				int mid = m.getMid();
				sess.setAttribute("mid", mid);
				response.sendRedirect("http://localhost:8075/ReimbursementProject/manager.html");
				System.out.println(sess.getAttribute("mid")+" "+sess.getAttribute("eid"));
			}
			
		}else if(uri.equals("/ReimbursementProject/login/employee")) {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			Employee e = eserv.employeeLogin(user, pass);
			if(e!=null) {
				int eid = e.getEid();
				sess.setAttribute("eid", eid);
				response.sendRedirect("http://localhost:8075/ReimbursementProject/employee.html");
			}
			System.out.println(sess.getAttribute("mid")+" "+sess.getAttribute("eid"));
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
