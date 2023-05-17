package com.example.DemoProject.Repository;

import com.example.DemoProject.Projection.CustomerProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoProject.Entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query(nativeQuery = true,value = "select first_name,last_name from customer where customer_id=:key")
    String getName(@Param("key") int id);

    @Query(value = "select c.first_name, o.order_id, o.order_date, o.order_status from customer c inner join orders o on o.customer_id = c.customer_id " +
            "where c.customer_id = :customerId", nativeQuery = true)
    List<Object[]> findCustomerAndOrdersByCustomerId(@Param("customerId") int customerId);
 Customer findByPhoneNo(int phoneNo);
    Customer findByPghhoneNo(int phoneNo);

    @Modifying
    @Transactional
    @Query(value="update customer set phone_no = :phone where customer_id = :id",nativeQuery = true)
    void updatePhoneNumber(@Param("id") int id, @Param("phone") String phone);


}
