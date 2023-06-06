package com.pack.appfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pack.appfiles.models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
