package com.gayan.rest.test.restpractice.dao;

import com.gayan.rest.test.restpractice.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoMapImpl implements  UserDao{

    private static Map<Long, User>  userMap = new HashMap<>();

    public UserDaoMapImpl() {

        if (userMap.isEmpty()){
            User user1 = new User();
            user1.setId(1L);
            user1.setName("Randy Jackson");
            user1.setDate(new Date());
            userMap.put(user1.getId(),user1 );

            User user2 = new User();
            user2.setId(2L);
            user2.setName("John Newman");
            user2.setDate(new Date());
            userMap.put(user2.getId(),user2 );

            User user3 = new User();
            user3.setId(3L);
            user3.setName("Richard Swanson");
            user3.setDate(new Date());
            userMap.put(user3.getId(),user3 );
        }
    }


    public User getUser(long id) {
        return userMap.get(id);
    }


    public List<User> getAllUsers() {
        return new ArrayList(userMap.values());
    }


    public User addUser(User user) {
        long id = userMap.size()+1;
        user.setId(id);
        userMap.put(id, user);
        return user;
    }


    public User updateUser(User user) {

        if (userMap.containsKey(user.getId())){
            userMap.put(user.getId(), user);
            return user;
        }
        return null;
    }


    public void deleteUser(long id) {
        userMap.remove(id);
    }
}
