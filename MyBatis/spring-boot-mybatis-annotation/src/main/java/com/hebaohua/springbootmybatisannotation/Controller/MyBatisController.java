package com.hebaohua.springbootmybatisannotation.Controller;

import com.hebaohua.springbootmybatisannotation.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyBatisController {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        User user = sqlSessionTemplate.selectOne("com.hebaohua.springbootmybatisannotation.mappers.UserMapper.selectUser",id);
        return user;
    }
}
