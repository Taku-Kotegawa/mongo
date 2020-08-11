package com.example.mongo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Person")
public class Person implements Persistable<String> {

    @Id
    private String id;
    private String name;
    private int age;

    @CreatedBy
    private String CreatedBy;

    @LastModifiedBy
    private String LastModifiedBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date LastModifiedDate;


    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
