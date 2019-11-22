package com.qtt.ssm.user.utils;

import com.qtt.ssm.base.vo.pojo.JsonBean;

/**
 * @author XC
 */
public class JsonUtils {
    public static JsonBean createJsonBean(int code, Object info) {
        JsonBean bean = new JsonBean();
        bean.setCode(code);
        bean.setInfo(info);
        return bean;
    }
}
