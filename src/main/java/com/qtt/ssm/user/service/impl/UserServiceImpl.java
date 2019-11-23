package com.qtt.ssm.user.service.impl;

import com.qtt.ssm.user.dao.IUserDao;
import com.qtt.ssm.user.pojo.User;
import com.qtt.ssm.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XC
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User findByTel(String tel) {
        return userDao.findByTel(tel);
    }

    @Override
    public void register(User user) {
        userDao.insertSelective(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.updateByPrimaryKeySelective(user);
    }
}
