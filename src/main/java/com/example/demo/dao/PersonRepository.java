package com.example.demo.dao;

import com.example.demo.pojo.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person,Integer> {

    Person getFirstByName(String name);

    List<Person> getAllByAgeGreaterThanEqual(Integer age);

    List<Person> getByNameLike(String name);
}
