package com.qtt.ssm.city.dao;

import com.qtt.ssm.city.pojo.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XC
 */
@Repository
public interface ICityDao {
    /**
     * 根据pid选择city
     *
     * @param pid pid
     * @return city列表
     */
    List<City> selectByPid(Integer pid);

    /**
     * 选择所有的city
     *
     * @return city列表
     */
    List<City> selectAll();

    /**
     * 根据id选择city
     *
     * @param id id
     * @return city
     */
    City selectByPrimaryKey(Integer id);
}
