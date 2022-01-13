package com.example.studentmanagement.Domain;
 
import java.sql.Date;
import java.time.YearMonth;
import java.util.ArrayList;
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
@Table(name="attendancehistory")
public class AttendanceHistory {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long stdid;
private Long courseid;
private boolean attboolean;
private Date attdate;

private String attdance;


// private String attMonthString;

/*
private String att1;
private String att2;
private String att3;
private String att4;
private String att5;
private String att6;

private String att7;
private String att8;
private String att9;
private String att10;
private String att11;
private String att12;
private String att13;
private String att14;
private String att15;
private String att16;
private String att17;
private String att18;
private String att19;
private String att20;
private String att21;
private String att22;
private String att23;

private String att24;
private String att25;
private String att26;
private String att27;
private String att28;
private String att29;
private String att30;
private String att31;


*/



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getStdid() {
	return stdid;
}

public void setStdid(Long stdid) {
	this.stdid = stdid;
}

public Long getCourseid() {
	return courseid;
}

public void setCourseid(Long courseid) {
	this.courseid = courseid;
}

public boolean isAttboolean() {
	return attboolean;
}

public void setAttboolean(boolean attboolean) {
	this.attboolean = attboolean;
}

public Date getAttdate() {
	return attdate;
}

public void setAttdate(Date attdate) {
	this.attdate = attdate;
}

public String getAttdance() {
	return attdance;
}

public void setAttdance(String attdance) {
	this.attdance = attdance;
}

 


 


 
}