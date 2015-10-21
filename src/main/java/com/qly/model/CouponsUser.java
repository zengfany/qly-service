package com.qly.model;

public class CouponsUser {
	 private Long  coupons_user_id		;// mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	 private Long  coupons_id			;//  mediumint(8)  COMMENT '优惠券id',
	 private Long  user_id				;//  mediumint(8)  COMMENT '用户id',
	 private Long  validity_time		;// bigint(20) NOT NULL COMMENT  '到期时间' ,
	 private Long  goods_id				;//  mediumint(8)  COMMENT '所使用的商品id',
	 private Integer  is_use				;// smallint(1) DEFAULT '0' COMMENT '是否使用 0 否 1 是',
	 private Long  use_time				;// bigint(20)  COMMENT '使用时间',
	 private Long  add_time				;// bigint(20) NOT NULL COMMENT '创建时间',
	 private Integer  del_flag				;// smallint(1) DEFAULT '1' COMMENT '0 删除 1 未删除',
	public Long getCoupons_user_id() {
		return coupons_user_id;
	}
	public void setCoupons_user_id(Long coupons_user_id) {
		this.coupons_user_id = coupons_user_id;
	}
	public Long getCoupons_id() {
		return coupons_id;
	}
	public void setCoupons_id(Long coupons_id) {
		this.coupons_id = coupons_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getValidity_time() {
		return validity_time;
	}
	public void setValidity_time(Long validity_time) {
		this.validity_time = validity_time;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getIs_use() {
		return is_use;
	}
	public void setIs_use(Integer is_use) {
		this.is_use = is_use;
	}
	public Long getUse_time() {
		return use_time;
	}
	public void setUse_time(Long use_time) {
		this.use_time = use_time;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	 
}
