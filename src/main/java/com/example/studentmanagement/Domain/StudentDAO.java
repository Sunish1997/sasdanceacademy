package com.example.studentmanagement.Domain;

import java.sql.Date;

public class StudentDAO {
private Long id;
private String stname;
 
private String attdance;

private boolean attboolean;

private String coursename;

private Long  mobileno; 
private String email;
private Date dob;
private String  address;
private String  gender;
private String studentid  ;

private Long fee;





public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public Long getFee() {
	return fee;
}

public void setFee(Long fee) {
	this.fee = fee;
}

public Long getMobileno() {
	return mobileno;
}

public void setMobileno(Long mobileno) {
	this.mobileno = mobileno;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getStudentid() {
	return studentid;
}

public void setStudentid(String studentid) {
	this.studentid = studentid;
}

public boolean isAttboolean() {
	return attboolean;
}

public void setAttboolean(boolean attboolean) {
	this.attboolean = attboolean;
}

public String getAttdance() {
	return attdance;
}

public void setAttdance(String attdance) {
	this.attdance = attdance;
}


 
public Long getId() {
return id;
}
 
public void setId(Long id) {
this.id = id;
}
 
public String getStname() {
return stname;
}
 
public void setStname(String stname) {
this.stname = stname;
}
 
public String getCoursename() {
return coursename;
}
 
public void setCoursename(String coursename) {
this.coursename = coursename;
}
 
 
}