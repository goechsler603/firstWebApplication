package com.webapplication.webapplication.repositories;

import com.webapplication.webapplication.entities.Category;
import com.webapplication.webapplication.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
