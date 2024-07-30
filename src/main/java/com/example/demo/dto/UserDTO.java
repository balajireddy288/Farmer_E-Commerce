package com.example.demo.dto;

public class UserDTO {
    private String name;
    private String email;
    private String role;
    private String password;
    private String cpassword;
    
    public UserDTO() {}
    public UserDTO( String name, String email, String role, String password, String cpassword) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
		this.password = password;
		this.cpassword = cpassword;
	}
    
    
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    
}
