package com.example.learnspringdatajpa;

import com.example.learnspringdatajpa.demos.example1.entity.User;
import com.example.learnspringdatajpa.demos.example1.repository.UserRepository1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class UserRepository1Test {
    @Autowired
    private UserRepository1 userRepository1;

    @Test
    public void testSaveUser(){

        Iterable<User> all = userRepository1.findAll();
        all.forEach(System.out::println);
    }
}
