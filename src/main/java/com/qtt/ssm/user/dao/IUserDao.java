package com.qtt.ssm.user.dao;

import com.qtt.ssm.user.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author XC
 */
@Repository
public interface IUserDao {
    User findByTel(String tel);
    void insertSelective(User user);
}
