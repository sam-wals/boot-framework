package com.boot.manager;

import com.boot.entity.User;
import com.boot.entry.UserEntry;
import com.boot.mapper.UserMapper;
import com.boot.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager extends AbstractManager<UserEntry, User> {

    @Autowired
    public UserManager(UserRepository repository) {
        super(repository, Mappers.getMapper(UserMapper.class));
    }
}
