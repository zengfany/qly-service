package com.qly.model;

import com.qly.util.MyDateUtil;
import com.qly.util.MyStringUtil;


/**
 * 活动报名类型
 * @author spykerccc
 *
 */
public class EventRegType {


	private Long event_reg_type_id	;//` mediumint(100) NOT NULL COMMENT '表单类型id',
	private String title				;//`  varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '表单title' ,
	private Long add_time			;//` bigint(30) NOT NULL COMMENT '创建时间'
	private Integer del_flag 	;//删除标记 0 删除  1存在
	private String info_url ; //活动规则url
	private Integer is_jump_vote; // 1 跳转到投票页面 0 跳转到我的活动页面
	private String info_img ; 
	private String face_img ; //列表封面图片
	
	private Long event_reg_category_id ; //活动报名类别 id
	
	private Long	begin_time ;//	bigint	50	0	1		活动开始时间	0	0	0
	private Long 	end_time;//	bigint	50	0	1		活动结束时间	0	0	0
	private String	event_desc	;//varchar	1000	0	1		活动简短描述			0
	private String event_txt; // 活动详情
	/**以下字段 与数据库 无关***/
	private Integer reg_count ; //报名数
	
	
	public Integer getReg_count() {
		return reg_count;
	}

	public void setReg_count(Integer reg_count) {
		this.reg_count = reg_count;
	}

	public Integer sum_vote_count ; //投票总数
	
	
	public Integer getSum_vote_count() {
		return sum_vote_count;
	}

	public void setSum_vote_count(Integer sum_vote_count) {
		this.sum_vote_count = sum_vote_count;
	}

	/**
	 * 添加时间 格式化
	 * @return
	 */
	public String getAdd_timeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(add_time);
	}
	
	
	public String getBegin_timeStr(){
		if(this.begin_time!=null&&this.begin_time>0l){
			return MyDateUtil.dbTimeToFmtShowSimpleIsDay(this.begin_time);
		}else{
			return "NOTHONG";
		}
	}
	
	public String getEnd_timeStr(){
		if(this.end_time!=null&&this.end_time>0l){
			return MyDateUtil.dbTimeToFmtShowSimpleIsDay(this.end_time);
		}else{
			return "NOTHONG";
		}
	}
	
	
	public String getEvent_descSimple(){
		if(this.event_desc!=null){
			return MyStringUtil.omitStr(this.event_desc, 8);
		}else{
			return ""; 
		}
	}
	
	/*****/
	
	public Long getEvent_reg_type_id() {
		return event_reg_type_id;
	}
	public void setEvent_reg_type_id(Long event_reg_type_id) {
		this.event_reg_type_id = event_reg_type_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

	public String getInfo_url() {
		return info_url;
	}

	public void setInfo_url(String info_url) {
		this.info_url = info_url;
	}

	public String getInfo_img() {
		return info_img;
	}

	public void setInfo_img(String info_img) {
		this.info_img = info_img;
	}

	public Long getEvent_reg_category_id() {
		return event_reg_category_id;
	}

	public void setEvent_reg_category_id(Long event_reg_category_id) {
		this.event_reg_category_id = event_reg_category_id;
	}

	public Long getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(Long begin_time) {
		this.begin_time = begin_time;
	}

	public Long getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}

	public String getEvent_desc() {
		return event_desc;
	}

	public void setEvent_desc(String event_desc) {
		this.event_desc = event_desc;
	}

	public String getFace_img() {
		return face_img;
	}

	public void setFace_img(String face_img) {
		this.face_img = face_img;
	}

	public String getEvent_txt() {
		return event_txt;
	}

	public void setEvent_txt(String event_txt) {
		this.event_txt = event_txt;
	}

	public Integer getIs_jump_vote() {
		return is_jump_vote;
	}

	public void setIs_jump_vote(Integer is_jump_vote) {
		this.is_jump_vote = is_jump_vote;
	}
	
}
