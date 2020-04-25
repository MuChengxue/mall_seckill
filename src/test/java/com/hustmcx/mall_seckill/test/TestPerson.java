package com.hustmcx.mall_seckill.test;

import com.hustmcx.mall_seckill.MallSeckillApplication;
import com.hustmcx.mall_seckill.test.model.Person;
import com.hustmcx.mall_seckill.test.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MallSeckillApplication.class)
public class TestPerson {

    @Autowired
    PersonService personService;

    @Test
    public void testInsertPerson() {
        System.out.println(personService);
        Person person = new Person();
        person.setName("小白白");
        person.setAddress("43648415");
        person.setAge(12);
        personService.insertPerson(person);
        System.out.println(person);
    }

    @Test
    public void testgettPerson() {
        Person person = personService.queryPersonById(2);
        System.out.println(person);
    }
}
