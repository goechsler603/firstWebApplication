package com.webapplication.webapplication.repositories;

import com.webapplication.webapplication.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

}
