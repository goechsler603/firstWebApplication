package com.webapplication.webapplication.service;

import com.webapplication.webapplication.entities.User;
import com.webapplication.webapplication.repositories.UserRepository;
import com.webapplication.webapplication.service.exceptions.DatabaseException;
import com.webapplication.webapplication.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private final UserRepository repository;
    private final UserRepository userRepository;

    public UserService(UserRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
       repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
       try {
           repository.deleteById(id);
       }catch (DataIntegrityViolationException e){
           throw new DatabaseException(e.getMessage());
       }
    }

    public User update(Long id, User obj) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            User entity = repository.findById(id).get();
            updateData(entity, obj);
            return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
