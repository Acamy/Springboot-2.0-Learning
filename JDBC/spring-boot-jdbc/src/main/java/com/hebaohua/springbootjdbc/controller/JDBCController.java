package com.hebaohua.springbootjdbc.controller;

import com.hebaohua.springbootjdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    private DataSource ds;

    @GetMapping("/jdbc")
    public Map<String, Object> getUsers(@RequestParam(value = "id", defaultValue = "1") String id){
        Map<String, Object> data = new HashMap<String, Object>();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT id,name,age FROM user WHERE id=?");
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                data.put("id", rs.getInt("id"));
                data.put("name", rs.getString("name"));
                data.put("age", rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/addUser")
    public Map<String, Object> addUser(@RequestBody User user){
        Map<String, Object> data = new HashMap<String, Object>();
        Boolean result = jdbcTemplate.execute("INSERT INTO user(name,age) VALUES (?, ?)",new PreparedStatementCallback<Boolean>(){

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, user.getName());
                ps.setInt(2, user.getAge());
                return ps.executeUpdate() > 0;
            }
        });
        data.put("success", result);
        return data;
    }

}
