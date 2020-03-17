/**  
* @Title: PayParam.java 
* @Package com.platform.ui.domain 
* @Description: TODO
* @author kiosk
* @date 2017年7月19日 上午10:28:03 
* @version V1.0
* @Copyright: Copyright (c) kiosk Co.Ltd. 2017
* ★★★★★★★★版权所有※拷贝必究 ★★★★★★★★
*/
package com.hlst.pay.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import com.alipay.api.domain.ExtendParams;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @ClassName: PayParam
 * @Description: TODO
 * @author kiosk
 * @date 2017年7月19日 上午10:28:03
 * @version V1.0
 */
public class AliPayRequestParameter implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -5251090050343911025L;
	/**
	 * 公共请求参数
	 */
	/*private String app_id;// 开发者的AppId
	private String method;// 接口名称
	private String charset;// 参数字符编码
	private String sign_type;// 签名类型
	private String sign;// 签名
	private String version;// 接口版本号
	*/
	
	private String biz_id;
	private String identity_param;
	

	public String getBiz_id() {
		return biz_id;
	}

	public void setBiz_id(String biz_id) {
		this.biz_id = biz_id;
	}

	public String getIdentity_param() {
		return identity_param;
	}

	public void setIdentity_param(String identity_param) {
		this.identity_param = identity_param;
	}

	// 预下单请求
	private String out_trade_no;// 商户订单号
	private String seller_id;// 卖家支付宝用户 ID.如果该值为空，则默认为商户签约账号对应的支付宝用户 ID
	private String total_amount;// 订单总金额：单位为元，精确到小数点后两位，取值范围[0.01,100000000],
								// 如果同时传入了【打折金额】，【不可打折金额】，【订单总
								// 金额】三者，则必须满足如下条件:【订单总金额】=【打折 金额】+【不可打折金额】
	private String discountable_amount;// 可打折金额：参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]如果该值未传入，但传入了【订
										// 单总金额】，【不可打折金额】 则该值默认为【订单总金额】-
										// 【不可打折金额】
	private String undiscountable_amount;// 不可打折金额：不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]如果该值未传入，但传入了【订
											// 单总金额】，【打折金额】，则该值默认为【订单总金额】-
											// 【打折金额】
	private String subject;// 订单标题
	private String body;// 订单描述：对交易或商品的描述
	private List<Goods_detail> goods_detail=new ArrayList<Goods_detail>();// 商品明细列表：订单包含的商品列表信息， Json 格式，其它说明详见:“商品明细说明”
	private String operator_id;// 商户操作员编号
	private String store_id;// 商户门店编号
	private String terminal_id;// 机具终端编号
	private String disable_pay_channels;//禁用渠道
	private ExtendParams extend_params;// 扩展参数
	private String notify_url;//扫码支付异步通知url
	private String timeout_express;// 支付超时时间：该笔订单允许的最晚付款时间，逾期将关闭交易。格式为: yyyy-MM-dd
								// HH:mm:ss

	private String qr_code_timeout_express;//二维码失效时间单位 m h d
	


	public String getQr_code_timeout_express() {
		return qr_code_timeout_express;
	}

	public void setQr_code_timeout_express(String qr_code_timeout_express) {
		this.qr_code_timeout_express = qr_code_timeout_express;
	}

	public String getTimeout_express() {
		return timeout_express;
	}

	public void setTimeout_express(String timeout_express) {
		this.timeout_express = timeout_express;
	}
	
	
	
	
	

	/*public String getSign_type() {
		return sign_type;
	}
*/
	/**
	 * @param sign_type
	 *            the sign_type to set
	 */

	/*public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	*/
	

	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * @param out_trade_no
	 *            the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the sign
	 */

	/*public String getSign() {
		return sign;
	}*/

	/**
	 * @param sign
	 *            the sign to set
	 */

	/*public void setSign(String sign) {
		this.sign = sign;
	}

*/
	/**
	 * @return the app_id
	 */
	/*public String getApp_id() {
		return app_id;
	}
*/
	/**
	 * @param app_id
	 *            the app_id to set
	 */
	/*public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
*/
	/**
	 * @return the method
	 */
	/*public String getMethod() {
		return method;
	}
*/
	/**
	 * @param method
	 *            the method to set
	 */
	/*public void setMethod(String method) {
		this.method = method;
	}
*/
	/**
	 * @return the charset
	 */
	/*public String getCharset() {
		return charset;
	}
*/
	/**
	 * @param charset
	 *            the charset to set
	 */
/*	public void setCharset(String charset) {
		this.charset = charset;
	}
*/
	/**
	 * @return the version
	 */
	/*public String getVersion() {
		return version;
	}
*/
	/**
	 * @param version
	 *            the version to set
	 */
/*	public void setVersion(String version) {
		this.version = version;
	}
*/
	/**
	 * @return the seller_id
	 */
	public String getSeller_id() {
		return seller_id;
	}

	/**
	 * @param seller_id the seller_id to set
	 */
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	/**
	 * @return the total_amount
	 */
	public String getTotal_amount() {
		return total_amount;
	}

	/**
	 * @param total_amount the total_amount to set
	 */
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	/**
	 * @return the discountable_amount
	 */
	public String getDiscountable_amount() {
		return discountable_amount;
	}

	/**
	 * @param discountable_amount the discountable_amount to set
	 */
	public void setDiscountable_amount(String discountable_amount) {
		this.discountable_amount = discountable_amount;
	}

	/**
	 * @return the undiscountable_amount
	 */
	public String getUndiscountable_amount() {
		return undiscountable_amount;
	}

	/**
	 * @param undiscountable_amount the undiscountable_amount to set
	 */
	public void setUndiscountable_amount(String undiscountable_amount) {
		this.undiscountable_amount = undiscountable_amount;
	}

	

	/**
	 * @return the operator_id
	 */
	public String getOperator_id() {
		return operator_id;
	}

	/**
	 * @param operator_id the operator_id to set
	 */
	public void setOperator_id(String operator_id) {
		this.operator_id = operator_id;
	}

	/**
	 * @return the store_id
	 */
	public String getStore_id() {
		return store_id;
	}

	/**
	 * @param store_id the store_id to set
	 */
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	/**
	 * @return the terminal_id
	 */
	public String getTerminal_id() {
		return terminal_id;
	}

	/**
	 * @param terminal_id the terminal_id to set
	 */
	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}

	/**
	 * @return the extend_params
	 */
	public ExtendParams getExtend_params() {
		return extend_params;
	}
	/**
	 * @param extend_params the extend_params to set
	 */
	public void setExtend_params(ExtendParams extend_params) {
		this.extend_params = extend_params;
	}


	/**
	 * @return the goods_detail
	 */
	public List<Goods_detail> getGoods_detail() {
		return goods_detail;
	}

	/**
	 * @param goods_detail the goods_detail to set
	 */
	public void setGoods_detail(List<Goods_detail> goods_detail) {
		this.goods_detail = goods_detail;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getDisable_pay_channels() {
		return disable_pay_channels;
	}

	public void setDisable_pay_channels(String disable_pay_channels) {
		this.disable_pay_channels = disable_pay_channels;
	}
	
}
