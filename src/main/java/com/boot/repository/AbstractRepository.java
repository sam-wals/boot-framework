package com.boot.repository;

import org.springframework.data.repository.CrudRepository;

public interface AbstractRepository<T, ID> extends CrudRepository<T, ID> {
}
