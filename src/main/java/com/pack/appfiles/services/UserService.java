package com.pack.appfiles.services;

import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pack.appfiles.models.User;
import com.pack.appfiles.repositories.UserRepo;


@Service
public class UserService {
   @Autowired
   private UserRepo userRepository;
   
   @Autowired
    @Qualifier("createUser")
    ObjectProvider<User> createUser;

    public void saveUser(User u){
        userRepository.save(u);
    }

    public void updateUser(User u){
            userRepository.save(u);
    }

    public void deleteUser(User u){
        userRepository.delete(u);
    }

    public Optional<User> findUserById(long id){
        return userRepository.findById(id);
    }

    public User createUser(String u,String f,String e) {
            User user =  new User(u, f, e);
            userRepository.save(user);
            return user;
    }
}
