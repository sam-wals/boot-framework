package com.boot.mapper;

import com.boot.entity.AbstractEntity;
import com.boot.entry.AbstractEntry;

public interface EntryEntityMapper<E extends AbstractEntry, B extends AbstractEntity> {

    E convertToEntry(B entity);

    B convertToEntity(E entry);
}
