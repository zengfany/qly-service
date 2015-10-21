package com.qly.model;
/***
 * 收货地址
 * @author 孙强 spykerccc@sina.com
 *
 */
public class Address {
	  private Long address_id			;//` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '收货地址自增id',
	  private String sh_name				;//` smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '收货人姓名',
	  private Long user_id				;//` mediumint(255) DEFAULT NULL,
	  private String mobile				;//` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '收货人电话',
	  private String province				;//` varchar(255) DEFAULT NULL COMMENT '省',
	  private String city					;//` varchar(255) DEFAULT NULL COMMENT '城市',
	  private String region				;//` varchar(255) DEFAULT NULL COMMENT '地区',
	  private String address_info			;//` varchar(255) DEFAULT COMMENT '具体地址',
	  private String zip_code				;//` varchar(10)  COMMENT '邮编',
	  private Long add_time				;//` bigint(255) unsigned NOT NULL DEFAULT '0' COMMENT '商品的添加时间',
	  private Integer del_flag				;//` smallint(1) DEFAULT '1' COMMENT '0 删除 1 未删除',
	public Long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}
	public String getSh_name() {
		return sh_name;
	}
	public void setSh_name(String sh_name) {
		this.sh_name = sh_name;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getAddress_info() {
		return address_info;
	}
	public void setAddress_info(String address_info) {
		this.address_info = address_info;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
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
