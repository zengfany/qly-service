package com.qly.model;

import com.qly.util.MyDateUtil;

public class Coupons {
	private Long   coupons_id			;//` mediumint(8) NOT NULL AUTO_INCREMENT  COMMENT '优惠券id',
	private String coupons_name ; 			//优惠券名称
	private Integer   coupons_type			;//` smallint(1) DEFAULT '1' COMMENT '类型 0  代金券 ，1 畅玩卡',
	private Double   money				;//` double(10,2) DEFAULT '0.00' COMMENT '抵用的金额',
	private Integer   validity_day			;//` int(20) DEFAULT '7' COMMENT  '有效期 天数， 从领取之日开始计算 单位天' ,
	private Long   add_time				;//` bigint(20) NOT NULL COMMENT '创建时间',
	private Integer   del_flag				;//` smallint(1) DEFAULT '1' COMMENT '0 删除 1 未删除',
	
	/**此处与数据库 不对应 ,用于 页面显示***/
		
	public String getAddTimeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(this.add_time);
	}
	
	/*****/
	
	public Long getCoupons_id() {
		return coupons_id;
	}
	public void setCoupons_id(Long coupons_id) {
		this.coupons_id = coupons_id;
	}
	public Integer getCoupons_type() {
		return coupons_type;
	}
	public void setCoupons_type(Integer coupons_type) {
		this.coupons_type = coupons_type;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getValidity_day() {
		return validity_day;
	}
	public void setValidity_day(Integer validity_day) {
		this.validity_day = validity_day;
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
	public String getCoupons_name() {
		return coupons_name;
	}
	public void setCoupons_name(String coupons_name) {
		this.coupons_name = coupons_name;
	}
	
	
	
}
