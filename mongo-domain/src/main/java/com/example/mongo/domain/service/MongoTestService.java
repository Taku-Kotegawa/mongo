package com.example.mongo.domain.service;

import com.example.mongo.domain.model.Person;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Slf4j
@Service
public class MongoTestService {

    public void test() {
        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "testdb");
        Person result = mongoOps.findOne(new Query(where("name").is("Joe")), Person.class);
    }



}
