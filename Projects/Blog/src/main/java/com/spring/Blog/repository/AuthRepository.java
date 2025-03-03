package com.spring.Blog.repository;

import com.spring.Blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
 
