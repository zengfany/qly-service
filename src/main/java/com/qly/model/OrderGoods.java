package com.qly.model;

import com.qly.util.MyDateUtil;

import java.text.DecimalFormat;

/**
 * BkShopWeb
 * @author qys
 * 上午03:21:25
 * 订单表
 */
public class OrderGoods {
	
	/*SELECT
		bk_order_goods.order_goods_id,
		bk_order_goods.order_sn,
		bk_order_goods.goods_id,
		bk_order_goods.goods_name,
		bk_order_goods.goods_sn,
		bk_order_goods.goods_number,
		bk_order_goods.goods_amount,
		bk_order_goods.market_price,
		bk_order_goods.goods_price,
		bk_order_goods.pay_status,
		bk_order_goods.user_id,
		bk_order_goods.is_send,
		bk_order_goods.mobile,
		bk_order_goods.pay_time,
		bk_order_goods.add_time,
		bk_order_goods.pay_fee
	FROM
		bk_order_goods*/
	
	private Long order_goods_id = null;  // 订单商品信息自增id
	private String order_sn = null;        // 订单号，唯一
	private Long goods_id = null;        // 商品的的id，取值表bk_goods 的goods_id
	private String goods_name = null;      // 商品的名称，取值表bk_goods
	private String goods_sn = null;        // 商品的唯一货号，取值bk_goods
	private Integer goods_number = null;    // 商品的购买数量
	private Double goods_amount = null;    // 商品总金额  支付时需要付款金额 ，应和 pay_fee 一致 ,付款前 赋值
	private Double market_price = null;    // 商品的市场售价，取值bk_goods 
	private Double goods_price = null;     // 商品的本店售价，取值bk_goods 
	private Integer pay_status = null;      // 支付状态；0，未付款；1，付款中；2，已付款 ， 10已失效
	private Long user_id = null;         // 用户ID
	private Integer is_send = null;         // 是否已发送短信，0，否；1，是
	private String mobile = null;          // 收货人的手机，用户页面填写
	private Long pay_time = null;        // 订单支付时间
	private Long add_time = null;        // 订单生成时间
	private Long end_time = null; 	//订单过期时间，默认为添加订单时间 +10分钟
	private Double pay_fee = null;         // 支付费用 实际支付金额 应和 goods_amount 一致，付款后 赋值
	private String nonce ; //订单签名 防止恶意篡改
	
	
	private Long	coupons_user_id ;//	mediumint	8	0	0		所使用的优惠券id	0	0	0
	private	Integer use_coupons	 ; //smallint	1	0	0	0	是否使用优惠券 0 否 1是	0	0	0
	private Integer	coupons_type;//	smallint	1	0	0	-1	所使用的优惠券类型	0	0	0
	
	private Double ori_fee	 ;// decimal	10	2	0		订单原价， 商品价格 * 商品数量， 是 未使用优惠券的价格	0	0
	
	
	private Long address_id ; //收货地址
	
	
	private Integer	is_ditui_goods	 ;//int	1	0	1	0	是否是 地推赠品 0 否 1是	0	0	0
	
	
	private Integer is_ditui_order ; // 是否 是 可以获取地推赠品的 订单
	
	/***以下字段 不对应表字段***/
	
	public String getGoods_amountStr(){
		DecimalFormat    df   = new DecimalFormat("######0.00");
		return df.format(this.getGoods_amount());
	}
	/******/
	
	
	public Long getOrder_goods_id() {
		return order_goods_id;
	}
	public void setOrder_goods_id(Long orderGoodsId) {
		order_goods_id = orderGoodsId;
	}
	public String getOrder_sn() {
		return order_sn;
	}
	public void setOrder_sn(String orderSn) {
		order_sn = orderSn;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goodsId) {
		goods_id = goodsId;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}
	public String getGoods_sn() {
		return goods_sn;
	}
	public void setGoods_sn(String goodsSn) {
		goods_sn = goodsSn;
	}
	public Integer getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(Integer goodsNumber) {
		goods_number = goodsNumber;
	}
	public Double getGoods_amount() {
		return goods_amount;
	}
	public void setGoods_amount(Double goodsAmount) {
		goods_amount = goodsAmount;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double marketPrice) {
		market_price = marketPrice;
	}
	public Double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Double goodsPrice) {
		goods_price = goodsPrice;
	}
	public Integer getPay_status() {
		return pay_status;
	}
	public void setPay_status(Integer payStatus) {
		pay_status = payStatus;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long userId) {
		user_id = userId;
	}
	public Integer getIs_send() {
		return is_send;
	}
	public void setIs_send(Integer isSend) {
		is_send = isSend;
	}
	public String getMobile() {
		return mobile;
	}
	
	public Long getPay_time() {
		return pay_time;
	}
	public String getPayTimeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(pay_time);
	}
	public void setPay_time(Long pay_time) {
		this.pay_time = pay_time;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public String getAddTimeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(add_time);
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Double getPay_fee() {
		return pay_fee;
	}
	public void setPay_fee(Double payFee) {
		pay_fee = payFee;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public Long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}
	public Long getCoupons_user_id() {
		return coupons_user_id;
	}
	public void setCoupons_user_id(Long coupons_user_id) {
		this.coupons_user_id = coupons_user_id;
	}
	public Integer getUse_coupons() {
		return use_coupons;
	}
	public void setUse_coupons(Integer use_coupons) {
		this.use_coupons = use_coupons;
	}
	public Integer getCoupons_type() {
		return coupons_type;
	}
	public void setCoupons_type(Integer coupons_type) {
		this.coupons_type = coupons_type;
	}
	public Double getOri_fee() {
		return ori_fee;
	}
	public void setOri_fee(Double ori_fee) {
		this.ori_fee = ori_fee;
	}
	public Long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}
	public Integer getIs_ditui_goods() {
		return is_ditui_goods;
	}
	public void setIs_ditui_goods(Integer is_ditui_goods) {
		this.is_ditui_goods = is_ditui_goods;
	}
	public Integer getIs_ditui_order() {
		return is_ditui_order;
	}
	public void setIs_ditui_order(Integer is_ditui_order) {
		this.is_ditui_order = is_ditui_order;
	}
	
}
