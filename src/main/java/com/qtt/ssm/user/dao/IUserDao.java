package com.qtt.ssm.user.dao;

import com.qtt.ssm.user.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author XC
 */
@Repository
public interface IUserDao {
    /**
     * 根据tel判断有无当前用户
     *
     * @param tel tel
     * @return 有当前用户则返回User，无则为null
     */
    User findByTel(String tel);

    /**
     * 选择行的插入
     *
     * @param user user
     */
    void insertSelective(User user);

    User findById(Integer id);

    void updateByPrimaryKeySelective(User user);
}
