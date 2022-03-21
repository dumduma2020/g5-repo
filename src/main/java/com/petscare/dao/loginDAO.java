package com.petscare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.petscare.model.loginContainer;

public class loginDAO {
	public boolean validate(loginContainer loginContainer) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = utilityDB.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from user where username = ? and password = ?")) {
            preparedStatement.setString(1, loginContainer.getUsername());
            preparedStatement.setString(2, loginContainer.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
        	utilityDB.printSQLException(e);
        }
        return status;
    }

}
