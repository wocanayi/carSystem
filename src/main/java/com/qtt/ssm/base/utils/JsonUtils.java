package com.qtt.ssm.base.utils;

import com.qtt.ssm.base.pojo.JsonBean;

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
