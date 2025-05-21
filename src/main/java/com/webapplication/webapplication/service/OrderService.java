package com.webapplication.webapplication.service;

import com.webapplication.webapplication.entities.Order;
import com.webapplication.webapplication.entities.User;
import com.webapplication.webapplication.repositories.OrderRepository;
import com.webapplication.webapplication.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }


    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

}
