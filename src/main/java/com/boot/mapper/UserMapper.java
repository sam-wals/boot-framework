package com.boot.mapper;

import com.boot.entity.User;
import com.boot.entry.UserEntry;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends EntryEntityMapper<UserEntry, User> {
}
