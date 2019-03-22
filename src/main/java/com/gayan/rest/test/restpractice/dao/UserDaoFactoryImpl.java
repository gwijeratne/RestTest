package com.gayan.rest.test.restpractice.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDaoFactoryImpl implements  UserDaoFactory {

    @Override
    public UserDao getUserDao(){
        return new UserDaoMapImpl();
    }
}
