package com.example.demo.model;

public class UserDto {

    private long employeeId;
    private String firstName;
    private String userType;
    private String lastName;
    private String middleName;
    private String username;
    private String password;

    private Boolean availability;
    private Boolean eulAgreement;


    public long getemployeeId() {
        return employeeId;
    }

    public void setemployeeId(long id) {
        this.employeeId = id;
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

    public void setMiddleName(String midlleName) {
        this.middleName = middleName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String type) {
        this.userType = type;
    }
 
    
   
    public Boolean isAvailability() {
        return availability;
    }
    public void setAvailability(Boolean availability) {
        this.availability =availability;
    }
    public Boolean isEulAgreement() {
        return eulAgreement;
    }
    public void setEulAgreement(Boolean eulAgreement) {
        this.eulAgreement =eulAgreement;
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

 
}