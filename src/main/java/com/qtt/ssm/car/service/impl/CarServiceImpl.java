package com.qtt.ssm.car.service.impl;

import com.qtt.ssm.car.dao.ICarDao;
import com.qtt.ssm.car.pojo.Car;
import com.qtt.ssm.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XC
 */
@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private ICarDao carDao;

    @Override
    public List<Car> findByPrice(Integer cid) {
        return carDao.findByPrice(cid);
    }

    @Override
    public List<Car> findByNum(Integer cid) {
        return carDao.findByNum(cid);
    }

    @Override
    public Car findById(Integer cid) {
        return carDao.findById(cid);
    }
}
