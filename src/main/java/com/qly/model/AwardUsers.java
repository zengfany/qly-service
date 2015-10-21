package com.qly.model;

import com.qly.util.MyDateUtil;


/**
 * 奖励 与 用户关联表
 * @author spykerccc
 *
 */
public class AwardUsers {
	private Long award_users_id		;//` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '奖品记录id',
	private Long get_time				;//` bigint(30) unsigned NOT NULL DEFAULT '0' COMMENT '领取时间',
	private Long goods_id 			;//关联商品id
	private String openid ;
	private Integer is_use ; //是否使用
	private Long use_time ; //使用时间
	private String code_sn; //验证码
	private Long event_award_id;
	private Long award_id ; 
	private Long verifier_id ;		//核销人员id
	
	/**以下字段 不存数据库****/
	private String goods_name; 
	
	
	
	/**
	 * 使用时间 描述
	 * @return
	 */
	public String getUse_timeStr(){
		if(this.use_time!=null){
			return MyDateUtil.dbTimerToFmtShowTime(this.use_time);
		}else{
			return "NOTHING";
		}
	}
	
	/**
	 * 获取时间描述
	 * @return
	 */
	public String getGet_timeStr(){
		if(this.get_time!=null){
			return MyDateUtil.dbTimerToFmtShowTime(this.get_time);
		}else{
			return "NOTHING";
		}
	}
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	/*****/
	public Long getAward_users_id() {
		return award_users_id;
	}
	public void setAward_users_id(Long award_users_id) {
		this.award_users_id = award_users_id;
	}
	
	public Long getGet_time() {
		return get_time;
	}
	public void setGet_time(Long get_time) {
		this.get_time = get_time;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
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
	public String getCode_sn() {
		return code_sn;
	}
	public void setCode_sn(String code_sn) {
		this.code_sn = code_sn;
	}
	public Long getEvent_award_id() {
		return event_award_id;
	}
	public void setEvent_award_id(Long event_award_id) {
		this.event_award_id = event_award_id;
	}
	public Long getAward_id() {
		return award_id;
	}
	public void setAward_id(Long award_id) {
		this.award_id = award_id;
	}

	public Long getVerifier_id() {
		return verifier_id;
	}

	public void setVerifier_id(Long verifier_id) {
		this.verifier_id = verifier_id;
	}
	
}
