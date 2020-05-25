package com.shop.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ResponseJSON {
    public static <T> String encode(int stateCode, T data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stateCode", stateCode);
        jsonObject.put("data", data);
        return jsonObject.toJSONString();
    }
}
