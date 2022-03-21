package com.petscare.model;

import java.io.Serializable;

public class loginContainer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String user_role;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

}
