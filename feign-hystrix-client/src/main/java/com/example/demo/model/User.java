package com.example.demo.model;





public class User {

    private int employeeId;
    
    private String firstName;
   
    private String lastName;

    private String middleName;

    private String userType;
   
    private String username;
    
    private String password;
   
    private boolean availability;
   
    private boolean eulAgreement;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

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

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public boolean isEulAgreement() {
		return eulAgreement;
	}

	public void setEulAgreement(boolean eulAgreement) {
		this.eulAgreement = eulAgreement;
	}
    
    
 
}