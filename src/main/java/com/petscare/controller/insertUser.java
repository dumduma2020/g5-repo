package com.petscare.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.petscare.dao.userDAO;
import com.petscare.model.user;


@WebServlet("/insertUser")
public class insertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	userDAO userDAO = new userDAO();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		register(request, response);
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		
		
		System.out.print("start saving");
        String user_role = request.getParameter("user_role");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        int intAge = Integer.parseInt(age);

        user user = new user();
        user.setUser_role(user_role);
        user.setFname(fname);
        user.setLname(lname);
        user.setGender(gender);
        user.setAge(intAge);
        user.setAddress(address);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

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
