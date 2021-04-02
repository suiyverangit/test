package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private int id;
    private int objectVersion;
    private String createdBy;
    private Date createdDate;
    private String lastUpdatedBy;
    private Date lastUpdatedDate;
}
