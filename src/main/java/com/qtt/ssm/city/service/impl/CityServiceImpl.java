package com.qtt.ssm.city.service.impl;

import com.qtt.ssm.base.vo.VCity;
import com.qtt.ssm.city.dao.ICityDao;
import com.qtt.ssm.city.pojo.City;
import com.qtt.ssm.city.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XC
 */
@Service
public class CityServiceImpl implements ICityService {

    @Autowired
    private ICityDao cityDao;

    @Override
    public List<City> selectAll(Integer pid) {
        return cityDao.selectByPid(pid);
    }

    @Override
    public List<City> selectAllInfo() {
        return cityDao.selectAll();
    }

    @Override
    public VCity selectCity(Integer getid, Integer backid) {
        City getCity = cityDao.selectByPrimaryKey(getid);
        City backCity = cityDao.selectByPrimaryKey(backid);
        VCity vCity = new VCity(getCity, backCity);
        return vCity;
    }
}
