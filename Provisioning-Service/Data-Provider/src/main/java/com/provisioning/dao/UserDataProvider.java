package com.provisioning.dao;


import com.provisioning.entity.User;
import com.provisioning.repository.UserRepository;
import com.provisioning.usercrud.UserCrudOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDataProvider implements UserCrudOperations {

    @Autowired
    private UserRepository repository;


    @Override
    public String createUser(User user) {
        repository.save(user);
        return "User Created";

    }

    @Override
    public String deleteUser(Integer id) {
        User userDetails = repository.getReferenceById(id);
        if(userDetails!=null){
            return "User details deleted successfully..";
        }else{
            return "user not found";
        }
    }

    @Override
    public User getUserbyId(Integer id) {
        User user = repository.getReferenceById(id);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public String updateUser(User user) {
        User userDetails = repository.getReferenceById(user.getUserID());
        if(userDetails!=null){
            repository.save(user);
            return "User details updated successfully..";
        }else{
            return "user not found";
        }
    }
}
