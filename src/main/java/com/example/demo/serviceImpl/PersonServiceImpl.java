package com.example.demo.serviceImpl;

import com.example.demo.dao.PersonRepository;
import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person getByName(String name) {
        return personRepository.getFirstByName(name);
    }

    @Override
    public List<Person> getByAge(Integer age) {
        return personRepository.getAllByAgeGreaterThanEqual(age);
    }
}
