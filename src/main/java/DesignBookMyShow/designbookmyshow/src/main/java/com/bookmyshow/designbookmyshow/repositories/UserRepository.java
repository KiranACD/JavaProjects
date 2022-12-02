package com.bookmyshow.designbookmyshow.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmyshow.designbookmyshow.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Override
    Optional<User> findById(Long id);
}
