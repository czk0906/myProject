/**  
* @Title: ResponseParam.java 
* @Package com.platform.ui.domain 
* @Description: TODO
* @author kiosk
* @date 2017年7月19日 上午10:32:11 
* @version V1.0
* @Copyright: Copyright (c) kiosk Co.Ltd. 2017
* ★★★★★★★★版权所有※拷贝必究 ★★★★★★★★
*/ 
package com.hlst.demo.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/** 
 * @ClassName: ResponseParam 
 * @Description: TODO
 * @author kiosk
 * @date 2017年7月19日 上午10:32:11
 * @version V1.0 
 */
@XmlRootElement(name="epay")
public class ResponseParameterForInsert implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -7020555095876420991L;
	/** 
	* @Fields serialVersionUID : TODO
	* @version V1.0
	*/ 
	
	
	
	/**
	 * 公共参数
	 */
	private String service;//服务名称
	private String service_version;//服务版本号
	private String input_charset;//编码格式 UTF-8
	private String sign_type;//签名类型 MD5
	private String sign;//签名值
	
	/**
	 * 订单支付返回
	 */
	private String qr_url;
	private String code_url;
	private String terminalNo;
	
	/**
	 * 支付异步通知返回
	 */
	private String retcode;//返回状态码，0表示成功
	private String trade_mode;//交易模式：0001-担保支付  0002-即时到账
	private String trade_state;//交易状态：0表示成功,1 交易失败, 2未支付,3 处理中,4支付成功等待买家收货
	private String pay_info;//支付结果信息：支付成功时为空
	private String trans_channel;//支付渠道：pc-电脑，mb-移动互联网， tdc-二维码
	private String partner;//商户号,由三维易付统一分配的10位正整数(120XXXXXXX)
	private String subpartner;//二级商户号,由三维易付统一分配的10位正整数。二级商户必须送商户号和二级商户号
	private String out_trade_no;//商户系统内部的订单号,32个字符内、可包含字母,确保在商户系统唯一。
	private String transaction_id;//三维易付平台系统流水号当日日期+流水号序列 自动生成唯一
	private String bank_type;//银行类型，默认为“DEFAULT”－三维易付。
	private String bank_transno;//银行或者第三方流水号
	private String total_fee;//支付金额，单位为元，如果discount有值，通知的total_fee + discount = 请求的total_fee
	private String fee_type;//现金支付币种,目前只支持人民币,默认值是1；人民币
	private String notify_id;//支付结果通知id，商户收到支付结果时，通过通知id查询接口验证信息是否来自三维易付
	private String time_end;//支付完成时间，格式为yyyyMMdd hh：mm：ss。该时间取自三维易付服务器
	private Float transport_fee;//物流费用，单位为元，如果有值，必须保证transport_fee +  product_fee = total_fee
	private Float product_fee;//物品费用，单位为元。如果有值，必须保证transport_fee + product_fee=total_fee
	private Float discount;//折扣价格，单位为元，如果有值，通知的total_fee + discount = 请求的total_fee
	private String buyer_alias;//对应买家账号的一个加密串
	private String attach;//商家数据包，原样返回
	private String union_qr_url;

	public String getUnion_qr_url() {
		return union_qr_url;
	}

	public void setUnion_qr_url(String union_qr_url) {
		this.union_qr_url = union_qr_url;
	}


	/**
	 * 订单退款返回
	 */
	private String retmsg;//返回信息，如非空，为错误原因。
	private String out_refund_no;//商户退款单号
	private String refund_id;//平台退款单号
	private String refund_channel;//退款渠道, 0：退到平台账户 1：退到银行 2：退款到支付宝 3：退款到财付通 4：退款到银联
	private String refund_fee;//退款总金额,单位为元,可以做部分退款
	private String refund_status;//退款状态： 1：退款成功。 2：退款失败。 3：退款处理中。 4：未确定，需要商户原退款单号重新发起。 5：转入代发，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，资金回流到商户的现金帐号，需要商户人工干预，通过线下或者平台转账的方式进行退款
	private String recv_user_id;//转账退款接收退款的平台帐号
	private String reccv_user_name;//转账退款接收退款的姓名(需与接收退款的平台帐号绑定的姓名一致)
	
	/**
	 * 订单查询返回
	 */
	private String refund_state;//退款状态码：0 未退款 1全部退款 2部分退款(支付订单查询时有效)
	private String clear_state;//清算状态码：0-未清算 1-一级清算中 2-一级清算失败  3-一级清算完成  4-二级清算中 5-二级清算失败  6-二级清算完成 7-清算成功
	private String trade_type;//交易类型：0001-支付交易  0002 – 退款交易
	private boolean is_split;//是否对账，false未对账，true已对账
	private float platCharge;//平台应收一级商户手续费
	private float subPlatCharge;//平台应收二级商户手续费
	
	
	

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}
	/**
	 * @return the service_version
	 */
	public String getService_version() {
		return service_version;
	}
	/**
	 * @param service_version the service_version to set
	 */
	public void setService_version(String service_version) {
		this.service_version = service_version;
	}
	/**
	 * @return the input_charset
	 */
	public String getInput_charset() {
		return input_charset;
	}
	/**
	 * @param input_charset the input_charset to set
	 */
	public void setInput_charset(String input_charset) {
		this.input_charset = input_charset;
	}
	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}
	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}
	/**
	 * @param out_trade_no the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	
	/**
	 * @return the code_url
	 */
	public String getCode_url() {
		return code_url;
	}
	/**
	 * @param code_url the code_url to set
	 */
	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}
	  
		/**
		 * @return the sign_type
		 */  
	    
	public String getSign_type() {
		return sign_type;
	}
	  
	    /**
		 * @param sign_type the sign_type to set
		 */  
	    
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
		  
			/**
			 * @return the sign
			 */  
		    
		public String getSign() {
			return sign;
		}
		  
		    /**
			 * @param sign the sign to set
			 */  
		    
		public void setSign(String sign) {
			this.sign = sign;
		}
			/**
			 * @return the trade_mode
			 */
			
			public String getTrade_mode() {
				return trade_mode;
			}
			/**
			 * @param trade_mode the trade_mode to set
			 */
			
			public void setTrade_mode(String trade_mode) {
				this.trade_mode = trade_mode;
			}
			/**
			 * @return the trade_state
			 */
			
			public String getTrade_state() {
				return trade_state;
			}
			/**
			 * @param trade_state the trade_state to set
			 */
			
			public void setTrade_state(String trade_state) {
				this.trade_state = trade_state;
			}
			/**
			 * @return the pay_info
			 */
			
			public String getPay_info() {
				return pay_info;
			}
			/**
			 * @param pay_info the pay_info to set
			 */
			
			public void setPay_info(String pay_info) {
				this.pay_info = pay_info;
			}
			/**
			 * @return the trans_channel
			 */
			
			public String getTrans_channel() {
				return trans_channel;
			}
			/**
			 * @param trans_channel the trans_channel to set
			 */
			
			public void setTrans_channel(String trans_channel) {
				this.trans_channel = trans_channel;
			}
			/**
			 * @return the partner
			 */
			
			public String getPartner() {
				return partner;
			}
			/**
			 * @param partner the partner to set
			 */
			
			public void setPartner(String partner) {
				this.partner = partner;
			}
			/**
			 * @return the subpartner
			 */
			
			public String getSubpartner() {
				return subpartner;
			}
			/**
			 * @param subpartner the subpartner to set
			 */
			
			public void setSubpartner(String subpartner) {
				this.subpartner = subpartner;
			}
			/**
			 * @return the bank_type
			 */
			
			public String getBank_type() {
				return bank_type;
			}
			/**
			 * @param bank_type the bank_type to set
			 */
			
			public void setBank_type(String bank_type) {
				this.bank_type = bank_type;
			}
			/**
			 * @return the bank_transno
			 */
			
			public String getBank_transno() {
				return bank_transno;
			}
			/**
			 * @param bank_transno the bank_transno to set
			 */
			
			public void setBank_transno(String bank_transno) {
				this.bank_transno = bank_transno;
			}
			/**
			 * @return the total_fee
			 */
			
			public String getTotal_fee() {
				return total_fee;
			}
			/**
			 * @param total_fee the total_fee to set
			 */
			
			public void setTotal_fee(String total_fee) {
				this.total_fee = total_fee;
			}
			/**
			 * @return the fee_type
			 */
			
			public String getFee_type() {
				return fee_type;
			}
			/**
			 * @param fee_type the fee_type to set
			 */
			
			public void setFee_type(String fee_type) {
				this.fee_type = fee_type;
			}
			/**
			 * @return the notify_id
			 */
			
			public String getNotify_id() {
				return notify_id;
			}
			/**
			 * @param notify_id the notify_id to set
			 */
			
			public void setNotify_id(String notify_id) {
				this.notify_id = notify_id;
			}
			/**
			 * @return the time_end
			 */
			
			public String getTime_end() {
				return time_end;
			}
			/**
			 * @param time_end the time_end to set
			 */
			
			public void setTime_end(String time_end) {
				this.time_end = time_end;
			}
			/**
			 * @return the transport_fee
			 */
			
			public Float getTransport_fee() {
				return transport_fee;
			}
			/**
			 * @param transport_fee the transport_fee to set
			 */
			
			public void setTransport_fee(Float transport_fee) {
				this.transport_fee = transport_fee;
			}
			/**
			 * @return the product_fee
			 */
			
			public Float getProduct_fee() {
				return product_fee;
			}
			/**
			 * @param product_fee the product_fee to set
			 */
			
			public void setProduct_fee(Float product_fee) {
				this.product_fee = product_fee;
			}
			/**
			 * @return the discount
			 */
			
			public Float getDiscount() {
				return discount;
			}
			/**
			 * @param discount the discount to set
			 */
			
			public void setDiscount(Float discount) {
				this.discount = discount;
			}
			/**
			 * @return the buyer_alias
			 */
			
			public String getBuyer_alias() {
				return buyer_alias;
			}
			/**
			 * @param buyer_alias the buyer_alias to set
			 */
			
			public void setBuyer_alias(String buyer_alias) {
				this.buyer_alias = buyer_alias;
			}
			/**
			 * @return the attach
			 */
			
			public String getAttach() {
				return attach;
			}
			/**
			 * @param attach the attach to set
			 */
			
			public void setAttach(String attach) {
				this.attach = attach;
			}
			/**
			 * @return the retcode
			 */
			public String getRetcode() {
				return retcode;
			}
			/**
			 * @param retcode the retcode to set
			 */
			public void setRetcode(String retcode) {
				this.retcode = retcode;
			}
			
			/**
			 * @return the retmsg
			 */
			public String getRetmsg() {
				return retmsg;
			}
			/**
			 * @param retmsg the retmsg to set
			 */
			public void setRetmsg(String retmsg) {
				this.retmsg = retmsg;
			}
			/**
			 * @return the out_refund_no
			 */
			public String getOut_refund_no() {
				return out_refund_no;
			}
			/**
			 * @param out_refund_no the out_refund_no to set
			 */
			public void setOut_refund_no(String out_refund_no) {
				this.out_refund_no = out_refund_no;
			}
			/**
			 * @return the refund_id
			 */
			public String getRefund_id() {
				return refund_id;
			}
			/**
			 * @param refund_id the refund_id to set
			 */
			public void setRefund_id(String refund_id) {
				this.refund_id = refund_id;
			}
			/**
			 * @return the refund_channel
			 */
			public String getRefund_channel() {
				return refund_channel;
			}
			/**
			 * @param refund_channel the refund_channel to set
			 */
			public void setRefund_channel(String refund_channel) {
				this.refund_channel = refund_channel;
			}
			/**
			 * @return the refund_fee
			 */
			public String getRefund_fee() {
				return refund_fee;
			}
			/**
			 * @param refund_fee the refund_fee to set
			 */
			public void setRefund_fee(String refund_fee) {
				this.refund_fee = refund_fee;
			}
			/**
			 * @return the refund_status
			 */
			public String getRefund_status() {
				return refund_status;
			}
			/**
			 * @param refund_status the refund_status to set
			 */
			public void setRefund_status(String refund_status) {
				this.refund_status = refund_status;
			}
			/**
			 * @return the recv_user_id
			 */
			public String getRecv_user_id() {
				return recv_user_id;
			}
			/**
			 * @param recv_user_id the recv_user_id to set
			 */
			public void setRecv_user_id(String recv_user_id) {
				this.recv_user_id = recv_user_id;
			}
			/**
			 * @return the reccv_user_name
			 */
			public String getReccv_user_name() {
				return reccv_user_name;
			}
			/**
			 * @param reccv_user_name the reccv_user_name to set
			 */
			public void setReccv_user_name(String reccv_user_name) {
				this.reccv_user_name = reccv_user_name;
			}
			/**
			 * @return the refund_state
			 */
			public String getRefund_state() {
				return refund_state;
			}
			/**
			 * @param refund_state the refund_state to set
			 */
			public void setRefund_state(String refund_state) {
				this.refund_state = refund_state;
			}
			/**
			 * @return the clear_state
			 */
			public String getClear_state() {
				return clear_state;
			}
			/**
			 * @param clear_state the clear_state to set
			 */
			public void setClear_state(String clear_state) {
				this.clear_state = clear_state;
			}
			/**
			 * @return the trade_type
			 */
			public String getTrade_type() {
				return trade_type;
			}
			/**
			 * @param trade_type the trade_type to set
			 */
			public void setTrade_type(String trade_type) {
				this.trade_type = trade_type;
			}
			/**
			 * @return the is_split
			 */
			public boolean isIs_split() {
				return is_split;
			}
			/**
			 * @param is_split the is_split to set
			 */
			public void setIs_split(boolean is_split) {
				this.is_split = is_split;
			}
			/**
			 * @return the platCharge
			 */
			public float getPlatCharge() {
				return platCharge;
			}
			/**
			 * @param platCharge the platCharge to set
			 */
			public void setPlatCharge(float platCharge) {
				this.platCharge = platCharge;
			}
			/**
			 * @return the subPlatCharge
			 */
			public float getSubPlatCharge() {
				return subPlatCharge;
			}
			/**
			 * @param subPlatCharge the subPlatCharge to set
			 */
			public void setSubPlatCharge(float subPlatCharge) {
				this.subPlatCharge = subPlatCharge;
			}
			
			/**
			 * @return the qr_url
			 */
			public String getQr_url() {
				return qr_url;
			}
			/**
			 * @param qr_url the qr_url to set
			 */
			public void setQr_url(String qr_url) {
				this.qr_url = qr_url;
			}
			/**
			 * @return the terminalNo
			 */
			public String getTerminalNo() {
				return terminalNo;
			}
			/**
			 * @param terminalNo the terminalNo to set
			 */
			public void setTerminalNo(String terminalNo) {
				this.terminalNo = terminalNo;
			}
	
	

}
