package com.example.demo.service;

import com.example.demo.pojo.Person;

import java.util.List;

public interface PersonService {

    Person getByName(String name);
    List<Person> getByAge(Integer age);
}
