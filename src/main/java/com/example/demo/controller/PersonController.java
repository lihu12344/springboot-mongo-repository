package com.example.demo.controller;

import com.example.demo.dao.PersonRepository;
import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping("/save")
    public String save(){
        for(int i=0;i<100;i++){
            Person person=new Person();
            person.setId(i);
            person.setName("瓜田李下"+i);
            person.setAge(i%10+15);

            personRepository.save(person);
        }

        return "success";
    }

    @RequestMapping("/get")
    public Person get(){
        return  personService.getByName("瓜田李下2");
    }

    @RequestMapping("/get2")
    public List<Person> get2(){
        return personService.getByAge(18);
    }

    @RequestMapping("/get3")
    public List<Person> get3(String name,Integer age){
        Person person=new Person();
        if(name!=null){
            person.setName(name);
        }

        if(age!=null){
            person.setAge(age);
        }
        Example<Person> example=Example.of(person);
        return personRepository.findAll(example);
    }

    @RequestMapping("/get4")
    public List<Person> get4(){
        Sort sort=Sort.by(Sort.Direction.DESC,"age");
        return personRepository.findAll(sort);
    }

    @RequestMapping("/get5")
    public List<Person> get5(int pageNum,int pageSize){
        PageRequest pageRequest=PageRequest.of(pageNum,pageSize);
        return personRepository.findAll(pageRequest).getContent();
    }

    @RequestMapping("/get6")
    public List<Person> get6(){
        Sort sort=Sort.by(Sort.Direction.DESC,"age");
        PageRequest pageRequest=PageRequest.of(2,5,sort);
        Page<Person> page=personRepository.findAll(pageRequest);

        System.out.println("总页数为："+page.getTotalPages());
        System.out.println("总条数为："+page.getTotalElements());
        return page.getContent();
    }

    @RequestMapping("/get8")
    public List<Person> get8(){
        return personRepository.getByNameLike("瓜田李下");
    }
}
