package com.blogapp.meet.repositories;

import com.blogapp.meet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {



}
