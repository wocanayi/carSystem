package com.qtt.ssm.city.service;

import com.qtt.ssm.base.vo.VCity;
import com.qtt.ssm.city.pojo.City;

import java.util.List;

/**
 * @author XC
 */
public interface ICityService {
    /**
     * 根据pid选择city
     *
     * @param pid pid
     * @return city列表
     */
    List<City> selectAll(Integer pid);

    /**
     * 选择所有的city
     *
     * @return city列表
     */
    List<City> selectAllInfo();

    /**
     * 根据id选择city
     *
     * @param getid 取车id
     * @param backid 还车id
     * @return city的name
     */
    VCity selectCity(Integer getid, Integer backid);
}
