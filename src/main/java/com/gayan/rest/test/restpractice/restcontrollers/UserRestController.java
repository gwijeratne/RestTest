package com.gayan.rest.test.restpractice.restcontrollers;

import com.gayan.rest.test.restpractice.dao.UserDao;
import com.gayan.rest.test.restpractice.dao.UserDaoFactory;
import com.gayan.rest.test.restpractice.dao.UserDaoFactoryImpl;
import com.gayan.rest.test.restpractice.exceptions.UserNotFoundException;
import com.gayan.rest.test.restpractice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserRestController {

    @Autowired
    private final UserDaoFactory userDaoFactory;

    @Autowired
    private final UserDao userDao;

    public UserRestController(UserDaoFactory userDaoFactory,
                              UserDao userDao) {
        this.userDaoFactory = new UserDaoFactoryImpl();
        this.userDao = userDaoFactory.getUserDao();
    }

    @GetMapping(path="/{id}")
    public User getUser(@PathVariable long id) throws UserNotFoundException {
        User user = userDao.getUser(id);

        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User id: " + id);
        }

        return user;
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    @PostMapping()
    public ResponseEntity createUser(@RequestBody User user){
        User createdUser  = userDao.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable long id){
        userDao.deleteUser(id);
    }

    @PutMapping(path="/{id}")
    public User updateUser(@PathVariable long id,@RequestBody User user){
        user.setId(id);
        return userDao.updateUser(user);
    }

}
