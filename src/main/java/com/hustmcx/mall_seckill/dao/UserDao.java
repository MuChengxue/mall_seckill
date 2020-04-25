package com.hustmcx.mall_seckill.dao;

import com.hustmcx.mall_seckill.model.User;
import com.hustmcx.mall_seckill.vo.user.UserVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " user_name, user_account, user_password, user_sex, user_age, user_address, user_email ";
    String SELECT_FIELDS = " id," + INSERT_FIELDS;

    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", keyColumn = "id", before = false, resultType = java.lang.Integer.class)
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userName},#{userAccount},#{userPassword},#{userSex},#{userAge},#{userAddress},#{userEmail})"})
    void insertUser(User user);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id = #{id}"})
    User getUserById(int id);


    @Update({"update", TABLE_NAME, " set " +
            "user_name=#{userName}, user_account=#{userAccount}, " +
            "user_password=#{userPassword}, user_sex=#{userSex}, " +
            "user_age=#{userAge}, user_address=#{userAddress}, " +
            "user_email=#{userEmail} " +
            "where id = #{id}"})
    void updateUser(User user);

    @Delete({"delete from ", TABLE_NAME, "where id=#{id}"})
    void deleteUserById(int id);

    /**
     * get所有的user
     *
     * @param userVo
     * @return
     */
    List<User> queryUserByVo(UserVo userVo);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where user_account = #{userAccount}"})
    User getUserByUserAccount(String userAccount);
}
