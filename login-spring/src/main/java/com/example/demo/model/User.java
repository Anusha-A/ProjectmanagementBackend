package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="employee_id")
    private long employeeId;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="middle_name")
    private String middleName;  
    
    @Column(name="user_type")
    private String userType;
    
    @Column(name="username", unique=true)
    private String username;
    
    @Column(name="password")
    @JsonIgnore
    private String password;
    
    @Column(name="availability")
    private boolean availability;
   
    @Column(name="eul_agreement")
    private boolean eulAgreement;

	
  
   
}