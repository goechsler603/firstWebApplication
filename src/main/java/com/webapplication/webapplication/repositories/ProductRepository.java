package com.webapplication.webapplication.repositories;

import com.webapplication.webapplication.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
