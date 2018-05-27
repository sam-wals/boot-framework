package com.boot.entry;

import java.util.Date;

public abstract class AbstractEntry {
    private Long id;
    private Date createdOn;
    private Date lastModifiedOn;
    private Date createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Date getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Date createdBy) {
        this.createdBy = createdBy;
    }
}
