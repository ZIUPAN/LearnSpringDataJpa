package com.example.learnspringdatajpa.demos.example1.controller;

import com.example.learnspringdatajpa.demos.example1.entity.User;
import com.example.learnspringdatajpa.demos.example1.repository.UserRepository1;
import com.example.learnspringdatajpa.demos.example1.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
    @Autowired
    private UserRepository1 userRepository1;

    @Autowired
    private UserRepository2 userRepository2;

    /**
     * 保存用户
     */
    @PostMapping(path = "/user",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User addNewUser(@RequestBody User user) {
        return userRepository1.save(user);
    }

    /**
     * 验证排序和分页查询
     */
    @GetMapping(path = "/page")
    // @ResponseBody: 表示这个方法的返回值将直接作为HTTP响应体返回
    @ResponseBody
    public Page<User> getAllUserByPage(){
        return userRepository1.findAll(
                // 第一个参数1是页码，注意Spring Data JPA中页码是从0开始的，所以这里实际上是请求第二页。
                //第二个参数20是每页的大小，即每页显示20条记录。
                // Sort.by(new Sort.Order(Sort.Direction.ASC, "name"))定义了排序方式，这里是按照name字段升序排列。
                PageRequest.of(1,20, Sort.by(new Sort.Order(Sort.Direction.ASC,"name")))
        );
    }

    /**
     * 根据名称查询用户列表
     */
    @GetMapping(path = "/user/findByName")
    public User findByName(@RequestParam String name){
        return userRepository2.findByName(name);
    }

    /**
     * Sort 排序和 Pageable 分页
     */
    @GetMapping(path = "/user/findAll")
    public void findAll(@RequestParam String name){
        // 这种方法默认会执行一个额外的count查询来确定总的元素数量，这可以帮助前端构建分页导航。由于需要额外的count查询，这种方法在性能上可能会比较昂贵，特别是当处理大型数据集时。
        Page<User> res1 = userRepository1.findByName(name,PageRequest.of(0,10));

        // 查第一页，每页10条，但是返回的是List
        List<User> userList = userRepository1.findByEmail("zxxx@163.com", PageRequest.of(0, 10));

    }
}
