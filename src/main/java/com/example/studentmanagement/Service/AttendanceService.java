package com.example.studentmanagement.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.Domain.AttendanceHistory;
import com.example.studentmanagement.Repository.AttendanceRepository;

@Service
public class AttendanceService {


 
@Autowired
private AttendanceRepository repoAttendance;


public List<AttendanceHistory> listAll()
{
System.out.println(repoAttendance.findAll());
        return repoAttendance.findAll();
    }
    

    
 
    public void saveAttendance(AttendanceHistory att) {
    	repoAttendance.save(att);
    }
    
    public AttendanceHistory get(long id) {
        return repoAttendance.findById(id).get();
    }
    
    public void delete(long id) {
    	repoAttendance.deleteById(id);
    }
 
    public List<Object[]>  attList(Date attdate,Long stdid)
    {
   // System.out.println(repoAttendance.findAllByPublicationDate(attdate,stdid));
            return repoAttendance.findAllByPublicationDate(attdate,stdid);
        }
    
    
}