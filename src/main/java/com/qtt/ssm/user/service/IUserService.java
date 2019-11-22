package com.qtt.ssm.user.service;

import com.qtt.ssm.user.pojo.User;

/**
 * @author XC
 */
public interface IUserService {
    User findByTel(String tel);

    void register(User user);
}
