package com.qtt.ssm.user.view;

import com.qtt.ssm.base.vo.pojo.JsonBean;
import com.qtt.ssm.user.pojo.User;
import com.qtt.ssm.user.service.IUserService;
import com.qtt.ssm.user.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author XC
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonBean login(String tel) {
        JsonBean bean = null;

        User user = userService.findByTel(tel);
        if (null != user) {
            bean = JsonUtils.createJsonBean(1, user);
        } else {
            bean = JsonUtils.createJsonBean(0, "用户名或密码错误！");
        }
        return bean;
    }

    @RequestMapping("/register")
    @ResponseBody
    public JsonBean register(User user) {
        JsonBean bean = null;
        userService.register(user);
        bean = JsonUtils.createJsonBean(1, null);
        return bean;
    }

}
