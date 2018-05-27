package com.boot.controller;

import com.boot.entity.AbstractEntity;
import com.boot.entry.AbstractEntry;
import com.boot.exception.ManagerException;
import com.boot.manager.AbstractManager;
import com.boot.response.AbstractResponse;
import com.boot.response.StatusResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AbstractController<R extends AbstractResponse, E extends AbstractEntry, B extends AbstractEntity> {

    private AbstractManager<E, B> manager;

    public AbstractController(AbstractManager<E, B> manager) {
        this.manager = manager;
    }

    @RequestMapping("/{id}")
    public R findById(@PathVariable("id") Long id) {
        E entry = manager.findById(id);
        return createResponse(entry);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public R update(@PathVariable("id") Long id, @RequestBody E entry) {
        E updatedEntry = null;
        try {
            updatedEntry = manager.update(entry, id);
        } catch (ManagerException e) {
            R response = createResponse(null);
            response.setStatusResponse(new StatusResponse(e.getMessage()));
        }
        return createResponse(updatedEntry);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public R create(@RequestBody E entry){
        E createdEntry = manager.create(entry);
        return createResponse(createdEntry);
    }

    public abstract R createResponse(E entry);
}
