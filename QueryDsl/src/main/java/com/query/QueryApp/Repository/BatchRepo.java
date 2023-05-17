package com.query.QueryApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.query.QueryApp.Details.Batch;
import com.query.QueryApp.Details.Student;

import jakarta.transaction.Transactional;

public interface BatchRepo extends JpaRepository<Batch, Integer> {

	@Query(nativeQuery = true,value = "select student.name,batch.elective_subject as electiveSubject from student,batch")
	List<StudentProjection> getNameAndSubject();
	
	
	
	@Query(nativeQuery = true,value="select student.name from student where student.id=:i")
	String getName(@Param("i") int i);
	
	
}
