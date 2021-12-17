package com.example.studentmanagement.Domain;
 
import java.sql.Date;
import java.util.List;
 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity
@Table(name="student")
public class Student {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String stname;
private int fee;
private int course;
private String attdance;

private boolean attboolean;

private int  mobileno; 
private String email;
private Date dob;
private String  address;
private String  gender;
private String studentid  ;



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
 
public int getFee() {
return fee;
}
 
public void setFee(int fee) {
this.fee = fee;
}

public int getCourse() {
	return course;
}

public void setCourse(int course) {
	this.course = course;
}

public int getMobileno() {
	return mobileno;
}

public void setMobileno(int mobileno) {
	this.mobileno = mobileno;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
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
 



 
}