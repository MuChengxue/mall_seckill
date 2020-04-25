package com.hustmcx.mall_seckill.test.service;

import com.hustmcx.mall_seckill.test.dao.PersonDao;
import com.hustmcx.mall_seckill.test.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonDao personDao;

    public Person queryPersonById(int id) {
        return personDao.queryPersonById(id);
    }


    public void insertPerson(Person person) {
        personDao.insertPerson(person);
    }
}