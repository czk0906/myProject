/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package com.hlst.pay.utils;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;


/**
 * API调用客户端工厂
 * 
 * @author taixu.zqq
 * @version $Id: AlipayAPIClientFactory.java, v 0.1 2014年7月23日 下午5:07:45 taixu.zqq Exp $
 */
public class AlipayAPIClientFactory {

    /** API调用客户端 */
    private static AlipayClient alipayClient;
    
    /**
     * 获得API调用客户端
     * 
     * @return
     */
    public static AlipayClient getAlipayClient(String ALIPAY_GATEWAY,String APP_ID,String PRIVATE_KEY,String CHARSET,String ALIPAY_PUBLIC_KEY,String SIGN_TYPE){
        if(null == alipayClient){
            alipayClient = new DefaultAlipayClient(ALIPAY_GATEWAY, APP_ID,PRIVATE_KEY, "json", CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);
            
        }
        return alipayClient;
    }
}
