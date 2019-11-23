package com.qtt.ssm.city.service;

import com.qtt.ssm.base.vo.VCity;
import com.qtt.ssm.city.pojo.City;

import java.util.List;

/**
 * @author XC
 */
public interface ICityService {
    List<City> selectAll(Integer pid);

    List<City> selectAllInfo();

    VCity selectCity(Integer getid, Integer backid);
}
