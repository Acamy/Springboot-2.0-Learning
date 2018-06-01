package com.hebaohua.springbootjpa.repository;

import com.hebaohua.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
