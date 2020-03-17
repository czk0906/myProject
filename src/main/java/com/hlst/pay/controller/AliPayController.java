package com.hlst.pay.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.hlst.pay.entity.AliPayRequestParameter;
import com.hlst.pay.entity.SmileInitializePara;
import com.hlst.pay.entity.ZolozAuthenticationCustomerSmileliveInitializeRequest;
import com.hlst.pay.entity.ZolozAuthenticationCustomerSmileliveInitializeResponse;
import com.hlst.pay.entity.ZolozAuthenticationCustomerSmilepayInitializeRequest;
import com.hlst.pay.entity.ZolozAuthenticationCustomerSmilepayInitializeResponse;
import com.hlst.pay.utils.AlipayAPIClientFactory;
import com.hlst.pay.utils.JSONUtil;

/**
 * 支付宝Controller
 * 
 * @author Czk
 *
 */

@RestController
@RequestMapping("/alipay")
public class AliPayController {

	private static Logger logger = (Logger) LoggerFactory.getLogger(AliPayController.class);

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public String pay(@RequestBody AliPayRequestParameter requestParameter) {
		logger.info("#######################统一收单交易支付开始");
		logger.info("#######################接收到的值requestParameter: " + requestParameter.toString());
		String resultStr = null;
		String str = null;
		String errorString = null;
		try {
			// 把接收到实体类转成json格式
			str = JSONUtil.objectToJson(requestParameter).toString();
			// 声明支付宝支付请求客户端
			AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient("https://openapi.alipay.com/gateway.do",
					"2017082508378366",
					"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCXF6PhmUsfOQ3w/ZLubtPaRQwQbpBnPH5t6frtkC38dSV6XA7Hl/5vAsKeZ4Rr6BQKjSO1IY/qqx3nWq9Yby8JVIO810S5lEZO8rkuvlxnLcypadII9jiLovZ+QsodABzek3H/WquObv0tzxMh9rZHKokqxqoV7+ZCsv/idiD1ua7d+y+Zo2VQoX8GMNJy0PvGErIX8w5Kv3URuN32fv7NV1qWDnPvDfhoN9lm4s+R9AgmqyaViXbWM2VSa6z2LBwSjQNGq1yOHhNJxyjqa/k4Jn2s/beN94hdHuLE/kQ/ISPeoQiu27qVgEyEtmq+0AFUJxAsh7VDRiUNc2h8XvzfAgMBAAECggEAc5VzGgch772+y4fAWkRQLt65Tuy17TPa6AyhmBC/DS00wXkhGVFOI/Axn+pC5CWDB1tXYJ5PMU88Lhsynm1Xx0RvDwyDF5C1hHmsbnTTzV68/TDlq1NoiHHfLVG8uhi2/RJAl/7t1KVVazDJSycn5CNHEYEu5l9Cf+3dUInbxv3bIJ9JA2aL9kWld4lQpyw79wreLs9YpR+cGFBYsqKtPVUCl7kqgjqPzvv50rPr4R1b1J57OfELKtju1dqv1uxB8yJ2CamvowFVzlH3EFbtpW8NTmCQCvH1XC9aN9+MpM5qynBk5XMmAMWwXuniGTuNzRyXETeVzKw0vhIY1uB5EQKBgQDKQ2xPpDRBcDwFF+XHhkss6JD/otMFyFPticD0UDJd+gdIdlUHDqWeraZ/bcvlVdD3Jl/wsEFOEJAfxYQKQMF8PuKSYrJQaEWwYkwa/XUmmdlxzpXhSUKtSydVxhyZ6imXe5TpsOHgKMQCFQkpppE6W+7DtrBCo/g82SlvTZte6QKBgQC/O+mO1TNrzwbtBiFLFgq42ydM99N/vgNq780OYkCEVS2FxVM9E0fMVw3LxEBw2tzGSYKbzvInnlrsYba8JQr9nu/anTEh8AfxBFo1kuaa/+hjj4kkhguqN+MftMlTlfLGsLzIu884GUAgmmJDrYhBZdvIjCHJ/P+KNSm2eFpwhwKBgDA7W7yyH3PrW6SrSjQGJi8TVmBfZ4rddoYSb1zTMu+OC+aPsT75kyz/o9CHUjPh/u6wy/gNT8VZ1cR9yTrYrkr+g/D8cCEUfGnPRu64uhL2ZQ/qf3s1iRzh6wNdNrzNRhXFdoEzmOlnTzZf5ct02PTdr1YkXmvFxhBciLDuBLrhAoGAQuNm1xHVkZDxQDiTrprAF1Z4UaChdp30vhOwaqaNIHxWluKlMcirpVqRtcMoMxEqhaSyrWLeKmNmNCYdb4OZa4qLJLE0vUUi0feOwgxm4rI+C4zqED9elyRDKhTnEnhxWXP6JFAks9+JIZ4+XqO09AL3tBbnvqnii+n6dBt2rsMCgYAJ6LhPlnMC1zS1gXZSdkPsoz0sIg//OS6fbmiK2TjudHVLT+NsqNaQ0T1ekBFU7JdDVhkJpVlCmkcsu6cZAsQkhSZiKrBY+A6yv6xmP/4rcrjQKkBpRipmm6dnv/aeUsAkHZoQXH8S8og1c5P66iKpPdbRGhBP5h15W9Q3rJ1z7g==",
					"UTF-8",
					"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwkMyqYUTbobEv3rYTWgLqEdf0HiFVCDGR2KsgjLfEA32oFPMOwPxd1zYltm+YiCQDNDBzdEnF02huDMPNX6IECpt/sWNmm4b4cozy+wjYo2p9TkcbnJgLcXw5+gGEzyPmTRz2j18q6l5rvkSd4kPEugZh5veKwtJwRu6I6f1FzV7uUfR7eO6wwt/5SCchrckDNcX4Hx5XULKAxNIMBvxcJVO8vMgfkwRDt3GIfLCwGHdyn4dHOMHcf007tQpvzro3Zd9zBESkvWk3wfHVaW8H+1Ysa4A8CcacteYH8iUrAkx2ofEwNJD6iXXKmE3n2yOMav+XtpoL4redEyw1BIZnwIDAQAB",
					"RSA2");
			AlipayTradePayRequest request = new AlipayTradePayRequest();
			//request.setBizContent(str);
			request.setBizContent("{" +
					"\"out_trade_no\":\"20150320010101001\"," +
					"\"scene\":\"bar_code\"," +
					"\"auth_code\":\"28763443825664394\"," +
					"\"product_code\":\"FACE_TO_FACE_PAYMENT\"," +
					"\"subject\":\"Iphone6 16G\"," +
					"\"buyer_id\":\"2088202954065786\"," +
					"\"seller_id\":\"2088102146225135\"," +
					"\"total_amount\":88.88," +
					"\"trans_currency\":\"USD\"," +
					"\"settle_currency\":\"USD\"," +
					"\"discountable_amount\":8.88," +
					"\"body\":\"Iphone6 16G\"," +
					"      \"goods_detail\":[{" +
					"        \"goods_id\":\"apple-01\"," +
					"\"goods_name\":\"ipad\"," +
					"\"quantity\":1," +
					"\"price\":2000," +
					"\"goods_category\":\"34543238\"," +
					"\"categories_tree\":\"124868003|126232002|126252004\"," +
					"\"body\":\"特价手机\"," +
					"\"show_url\":\"http://www.alipay.com/xxx.jpg\"" +
					"        }]," +
					"\"operator_id\":\"yx_001\"," +
					"\"store_id\":\"NJ_001\"," +
					"\"terminal_id\":\"NJ_T_001\"," +
					"\"extend_params\":{" +
					"\"sys_service_provider_id\":\"2088511833207846\"," +
					"\"industry_reflux_info\":\"{\\\\\\\"scene_code\\\\\\\":\\\\\\\"metro_tradeorder\\\\\\\",\\\\\\\"channel\\\\\\\":\\\\\\\"xxxx\\\\\\\",\\\\\\\"scene_data\\\\\\\":{\\\\\\\"asset_name\\\\\\\":\\\\\\\"ALIPAY\\\\\\\"}}\"," +
					"\"card_type\":\"S0JP0000\"" +
					"    }," +
					"\"timeout_express\":\"90m\"," +
					"\"auth_confirm_mode\":\"COMPLETE：转交易支付完成结束预授权;NOT_COMPLETE：转交易支付完成不结束预授权\"," +
					"\"terminal_params\":\"{\\\"key\\\":\\\"value\\\"}\"," +
					"\"promo_params\":{" +
					"\"actual_order_time\":\"2018-09-25 22:47:33\"" +
					"    }," +
					"\"advance_payment_type\":\"ENJOY_PAY_V2\"" +
					"  }");
			AlipayTradePayResponse response;
			try {
				response = alipayClient.execute(request);
				System.out.println(JSONUtil.objectToJson(response).toString());
				if (response.isSuccess()) {
					System.out.println("调用成功");
				} else {
					System.out.println("调用失败");
				}
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("#######################统一收单交易支付结束");
		return resultStr;
	}

	/**
	 * 刷脸支付初始化
	 */
//	@RequestMapping(value = "/initialize", method = RequestMethod.POST)
//	public String Initialize(@RequestBody AliPayRequestParameter requestParameter, HttpServletRequest request) {
//		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
//		ZolozAuthenticationSmilepayInitializeRequest request = new ZolozAuthenticationSmilepayInitializeRequest();
//		request.setBizContent("{" +
//		"\"apdid_token\":\"40Kl9e97cQcMJka5gfT0arVPq7GTaR6yE5f73mj8zqBW9eOPZQEAAA==\"," +
//		"\"bio_meta_info\":\"3.13.0:12419136,6\"," +
//		"\"app_name\":\"com.alipay.zoloz.smile\"," +
//		"\"app_version\":\"3.7.0.201809191618\"," +
//		"\"device_type\":\"android\"," +
//		"\"device_model\":\"T2\"," +
//		"\"os_version\":\"7.1.1\"," +
//		"\"zim_ver\":\"1.0.0\"," +
//		"\"base_ver\":\"7.1.1\"," +
//		"\"remote_log_id\":\"bcf71c4290f288f4421ee9d49eedbf1e2840ba\"," +
//		"\"machine_info\":{" +
//		"\"camera_drive_ver\":\"1.0\"," +
//		"\"camera_model\":\"AstraP1\"," +
//		"\"camera_name\":\"AstraP1\"," +
//		"\"camera_ver\":\"1.0\"," +
//		"\"machine_code\":\"WyDAz27pfsEDANGk7QnmxZlv\"," +
//		"\"machine_model\":\"T2\"," +
//		"\"machine_ver\":\"7.1.1\"," +
//		"\"ext\":\"扩展信息\"" +
//		"    }," +
//		"\"merchant_info\":{" +
//		"\"area_code\":\"华中\"," +
//		"\"brand_code\":\"KFC\"," +
//		"\"device_mac\":\"1c:aa:07:b0:e7:af\"," +
//		"\"group\":\"group1\"," +
//		"\"device_num\":\"TEST_ZOLOZ_TEST\"," +
//		"\"geo\":\"120.10785,30.26708\"," +
//		"\"merchant_id\":\"2088302068579978\"," +
//		"\"partner_id\":\"2088302068579978\"," +
//		"\"store_code\":\"TEST\"," +
//		"\"wifimac\":\"1c:aa:07:b0:e7:af\"," +
//		"\"wifiname\":\"Alipay-Test\"" +
//		"    }," +
//		"\"ext_info\":{" +
//		"\"biz_type\":\"1\"" +
//		"    }" +
//		"  }");
//		ZolozAuthenticationSmilepayInitializeResponse response = alipayClient.execute(request);
//
//	}
	
	
	/**
     * 支付宝刷脸支付收单接口，和条码支付类似  刷脸支付默认为security_code
     *
     */
    public static AlipayTradePayResponse smilePay(String logId,  String out_trade_no,
                                                  String ftoken, String total_amount, String subject) {
 
        StringBuilder sb = new StringBuilder();
        sb.append("{\"out_trade_no\":\"" + out_trade_no + "\",");
        sb.append("\"scene\":\"security_code\",");
        sb.append("\"auth_code\":\"" + ftoken + "\",");
        sb.append("\"total_amount\":\"" + total_amount + "\",");
        sb.append("\"subject\":\"" + subject + "\",");
        sb.append("\"timeout_express\":\"10m\"}");
 
        AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient("ALIPAY_GATEWAY", "APP_ID",
        		"PRIVATE_KEY", "CHARSET", "ALIPAY_PUBLIC_KEY", "SIGN_TYPE");
 
        // 使用SDK，构建请求模型
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        request.setBizContent(sb.toString());
        AlipayTradePayResponse response = null;
 
        try {
            // 使用SDK，调用交易下单接口
            response = alipayClient.execute(request,null,"token");
 
        } catch (AlipayApiException e) {
            logger.error("logId:{}, 刷脸支付收单接口 异常，excepiton:", e);
            e.printStackTrace();;
        }
        return response;

    }
    
    
  
}
