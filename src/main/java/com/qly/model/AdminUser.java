package com.qly.model;

import com.qly.util.MyDateUtil;

import java.io.Serializable;



//DROP TABLE IF EXISTS `bk_admin_user`;
//CREATE TABLE `bk_admin_user`  (
//`user_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID号，管理员代号',
//`user_name` varchar(60) NOT NULL COMMENT '管理员登录名',
//`email` varchar(60) NOT NULL COMMENT '管理员邮箱',
//`password` varchar(32) NOT NULL COMMENT '管理员登录秘密加密串',
//`add_time` int(11) NOT NULL DEFAULT '0'  COMMENT '管理员添加时间',
//`last_login` int(11) NOT NULL DEFAULT '0' COMMENT '管理员最后一次登录时间',
//`last_ip` varchar(15) NOT NULL COMMENT '管理员最后一次登录ip',
//`action_list` text NOT NULL COMMENT '管理员管理权限列表',
//PRIMARY KEY (`user_id`),
//KEY `user_name` (`user_name`)
//) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='购物车购物信息记录表' AUTO_INCREMENT=1 ;

public class AdminUser implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long user_id			;//` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID号，管理员代号',
	private String user_name		;//` varchar(60) NOT NULL COMMENT '管理员登录名',
	private String email			;//` varchar(60) NOT NULL COMMENT '管理员邮箱',
	private String password			;//` varchar(32) NOT NULL COMMENT '管理员登录秘密加密串',
	private Long add_time			;//` int(11) NOT NULL DEFAULT '0'  COMMENT '管理员添加时间',
	private Long last_login		;//` int(11) NOT NULL DEFAULT '0' COMMENT '管理员最后一次登录时间',
	private String last_ip			;//` varchar(15) NOT NULL COMMENT '管理员最后一次登录ip',
	
	private String action_list	 = null; //text	0	0	0	0	0	0	0		0	管理员管理权限列表	utf8	utf8_general_ci		-1	0
	private Integer is_disabled	= null; //int	1	0	-1	0	0	0	0		0	是否禁用				0	0
	private Long vender_id	= null; //int	11	0	-1	0	0	0	0		0	商家ID，外键				0	0
	private Integer del_flag	= null; //smallint	1	0	-1	0	0	0	0	1	0	是否删除 0 删除 1 未删除				0	0
	private Long update_time	= null; //int	60	0	-1	0	0	0	0		0	更新时间				0	0
	private Integer is_vender	= null; //int	11	0	-1	0	0	0	0	1	0	是否是商家登录帐号 1 是  0 超级管理员				0	0
	private Integer is_edit_vender_info =0  ; // 0	is_edit_vender_info	int	2	0	1	0	是否允许编辑商家信息 1 是 0 否 （只有在is_vender=1）时才有效	0	0	0
	
	private String name	 = null; // varchar	255	0	-1	0	0	0	0		0	姓名	utf8	utf8_general_ci		0	0
	private String idCard	 = null; // varchar	255	0	-1	0	0	0	0		0	身份证号	utf8	utf8_general_ci		0	0
	private String tell	 = null; // varchar	255	0	-1	0	0	0	0		0	电话	utf8	utf8_general_ci		0	0
	private String remark	 = null; // varchar	255	0	-1	0	0	0	0		0	备注	utf8	utf8_general_ci		0	0

	
	private String venderName = null; // 商家名称，不对应数据库字段

	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public String getAddTime(){
		return MyDateUtil.dbTimerToFmtShowTime(add_time);
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Long getLast_login() {
		return last_login;
	}
	public String getLastLogin(){
		return MyDateUtil.dbTimerToFmtShowTime(last_login);
	}
	public void setLast_login(Long last_login) {
		this.last_login = last_login;
	}
	public String getLast_ip() {
		return last_ip;
	}
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
	public String getAction_list() {
		return action_list;
	}
	public void setAction_list(String action_list) {
		this.action_list = action_list;
	}
	public Integer getIs_disabled() {
		return is_disabled;
	}
	public void setIs_disabled(Integer is_disabled) {
		this.is_disabled = is_disabled;
	}
	public Long getVender_id() {
		return vender_id;
	}
	public void setVender_id(Long vender_id) {
		this.vender_id = vender_id;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	public Integer getIs_vender() {
		return is_vender;
	}
	public void setIs_vender(Integer is_vender) {
		this.is_vender = is_vender;
	}
	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
	public Integer getIs_edit_vender_info() {
		return is_edit_vender_info;
	}
	public void setIs_edit_vender_info(Integer is_edit_vender_info) {
		this.is_edit_vender_info = is_edit_vender_info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
