package com.petscare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.petscare.model.user;

public class userDAO {
	
	public int registerEmployee(user user) throws ClassNotFoundException {
        String insert = "INSERT INTO user" +
            "  (user_role, fname, lname, gender, age, address, email, username, password) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;
        try (Connection connection = utilityDB.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            preparedStatement.setString(1, user.getUser_role());
            preparedStatement.setString(2, user.getFname());
            preparedStatement.setString(3, user.getLname());
            preparedStatement.setString(4, user.getGender());
            preparedStatement.setInt(5, user.getAge());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getUsername());
            preparedStatement.setString(9, user.getPassword());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            utilityDB.printSQLException(e);
        }
        return result;
    }

}
