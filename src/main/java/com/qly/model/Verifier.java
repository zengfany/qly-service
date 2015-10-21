package com.qly.model;

import com.qly.util.MyDateUtil;

/**
 * BkShopWeb
 * @author qys
 * 上午12:21:58
 * 验证票据的用户表(用于验证是否使用的用户)
 */
public class Verifier {
	/*SELECT
	bk_verifier.verifier_id,
	bk_verifier.username,
	bk_verifier.pwd,
	bk_verifier.sex,
	bk_verifier.mobile,
	bk_verifier.create_time,
	bk_verifier.del_flag
	FROM
	bk_verifier*/
	
	private Long verifier_id   = null;  // ID
	private String username      = null;  // 用户名
	private String pwd           = null;  // 密码
	private Integer sex           = null;  // 性别
	private String mobile        = null;  // 手机号
	private Long create_time   = null;  // 创建时间(系统设置)
	private Integer del_flag       = null; // 是否删除 0 删除 1 未删除
	private Long vender_id	= null; //bigint	60	0	-1	0	0	0	0	'-1'	0	商家ID(核销人员所属商家ID)				0	0
	private Long update_time	= null; //bigint	60	0	-1	0	0	0	0		0	更新时间				0	0
	private Integer is_enable = null; //	int	2	0	-1	0	0	0	0		0	是否启用(0，启用 1 未启用)				0	0
	
	public Integer getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(Integer is_enable) {
		this.is_enable = is_enable;
	}
	public Long getVerifier_id() {
		return verifier_id;
	}
	public void setVerifier_id(Long verifierId) {
		verifier_id = verifierId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Long getCreate_time() {
		return create_time;
	}
	/**
	 * 页面显示
	 * @author qys
	 * @date 2015年8月18日 下午7:29:21
	 * @return
	 */
	public String getCreate_timeStr(){
		if (create_time == 0) {
			create_time = null;
		}
		return MyDateUtil.dbTimeToFmtShowSimpleIsDay(create_time);
	}
	public void setCreate_time(Long createTime) {
		create_time = createTime;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer delFlag) {
		del_flag = delFlag;
	}
	public Long getVender_id() {
		return vender_id;
	}
	public void setVender_id(Long vender_id) {
		this.vender_id = vender_id;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	/**
	 * 页面显示
	 * @author qys
	 * @date 2015年8月18日 下午7:29:28
	 * @return
	 */
	public String getUpdate_timeStr(){
		if (update_time == 0) {
			update_time = null;
		}
		return MyDateUtil.dbTimeToFmtShowSimpleIsDay(update_time);
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	
	
}
