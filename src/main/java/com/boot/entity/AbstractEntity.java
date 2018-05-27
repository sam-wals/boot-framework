package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_by", updatable = false)
    private String createdBy;
    @Column(name = "created_on", updatable = false)
    private Date createdOn;
    @Column(name = "last_modified_on")
    private Date lastModifiedOn;
    @Version
    @Column(name = "version")
    private Long version;

    @PrePersist
    public void onCreate() {
        createdOn = lastModifiedOn = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        lastModifiedOn = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
