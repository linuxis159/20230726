package com.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Document {
    private int documentId;
    private String title;
    private String desc;
    private String createUser;
    private Date createDate;
}
