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
public class AttendanceReport {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private Long stdid;
private Long courseid;
private boolean attboolean;
private Date attdate;

private String attdance;

private String attMonthString;


private String stname;
 


private String coursename;



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

private int noOFdaysPresent = 0;
private int noOFdaysAbsent = 0;
private int totalWorkingDays = 0;





public int getTotalWorkingDays() {
	return totalWorkingDays;
}

public void setTotalWorkingDays(int totalWorkingDays) {
	this.totalWorkingDays = totalWorkingDays;
}

public int getNoOFdaysPresent() {
	return noOFdaysPresent;
}

public void setNoOFdaysPresent(int noOFdaysPresent) {
	this.noOFdaysPresent = noOFdaysPresent;
}

public int getNoOFdaysAbsent() {
	return noOFdaysAbsent;
}

public void setNoOFdaysAbsent(int noOFdaysAbsent) {
	this.noOFdaysAbsent = noOFdaysAbsent;
}

public String getAttMonthString() {
	return attMonthString;
}

public void setAttMonthString(String attMonthString) {
	this.attMonthString = attMonthString;
}

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

public String getAtt1() {
	return att1;
}

public void setAtt1(String att1) {
	this.att1 = att1;
}

public String getAtt2() {
	return att2;
}

public void setAtt2(String att2) {
	this.att2 = att2;
}

public String getAtt3() {
	return att3;
}

public void setAtt3(String att3) {
	this.att3 = att3;
}

public String getAtt4() {
	return att4;
}

public void setAtt4(String att4) {
	this.att4 = att4;
}

public String getAtt5() {
	return att5;
}

public void setAtt5(String att5) {
	this.att5 = att5;
}

public String getAtt6() {
	return att6;
}

public void setAtt6(String att6) {
	this.att6 = att6;
}

public String getAtt7() {
	return att7;
}

public void setAtt7(String att7) {
	this.att7 = att7;
}

public String getAtt8() {
	return att8;
}

public void setAtt8(String att8) {
	this.att8 = att8;
}

public String getAtt9() {
	return att9;
}

public void setAtt9(String att9) {
	this.att9 = att9;
}

public String getAtt10() {
	return att10;
}

public void setAtt10(String att10) {
	this.att10 = att10;
}

public String getAtt11() {
	return att11;
}

public void setAtt11(String att11) {
	this.att11 = att11;
}

public String getAtt12() {
	return att12;
}

public void setAtt12(String att12) {
	this.att12 = att12;
}

public String getAtt13() {
	return att13;
}

public void setAtt13(String att13) {
	this.att13 = att13;
}

public String getAtt14() {
	return att14;
}

public void setAtt14(String att14) {
	this.att14 = att14;
}

public String getAtt15() {
	return att15;
}

public void setAtt15(String att15) {
	this.att15 = att15;
}

public String getAtt16() {
	return att16;
}

public void setAtt16(String att16) {
	this.att16 = att16;
}

public String getAtt17() {
	return att17;
}

public void setAtt17(String att17) {
	this.att17 = att17;
}

public String getAtt18() {
	return att18;
}

public void setAtt18(String att18) {
	this.att18 = att18;
}

public String getAtt19() {
	return att19;
}

public void setAtt19(String att19) {
	this.att19 = att19;
}

public String getAtt20() {
	return att20;
}

public void setAtt20(String att20) {
	this.att20 = att20;
}

public String getAtt21() {
	return att21;
}

public void setAtt21(String att21) {
	this.att21 = att21;
}

public String getAtt22() {
	return att22;
}

public void setAtt22(String att22) {
	this.att22 = att22;
}

public String getAtt23() {
	return att23;
}

public void setAtt23(String att23) {
	this.att23 = att23;
}

public String getAtt24() {
	return att24;
}

public void setAtt24(String att24) {
	this.att24 = att24;
}

public String getAtt25() {
	return att25;
}

public void setAtt25(String att25) {
	this.att25 = att25;
}

public String getAtt26() {
	return att26;
}

public void setAtt26(String att26) {
	this.att26 = att26;
}

public String getAtt27() {
	return att27;
}

public void setAtt27(String att27) {
	this.att27 = att27;
}

public String getAtt28() {
	return att28;
}

public void setAtt28(String att28) {
	this.att28 = att28;
}

public String getAtt29() {
	return att29;
}

public void setAtt29(String att29) {
	this.att29 = att29;
}

public String getAtt30() {
	return att30;
}

public void setAtt30(String att30) {
	this.att30 = att30;
}

public String getAtt31() {
	return att31;
}

public void setAtt31(String att31) {
	this.att31 = att31;
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