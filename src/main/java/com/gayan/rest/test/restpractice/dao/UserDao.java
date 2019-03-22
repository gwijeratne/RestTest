package com.gayan.rest.test.restpractice.dao;

import com.gayan.rest.test.restpractice.model.User;
import org.springframework.stereotype.Component;

import java.util.List;


public interface UserDao {

    public User getUser(long id);

    public List<User> getAllUsers();

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(long id);
}
