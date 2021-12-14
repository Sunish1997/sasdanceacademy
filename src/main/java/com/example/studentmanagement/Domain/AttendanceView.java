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
 

public class AttendanceView {
 

	private Long id;
	private String stname;
	 
	private String attdance;

	private boolean attboolean;

	private String coursename;

	private Date attdate;

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

	public String getAttdance() {
		return attdance;
	}

	public void setAttdance(String attdance) {
		this.attdance = attdance;
	}

	public boolean isAttboolean() {
		return attboolean;
	}

	public void setAttboolean(boolean attboolean) {
		this.attboolean = attboolean;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Date getAttdate() {
		return attdate;
	}

	public void setAttdate(Date attdate) {
		this.attdate = attdate;
	}


	
	
 
}