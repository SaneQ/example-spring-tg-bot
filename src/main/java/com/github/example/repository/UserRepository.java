package com.github.example.repository;

import com.github.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.notified = false AND u.phone IS NOT NULL and u.email IS NOT NULL")
    List<User> findNewUsers();

    User findByChatId(long id);
}