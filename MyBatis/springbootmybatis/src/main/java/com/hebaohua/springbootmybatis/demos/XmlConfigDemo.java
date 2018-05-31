package com.hebaohua.springbootmybatis.demos;

import com.hebaohua.springbootmybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

public class XmlConfigDemo {
    public static void main(String[] args) throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/mybatis/mybatis-config.xml");
        InputStream inputStream = resource.getInputStream();
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = session.selectOne("com.hebaohua.springbootmybatis.mappers.UserMapper.selectUser", 4);
            System.out.println(user);
        } finally {
            session.close();
        }
    }
}
