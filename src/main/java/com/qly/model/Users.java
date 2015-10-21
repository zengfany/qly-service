package com.qly.model;

import com.qly.util.MyDateUtil;
import com.qly.util.MyStringUtil;


/**
 * 会员表
 * @author admin
 *
 */
public class Users {
	  private Long user_id	;//` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '??????id',
	  private String openid		;//` varchar(200) NOT NULL COMMENT '	用户的唯一标识',
	  private String nickname	;//` varchar(200) NOT NULL COMMENT '用户昵称',
	  private Integer sex		;//` varchar(32) NOT NULL COMMENT '	用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
	  private Long reg_time	;//` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '注册时间，暂时存储为第一次购物时间',
	  private Long last_login	;//` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '最后登录时间',
	  private String province		;//` varchar(200) DEFAULT NULL COMMENT '用户个人资料填写的省份',
	  private String city			;//` varchar(200) DEFAULT NULL COMMENT '普通用户个人资料填写的城市',
	  private String country		;//` varchar(200) DEFAULT NULL COMMENT '国家',
	  private String headimgurl		;//` varchar(200) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
	  private String privilege		;//` varchar(200) DEFAULT NULL COMMENT '用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
	
	  private Long ditui_id ; // 0	ditui_id	mediumint	8	0	1		地推人员id	0	0	0
	  
	  private Integer  	use_ditui ; //	int	11	0	0		是否使用了 地推，0未使用 1 已经使用，（要在 ditui_id!=-1的情况下 判断）	0	0	0
	  
	  
	  
	  private Double lat	;//double	12	8	1		纬度	0	0
	  private Double lng ;//	double	12	8	1		经度	0	0
	/**以下字段并非 直接对应表**/
	  
	private String phone_num ; //取值 为 最后一次成功下单的手机号
	  
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	private Integer order_count ; //取值 成功下单次数
	
	public Integer getOrder_count() {
		return order_count;
	}
	public void setOrder_count(Integer order_count) {
		this.order_count = order_count;
	}
	/****/
	  
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Long getReg_time() {
		return reg_time;
	}
	public String getRegTimeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(reg_time);
	}
	public void setReg_time(Long reg_time) {
		this.reg_time = reg_time;
	}
	public Long getLast_login() {
		return last_login;
	}
	public String getLastLoginStr(){
		return MyDateUtil.dbTimerToFmtShowTime(last_login);
	}
	public void setLast_login(Long last_login) {
		this.last_login = last_login;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	
	public Long getDitui_id() {
		return ditui_id;
	}
	public void setDitui_id(Long ditui_id) {
		this.ditui_id = ditui_id;
	}
	public static void main(String[] args) {
		System.out.println(MyStringUtil.omitStr("1234890", 20));
	}
	public Integer getUse_ditui() {
		return use_ditui;
	}
	public void setUse_ditui(Integer use_ditui) {
		this.use_ditui = use_ditui;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	
}
