package com.transaction.manager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.transaction.manager.UserDetails.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	@Modifying
	@Query(nativeQuery=true,value="update User set name = :userName where id = :userId")
	void updateUserName(@Param("userId")int userId,@Param("userName")String userName);

}
