package com.example.learnspringdatajpa.demos.example1.repository;

import com.example.learnspringdatajpa.demos.example1.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository2 extends CrudRepository<User,Long> {
    User findByName(String name);
}
