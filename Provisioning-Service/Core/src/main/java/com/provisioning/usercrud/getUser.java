package com.provisioning.usercrud;

import com.provisioning.entity.User;

import java.util.List;

public interface getUser {

    public User getUserbyId(Integer id);

    public List<User> getAllUsers();
}
