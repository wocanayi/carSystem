package com.qtt.ssm.car.service;

import com.qtt.ssm.car.pojo.Car;

import java.util.List;

/**
 * @author XC
 */
public interface ICarService {
    /**
     * 按价格排序
     *
     * @param cid cid
     * @return car列表
     */
    List<Car> findByPrice(Integer cid);

    /**
     * 按数量排序
     *
     * @param cid cid
     * @return car列表
     */
    List<Car> findByNum(Integer cid);

    Car findById(Integer cid);
}
