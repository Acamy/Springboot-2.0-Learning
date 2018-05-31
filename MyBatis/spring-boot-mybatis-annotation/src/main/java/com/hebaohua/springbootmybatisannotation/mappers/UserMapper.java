package com.hebaohua.springbootmybatisannotation.mappers;

import com.hebaohua.springbootmybatisannotation.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Results(value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT id,name,age FROM user WHERE id = #{id}")
    User selectUser(int id);
}
