package com.query.QueryApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.QueryApp.Details.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
