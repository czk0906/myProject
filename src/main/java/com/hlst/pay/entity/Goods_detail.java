/**   
* @Title: Goods_detail.java 
* @Package com.platform.request.json 
* @Description: TODO(用一句话描述该文件做什么) 
* @author kiosk
* @date 2017年8月29日 下午5:57:18 
* @version V1.0   
*/
package com.hlst.pay.entity;

import java.io.Serializable;

/** 
* @ClassName: Goods_detail 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author kiosk
* @date 2017年8月29日 下午5:57:18 
*  
*/
public class Goods_detail implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -7002966346995801188L;
	
	private String goods_id;
	private String goods_name;
	private String goods_category;
	private String price;
	private String quantity;
	/**
	 * @return the goods_id
	 */
	public String getGoods_id() {
		return goods_id;
	}
	/**
	 * @param goods_id the goods_id to set
	 */
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	/**
	 * @return the goods_name
	 */
	public String getGoods_name() {
		return goods_name;
	}
	/**
	 * @param goods_name the goods_name to set
	 */
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	/**
	 * @return the goods_category
	 */
	public String getGoods_category() {
		return goods_category;
	}
	/**
	 * @param goods_category the goods_category to set
	 */
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
