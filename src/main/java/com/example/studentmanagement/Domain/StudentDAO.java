package com.example.studentmanagement.Domain;
 
public class StudentDAO {
private Long id;
private String stname;
 
private String attdance;

private boolean attboolean;

private String coursename;


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