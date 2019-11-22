package com.qtt.ssm.base.vo.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author XC
 */
@Controller
@RequestMapping("/test")
public class ValidateCode {
    @RequestMapping("/index")
    public String to() {
        return "index";
    }

    @RequestMapping(value = "/sendCode")
    @ResponseBody
    public String sendCode(String phone) {
        if (null == phone) {
            return "error";
        }

        // 生成验证码
        String verifyCode = getCode(4);
        // 存储验证码
        Jedis jedis = new Jedis("192.4.8.20", 6379);

        // 键：phone 有效时长：20 值：verifyCode
        jedis.setex(phone, 20, verifyCode);
        jedis.close();

        // 发送验证码
        System.out.println(verifyCode);

        // 返回
        return "success";
    }

    private String getCode(int codeLength) {
        String code = "";
        for (int i = 0; i < codeLength; i++) {
            int num = new Random().nextInt(10);
            code += num;
        }
        return code;
    }

    @RequestMapping(value = "/verifyCode")
    @ResponseBody
    public String verifyCode(String phone, String code) {
        // 判断参数
        if (null == code) {
            return "error";
        }

        // 验证
        Jedis jedis = new Jedis("192.4.8.20", 6379);
        String phoneKey = jedis.get(phone);
        System.out.println(phoneKey);

        if (code.equals(phoneKey)) {
            return "success";
        }

        jedis.close();
        return "error";
    }
}
