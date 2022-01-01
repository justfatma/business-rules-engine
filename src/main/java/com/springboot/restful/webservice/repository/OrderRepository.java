package com.springboot.restful.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.restful.webservice.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
