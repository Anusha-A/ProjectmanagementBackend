package com.example.demo.model;

public class AuthToken {

    private String token;
    private String username;
    private long employeeId;

    public AuthToken(){

    }

    public AuthToken(String token, String username,long userId){
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
    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employee_id) {
        this.employeeId = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
