package com.petscare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.petscare.model.loginContainer;
import com.petscare.dao.loginDAO;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private loginDAO loginDAO;
       
	public void init() {
		loginDAO = new loginDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		authenticate(request, response);
	}
	
	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        loginContainer loginContainer = new loginContainer();
        loginContainer.setUsername(username);
        loginContainer.setPassword(password);

        try {
            if (loginDAO.validate(loginContainer)) {
            	System.out.print("if statement");
            	 //response.sendRedirect("index.jsp");
					/* RequestDispatcher dispatcher = request.getRequestDispatcher("/list"); */
            	request.setAttribute("NOTIFICATION", "User LOGGED IN Successfully!");
				/*
				 * RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				 * dispatcher.forward(request, response);
				 */
            	
            	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
                
            } else {
            	System.out.print("successfuly log in");
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
        	System.out.print("failed to login");
            e.printStackTrace();
            response.sendRedirect("login.jsp");
        }

    }

}
