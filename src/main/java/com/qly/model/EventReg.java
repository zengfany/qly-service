package com.qly.model;

import com.qly.util.MyDateUtil;

import java.util.List;

/**
 * BkShopWeb
 * @author qys
 * 上午03:10:07
 * 包名活动表
 */
public class EventReg {
	/*SELECT
	bk_event_reg.event_reg_id,
	bk_event_reg.baby_name,
	bk_event_reg.baby_sex,
	bk_event_reg.adderss,
	bk_event_reg.parents_phone,
	bk_event_reg.parents_email,
	bk_event_reg.photo_id,
	bk_event_reg.video_url,
	bk_event_reg.specialty
	FROM
	bk_event_reg*/
	
	private Long event_reg_id = null; // ID
	private Long user_id = null; // 关联用户表的ID
	private String openId = null; // 获取微信的ID
	private String baby_name = null; // 宝宝姓名
	private Integer baby_sex = null; // 宝宝性别
	private String adderss = null; // 家庭住址
	private String parents_phone = null; // 父母电话
	private String parents_email = null; // 父母的邮箱
	private String video_url = null; // 视频地址
	private String specialty = null; // 特长
	private String openid ; 
	private Long add_time ; 
	private Long event_reg_type_id; 
	private Integer hide_flag  ;  //0否 1是   --是否屏蔽(屏蔽后将不能参与投票)
	private Integer vote_count ; //投票数
	private Long event_reg_direction_id ; //报名方向
	private Integer age ; //宝贝年龄
	
	private Integer judges_experience	; // int	1	0	-1	0	0	0	0	0	0	是否有做过评委的经验 0 没有 1 有				0	0
	private Integer judges_competition	; // int	1	0	-1	0	0	0	0	0	0	是否有参赛的经验 0 没有 1 有				0	0
	private Integer judges_awards; // 	int	1	0	-1	0	0	0	0	0	0	有没在比赛中获奖 0 没有 1 有				0	0
	
	private Integer verify_flag = null; // 审核状态
	
	/***以下字段 不对应数据库***/
	private Integer photo_count	 ; 
	public Integer getPhoto_count() {
		return photo_count;
	}
	public void setPhoto_count(Integer photo_count) {
		this.photo_count = photo_count;
	}
	
	private String face_img_path ;  //封面图片路径
	
	
	
	
	// 照片存储的路径
	private List<ErPhoto> erPhotos = null;
	public List<ErPhoto> getErPhotos() {
		return erPhotos;
	}
	public void setErPhotos(List<ErPhoto> erPhotos) {
		this.erPhotos = erPhotos;
	}
	/***
	 * 报名时间 显示字段
	 * @return
	 */
	public String getAdd_timeStr(){
		return MyDateUtil.dbTimerToFmtShowMin(this.getAdd_time());
	}
	
	/*****/
	
	
	public Long getEvent_reg_id() {
		return event_reg_id;
	}
	public void setEvent_reg_id(Long eventRegId) {
		event_reg_id = eventRegId;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long userId) {
		user_id = userId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getBaby_name() {
		return baby_name;
	}
	public void setBaby_name(String babyName) {
		baby_name = babyName;
	}
	
	public Integer getBaby_sex() {
		return baby_sex;
	}
	public void setBaby_sex(Integer baby_sex) {
		this.baby_sex = baby_sex;
	}
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	public String getParents_phone() {
		return parents_phone;
	}
	public void setParents_phone(String parentsPhone) {
		parents_phone = parentsPhone;
	}
	public String getParents_email() {
		return parents_email;
	}
	public void setParents_email(String parentsEmail) {
		parents_email = parentsEmail;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String videoUrl) {
		video_url = videoUrl;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Long getEvent_reg_type_id() {
		return event_reg_type_id;
	}
	public void setEvent_reg_type_id(Long event_reg_type_id) {
		this.event_reg_type_id = event_reg_type_id;
	}
	public Integer getHide_flag() {
		return hide_flag;
	}
	public void setHide_flag(Integer hide_flag) {
		this.hide_flag = hide_flag;
	}
	public Integer getVote_count() {
		return vote_count;
	}
	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}
	public String getFace_img_path() {
		return face_img_path;
	}
	public void setFace_img_path(String face_img_path) {
		this.face_img_path = face_img_path;
	}
	public Long getEvent_reg_direction_id() {
		return event_reg_direction_id;
	}
	public void setEvent_reg_direction_id(Long event_reg_direction_id) {
		this.event_reg_direction_id = event_reg_direction_id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getVerify_flag() {
		return verify_flag;
	}
	public void setVerify_flag(Integer verify_flag) {
		this.verify_flag = verify_flag;
	}
	public Integer getJudges_experience() {
		return judges_experience;
	}
	public void setJudges_experience(Integer judges_experience) {
		this.judges_experience = judges_experience;
	}
	public Integer getJudges_competition() {
		return judges_competition;
	}
	public void setJudges_competition(Integer judges_competition) {
		this.judges_competition = judges_competition;
	}
	public Integer getJudges_awards() {
		return judges_awards;
	}
	public void setJudges_awards(Integer judges_awards) {
		this.judges_awards = judges_awards;
	}
	
}
