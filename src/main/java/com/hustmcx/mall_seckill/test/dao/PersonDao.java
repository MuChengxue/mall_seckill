package com.hustmcx.mall_seckill.test.dao;

import com.hustmcx.mall_seckill.test.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonDao {
    @Select("select id,name,age,birthday,address from Person where id = #{value}")
    Person queryPersonById(int value);

    //    @Select("insert into Person(name,age,address,birthday) value(#{name},#{age},#{address},#{birthday})")
//    @SelectKey(before = false,keyColumn = "id",keyProperty = "person.id",resultType = Integer.class, statement = "select last_insert_id()")
    void insertPerson(Person person);
}