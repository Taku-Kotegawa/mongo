package com.example.mongo.domain.service;

import com.example.mongo.domain.model.Person;
import com.example.mongo.domain.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
public class MongoRepositoryTest {

    @Autowired
    PersonRepository target;

    @Autowired
    MongoOperations mongoOperations;

    private Person createPerson(String id) {
        return new Person(id, id + "_name", Integer.parseInt(id));
    }

    private void insertIntoDatabase(Person... persons) {
        Collection<Person> collection = new ArrayList<>();
        Collections.addAll(collection, persons);
        mongoOperations.insertAll(collection);
    }

    // -- insert --

    @Test
    @DisplayName("insert_001_[正常系]単一レコードの挿入")
    public void insert_001() {

        // -- 準備 --
        mongoOperations.dropCollection("Person");
        Person excepted = createPerson("1");

        // -- 実行 --
        Person actual = target.insert(excepted);

        // -- 検証 --
        log.info(actual.toString());
//        assertThat(actual).isEqualTo(excepted);

        log.info(mongoOperations.find(new Query(), Person.class).toString());

    }


}
