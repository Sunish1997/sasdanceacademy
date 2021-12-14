package com.example.studentmanagement.Repository;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.studentmanagement.Domain.AttendanceHistory;
 
@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceHistory, Long>
{
	@Query(value="select  id,stdid , attdance ,attboolean,  attdate from attendancehistory where attdate = :attdate and stdid = :stdid ", nativeQuery=true)
	List<Object[]>  findAllByPublicationDate(@Param("attdate") Date attdate,@Param("stdid") Long stdid);
}


/*
@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceHistory, Long>
{
	@Query(value="select a.id , a.stname , a.course , b.id,b.stdid , b.attdance ,  b.attdate from student a left join attendancehistory b on a.id = b.stdid", nativeQuery=true)
	 List<AttendanceHistory> findAllByPublicationDate(Date publicationDate);
}

*/