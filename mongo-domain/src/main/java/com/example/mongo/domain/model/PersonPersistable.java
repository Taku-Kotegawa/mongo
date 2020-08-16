package com.example.mongo.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonPersistable implements Persistable<String> {

    @Id
    private String id;
    private String name;
    private Integer age;

    @Version
    private Long version;

    @CreatedBy
    private String CreatedBy;

    @LastModifiedBy
    private String LastModifiedBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime LastModifiedDate;

    public PersonPersistable(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean isNew() {

        return createdDate == null;
    }
}
