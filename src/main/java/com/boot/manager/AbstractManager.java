package com.boot.manager;

import com.boot.entity.AbstractEntity;
import com.boot.entry.AbstractEntry;
import com.boot.exception.ManagerException;
import com.boot.mapper.EntryEntityMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class AbstractManager<E extends AbstractEntry, B extends AbstractEntity> {

    private CrudRepository<B, Long> repository;

    private EntryEntityMapper<E, B> mapper;

    public AbstractManager(CrudRepository<B, Long> repository, EntryEntityMapper<E, B> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public E findById(Long id) {
        Optional<B> entity = repository.findById(id);
        if (!entity.isPresent()) {
            return null;
        }
        return convertToEntry(entity.get());
    }

    @Transactional(rollbackFor = Exception.class)
    public E create(E entry) {
        B entity = convertToEntity(entry, null);
        entity = repository.save(entity);
        return convertToEntry(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public E update(E entry, Long id) throws ManagerException {
        Optional<B> currentEntity = repository.findById(id);
        if (!currentEntity.isPresent()){
            throw new ManagerException();
        }
        B entity = convertToEntity(entry, currentEntity.get());
        entity = repository.save(entity);
        return convertToEntry(entity);
    }

    protected E convertToEntry(B entity) {
        return mapper.convertToEntry(entity);
    }

    protected B convertToEntity(E entry, B entity) {
        B newEntity = mapper.convertToEntity(entry);
        newEntity.setId(entity.getId());
        newEntity.setVersion(entity.getVersion());
        return newEntity;
    }
}
