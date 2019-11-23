package com.qtt.ssm.user.view;

import com.qtt.ssm.base.vo.pojo.JsonBean;
import com.qtt.ssm.user.pojo.User;
import com.qtt.ssm.user.service.IUserService;
import com.qtt.ssm.user.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 * @author XC
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 根据tel登录
     * @param tel tel
     * @return JsonBean
     */
    @RequestMapping("/login")
    @ResponseBody
    public JsonBean login(HttpSession session, String tel) {
        JsonBean jsonBean = null;

        User user = userService.findByTel(tel);
        session.setAttribute("user", user);
        if (null != user) {
            jsonBean = JsonUtils.createJsonBean(1, user);
        } else {
            jsonBean = JsonUtils.createJsonBean(0, "用户名或密码错误！");
        }
        return jsonBean;
    }

    /**
     * 注册
     *
     * @param user user
     * @return JsonBean
     */
    @RequestMapping("/register")
    @ResponseBody
    public JsonBean register(User user) {
        JsonBean jsonBean = null;
        userService.register(user);
        jsonBean = JsonUtils.createJsonBean(1, null);
        return jsonBean;
    }

    /**
     * 根据id查找用户
     *
     * @param id id
     * @return JsonBean
     */
    @RequestMapping("/findUser")
    @ResponseBody
    public JsonBean findUserById(Integer id) {
        JsonBean jsonBean = null;
        User user = userService.findById(id);
        jsonBean = JsonUtils.createJsonBean(1, user);
        return jsonBean;
    }

    @RequestMapping("/dengLu")
    @ResponseBody
    public JsonBean dengLu(HttpSession session) {
        JsonBean jsonBean = null;
        User user = (User) session.getAttribute("user");
        jsonBean = JsonUtils.createJsonBean(1, user);
        return jsonBean;
    }

    /**
     * 根据tel更新用户信息
     *
     * @param tel tel
     * @return JsonBean
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonBean update(HttpSession session, String tel) {
        JsonBean jsonBean = null;
        User user = (User) session.getAttribute("user");
        user.setTel(tel);
        userService.update(user);
        jsonBean = JsonUtils.createJsonBean(1, "修改成功！");
        return jsonBean;
    }

}
