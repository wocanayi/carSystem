package com.qtt.ssm.city.view;

import com.qtt.ssm.base.pojo.JsonBean;
import com.qtt.ssm.base.utils.JsonUtils;
import com.qtt.ssm.base.vo.VCity;
import com.qtt.ssm.city.pojo.City;
import com.qtt.ssm.city.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author XC
 */
@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @RequestMapping("/select")
    @ResponseBody
    public JsonBean select(Integer pid) {
        JsonBean jsonBean = null;
        List<City> cities = cityService.selectAll(pid);
        jsonBean = JsonUtils.createJsonBean(1,cities);
        return jsonBean;
    }

    @RequestMapping("/all")
    @ResponseBody
    public JsonBean selectAllInfo() {
        JsonBean jsonBean = null;
        List<City> cityList = cityService.selectAllInfo();
        jsonBean = JsonUtils.createJsonBean(1, cityList);
        return jsonBean;
    }

    @RequestMapping("/citys")
    @ResponseBody
    public JsonBean selectCitys(Integer getid, Integer backid) {
        JsonBean jsonBean = null;
        VCity vCity = cityService.selectCity(getid, backid);
        jsonBean = JsonUtils.createJsonBean(1, vCity);
        return jsonBean;
    }
}
