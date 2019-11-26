package com.qtt.ssm.car.dao;

import com.qtt.ssm.car.pojo.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XC
 */
@Repository
public interface ICarDao {

    List<Car> findByPrice(Integer cid);

    List<Car> findByNum(Integer cid);

    Car findById(Integer cid);
}
