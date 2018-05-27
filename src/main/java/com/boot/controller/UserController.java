package com.boot.controller;

import com.boot.entity.User;
import com.boot.entry.UserEntry;
import com.boot.manager.UserManager;
import com.boot.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<UserResponse, UserEntry, User> {

    @Autowired
    public UserController(UserManager manager) {
        super(manager);
    }

    @Override
    public UserResponse createResponse(UserEntry entry) {
        UserResponse response = new UserResponse();
        response.setEntries(Collections.singletonList(entry));
        return response;
    }
}
