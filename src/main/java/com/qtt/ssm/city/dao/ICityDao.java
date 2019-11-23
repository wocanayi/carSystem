package com.qtt.ssm.city.dao;

import com.qtt.ssm.city.pojo.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XC
 */
@Repository
public interface ICityDao {
    List<City> selectByPid(Integer pid);

    List<City> selectAll();

    City selectByPrimaryKey(Integer id);
}
