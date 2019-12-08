package com.example.demo.model;

public class AuthToken {

    private String token;
    private String username;
    private int employeeId;

    public AuthToken(){

    }

    public AuthToken(String token, String username,int userId){
        this.token = token;
        this.username = username;
        this.employeeId= userId;
    }

    public AuthToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employee_id) {
        this.employeeId = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
