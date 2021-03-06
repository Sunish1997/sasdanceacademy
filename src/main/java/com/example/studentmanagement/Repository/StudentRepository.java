package com.example.studentmanagement.Repository;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.studentmanagement.Domain.Student;
 
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	@Query(value="select a.id , a.stname , b.coursename , c.attdance , c.attboolean , c.attdate from student a inner join course b on a.course = b.id left join attendancehistory c on a.id = c.stdid and c.attdate = :attdate ", nativeQuery=true)
	List<Object[]> findStudentAttList(@Param("attdate") Date attdate);

@Query(value="select s.id, s.stname, c.coursename , s.attdance ,s.attboolean from student s Inner JOIN course c ON s.course=c.id", nativeQuery=true)
List<Object[]> findStudent();

@Query(value="select s.id, s.stname, c.coursename , s.attdance ,s.attboolean, s.fee, s. mobileno, s.email, s.dob, s.address, s.gender, s.studentid from student s Inner JOIN course c ON s.course=c.id where s.id = :id ", nativeQuery=true)
List<Object[]> findStudentProfile(@Param("id") int id);

@Query(value="select s.id, s.stname, c.coursename , s.attdance ,s.attboolean, s.fee, s. mobileno, s.email, s.dob, s.address, s.gender, s.studentid from student s Inner JOIN course c ON s.course=c.id where s.studentid = :studentid ", nativeQuery=true)
List<Object[]> findStudentProfileByStdid(@Param("studentid") String studentid);
}




/*
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
@Query(value="select s.id, s.stname, c.coursename , s.attdance ,s.attboolean from student s Inner JOIN course c ON s.course=c.id", nativeQuery=true)
List<Object[]> findStudent();
}

*/