package com.example.studentmanagement.Domain;
 
import java.sql.Date;
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