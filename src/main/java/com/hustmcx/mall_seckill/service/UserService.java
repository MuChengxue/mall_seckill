package com.hustmcx.mall_seckill.service;

import com.hustmcx.mall_seckill.dao.UserDao;
import com.hustmcx.mall_seckill.model.User;
import com.hustmcx.mall_seckill.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    /**
     * get所有的user
     *
     * @param userVo
     * @return
     */
    public List<User> queryUserByVo(UserVo userVo) {
        return userDao.queryUserByVo(userVo);
    }

    public User getUserByUserAccount(String userAccount) {
        return userDao.getUserByUserAccount(userAccount);
    }

}
