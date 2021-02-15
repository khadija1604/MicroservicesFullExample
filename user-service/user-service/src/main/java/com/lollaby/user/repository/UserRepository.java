package com.lollaby.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lollaby.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
