package com.srijan.blog.sbblogapp.repositories;

import com.srijan.blog.sbblogapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
