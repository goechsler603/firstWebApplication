package com.webapplication.webapplication.repositories;

import com.webapplication.webapplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Override
    Optional<User> findById(Long aLong);
}
