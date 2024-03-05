package com.example.learnspringdatajpa.demos.example1.repository;


import com.example.learnspringdatajpa.demos.example1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * dao层
 * 继承JpaRepository
 * 用来对实体类进行增删改查
 */
public interface UserRepository1 extends PagingAndSortingRepository<User, Long> {
    // 根据名称查询用户列表
    Page<User> findByName(String name, Pageable pageable);

    // 根据邮箱查询用户列表
    List<User> findByEmail(String email,Pageable pageable);

    // 根据用户的邮箱和名称查询
    List<User> findByEmailAndName(String email,String name);
}
