package com.petscare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petscare.dao.userDAO;
import com.petscare.model.user;


public class userRegistration extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	userDAO userDAO = new userDAO();
	
	protected void register(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
        String user_role = request.getParameter("user_role");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //password hashing
        
        
        int intAge = Integer.parseInt(age);
        

        user user = new user();
        user.setUser_role(user_role);
        user.setFname(fname);
        user.setLname(lname);
        user.setGender(gender);
        user.setAge(intAge);
        user.setFname(address);
        user.setFname(email);
        user.setFname(username);
        user.setFname(password);

        try {
            int result = userDAO.registerEmployee(user);
            if (result == 1) {
            	System.out.print("succesfuly register");
                request.setAttribute("NOTIFICATION", "User Registered Successfully!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("failed register");
        }

     //   RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/register.jsp");
      //  dispatcher.forward(request, response);
    }

}
