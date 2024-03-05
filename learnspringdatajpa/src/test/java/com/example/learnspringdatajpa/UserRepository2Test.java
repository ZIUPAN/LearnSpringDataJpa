package com.example.learnspringdatajpa;

import com.example.learnspringdatajpa.demos.example1.entity.User;
import com.example.learnspringdatajpa.demos.example1.repository.UserRepository2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepository2Test {
    @Autowired
    private UserRepository2 userRepository2;

    @Test
    public void testSaveUser(){
        User jack = userRepository2.findByName("jack");
        System.out.println(jack);
    }
}
