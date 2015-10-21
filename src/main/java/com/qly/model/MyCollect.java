package com.qly.model;

import com.qly.util.MyDateUtil;

/**
 * 我的收藏
 * @author qys
 * @date 2015年8月14日 下午8:36:46
 */
public class MyCollect {
	private Long my_collect_id	 = null; // int	11	0	0	-1	-1	0	0		0	主键				-1	0
	private Long user_id			 = null; // int	11	0	-1	0	0	0	0		0	用户ID				0	0
	private Long goods_id		 = null; // int	11	0	-1	0	0	0	0		0	商品ID				0	0
	private Long add_time		 = null; // bigint	60	0	-1	0	0	0	0		0	收藏时间				0	0
	private Long update_time		 = null; // bigint	60	0	-1	0	0	0	0		0	修改时间				0	0
	private Integer collect_state	 = null; // int	2	0	-1	0	0	0	0	0	0	收藏状态(0 未收藏，1 已收藏)				0	0

	/** 以下字段不和数据库对应 */
	private String goods_name = null; // 商品名称
	private String market_price = null; // 商品的市场售价，取值bk_goods 
	private Double shop_price = null; // 商品的本店售价，取值bk_goods
	private Integer is_on_sale = null; // 该商品是否开放销售，1，是；0，否
	private String goods_img = null; // 商品图片
	
	public Long getMy_collect_id() {
		return my_collect_id;
	}
	public void setMy_collect_id(Long my_collect_id) {
		this.my_collect_id = my_collect_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public String getAdd_timeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(this.add_time);
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	public Integer getCollect_state() {
		return collect_state;
	}
	public void setCollect_state(Integer collect_state) {
		this.collect_state = collect_state;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public Integer getIs_on_sale() {
		return is_on_sale;
	}
	public void setIs_on_sale(Integer is_on_sale) {
		this.is_on_sale = is_on_sale;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goods_img) {
		this.goods_img = goods_img;
	}
	
}
