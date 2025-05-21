package com.webapplication.webapplication.repositories;

import com.webapplication.webapplication.entities.Order;
import com.webapplication.webapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
