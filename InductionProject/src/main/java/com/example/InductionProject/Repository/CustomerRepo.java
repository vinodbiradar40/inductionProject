package com.example.InductionProject.Repository;


import com.example.InductionProject.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true,value = "select first_name,last_name from customer where customer_id=:key")
    String getName(@Param("key") int id);

    @Query(nativeQuery = true,value = "select first_name,phone_no from customer where city=:value")
    String findByCity(@Param("value") String city);

    @Query(name = "findCustomerDetails")
    Customer findByPhoneNo(@Param("Key") String phoneNo);

    @Modifying
    @Transactional
    @Query(value="update customer set phone_no = :phone where customer_id = :id",nativeQuery = true)
    void updatePhoneNumber(@Param("id") int id, @Param("phone") String phone);


}
