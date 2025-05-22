package com.webapplication.webapplication.service;

import com.webapplication.webapplication.entities.Category;
import com.webapplication.webapplication.entities.Order;
import com.webapplication.webapplication.repositories.CategoryRepository;
import com.webapplication.webapplication.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

}
