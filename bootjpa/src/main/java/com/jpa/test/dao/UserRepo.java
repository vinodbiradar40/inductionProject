package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

import jakarta.transaction.Transactional;


public interface UserRepo extends JpaRepository<User, Integer> {

	
//	@Query(nativeQuery = true,value = "select * from user where year=:key")
//	List<User> findAllByYear(@Param("key") String year);
//	

//	@Transactional
//	@Modifying
//	@Query(nativeQuery = true, value="update user set year=:year where id=:key")
//	void updateUser(@Param("key") int id,@Param("year") String year);
	
	
	

}
