/**  
* @Title: JSONUtil.java 
* @Package com.platform.webservice.util 
* @Description: TODO
* @author kiosk
* @date 2017年7月20日 下午3:24:10 
* @version V1.0
* @Copyright: Copyright (c) kiosk Co.Ltd. 2017
* ★★★★★★★★版权所有※拷贝必究 ★★★★★★★★
*/ 
package com.hlst.pay.utils;

import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
/** 
 * @ClassName: JSONUtil 
 * @Description: TODO
 * @author kiosk
 * @date 2017年7月20日 下午3:24:10
 * @version V1.0 
 */
public class JSONUtil {
	 /**
     * 将json转化为实体POJO
     * @param jsonStr
     * @param obj
     * @return
     */
    public static<T> Object JSONToObj(String jsonStr,Class<T> obj) {
        T t = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            t = objectMapper.readValue(jsonStr,
                    obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
     
    /**
     * 将实体POJO转化为JSON
     * @param obj
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public static<T> JSONObject objectToJson(T obj) throws JSONException, IOException {
        ObjectMapper mapper = new ObjectMapper();  
        // Convert object to JSON string  
        String jsonStr = "";
        try {
             jsonStr =  mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw e;
        }
        return new JSONObject(jsonStr);
    }
}
