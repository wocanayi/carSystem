package com.qtt.ssm.base.vo;

import com.qtt.ssm.city.pojo.City;

/**
 * @author XC
 */
public class VCity {
    private City getCity;
    private City backCity;

    public VCity(City getCity, City backCity) {
        this.getCity = getCity;
        this.backCity = backCity;
    }

    public City getGetCity() {
        return getCity;
    }

    public void setGetCity(City getCity) {
        this.getCity = getCity;
    }

    public City getBackCity() {
        return backCity;
    }

    public void setBackCity(City backCity) {
        this.backCity = backCity;
    }
}
