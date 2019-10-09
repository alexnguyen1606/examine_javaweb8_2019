package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.annotation.Column;

import java.util.Date;

public class BaseEntity  {
    @Column(name = "id")
    private Long id;
    @Column(name = "createddate")
    private Date createdDate;
    @Column(name = "createdby")
    private String createdBy;
    @Column(name = "modifieddate")
    private Date modifiedDate;
    @Column(name = "modifiedby")
    private String modifiedBy;
    @Column(name = "status")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
