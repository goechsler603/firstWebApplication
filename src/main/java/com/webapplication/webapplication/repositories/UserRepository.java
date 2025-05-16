package com.webapplication.webapplication.repositories;

import com.webapplication.webapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
