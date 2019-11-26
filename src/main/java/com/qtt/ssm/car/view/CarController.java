package com.qtt.ssm.car.view;

import com.qtt.ssm.base.pojo.JsonBean;
import com.qtt.ssm.base.utils.JsonUtils;
import com.qtt.ssm.car.pojo.Car;
import com.qtt.ssm.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author XC
 */
@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;

    @RequestMapping("/price")
    @ResponseBody
    public JsonBean selectByPrice(Integer getid) {
        JsonBean jsonBean = null;
        List<Car> carList = carService.findByPrice(getid);
        jsonBean = JsonUtils.createJsonBean(1, carList);
        return jsonBean;
    }

    @RequestMapping("/number")
    @ResponseBody
    public JsonBean selectByNum(Integer getid) {
        JsonBean jsonBean = null;
        List<Car> carList = carService.findByNum(getid);
        jsonBean = JsonUtils.createJsonBean(1, carList);
        return jsonBean;
    }

    @RequestMapping("/findCar")
    @ResponseBody
    public JsonBean findCar(Integer cid) {
        JsonBean jsonBean = null;
        Car car = carService.findById(cid);
        jsonBean = JsonUtils.createJsonBean(1, car);
        return jsonBean;
    }
}
