package com.qly.model;

import com.qly.util.MyDateUtil;


/***
 * 活动分类表
 * @author 孙强 spykerccc@sina.com
 *
 */
public class EventRegCategory {
	 private Long  event_reg_category_id				;//` mediumint(100) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
	 private String  name								;//` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动类型',
	 private Long  add_time							;//` bigint(50) DEFAULT NULL COMMENT '创建时间',
	 private Long  del_flag							;//` int(1) DEFAULT '1' COMMENT '删除标记 0删除  1存在',
	 private Integer other_flag						;//` int(1) DEFAULT '0' COMMENT '为1时 所有没有分类的活动全都归类到此处',
	/**非数据库对应字段***/
	public String getAdd_timeStr(){
		if(this.add_time==null||this.add_time==0l){
			return "NOTHING" ;
		}else{
			return MyDateUtil.dbTimerToFmtShowTime(this.add_time);
		}
	}
	 
	/*****/
	 
	public Long getEvent_reg_category_id() {
		return event_reg_category_id;
	}
	public void setEvent_reg_category_id(Long event_reg_category_id) {
		this.event_reg_category_id = event_reg_category_id;
	}
	
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Long getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Long del_flag) {
		this.del_flag = del_flag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getOther_flag() {
		return other_flag;
	}

	public void setOther_flag(Integer other_flag) {
		this.other_flag = other_flag;
	}
}
