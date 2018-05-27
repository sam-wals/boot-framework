package com.boot.repository;

import com.boot.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User, Long> {
}
