package com.qly.model;

/**
 * 抽奖活动
 * @author spykerccc
 *
 */
public class EventAward {
	private Long event_award_id				;//` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '抽奖活动id',
	private String title					;//` int(10) NOT NULL DEFAULT '1' COMMENT '活动标题',
	private String event_info				;//` varchar(200) DEFAULT NULL COMMENT '活动详细说明',
	private Integer del_flag				;//` smallint(1) DEFAULT '1' COMMENT '删除标记 0 删除 1未删除' ,
	private Integer is_use					;//`  smallint(1) DEFAULT '1' COMMENT '是否启用 0 否 1 是' ,
	private String award_limit				;//  奖励领取约束 格式为 day|2|1    每个微信账号  day:每天，year：每个活动周期|可以领取几次奖励 |0 设置了，1未设置   默认为每个微信号，每个活动周期可以领取一次奖励
	private Long begin_time;				;//活动起始时间 
	private Long end_time ;					;//活动结束时间 
	private Integer nothing_weight			;// 空奖比重
	private Long add_time ; 				;//数据录入时间
	private Long update_time; 				;//最后一次修改数据时间
	
	public Long getEvent_award_id() {
		return event_award_id;
	}
	public void setEvent_award_id(Long event_award_id) {
		this.event_award_id = event_award_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEvent_info() {
		return event_info;
	}
	public void setEvent_info(String event_info) {
		this.event_info = event_info;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Integer getIs_use() {
		return is_use;
	}
	public void setIs_use(Integer is_use) {
		this.is_use = is_use;
	}
	public String getAward_limit() {
		return award_limit;
	}
	public void setAward_limit(String award_limit) {
		this.award_limit = award_limit;
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
	public Integer getNothing_weight() {
		return nothing_weight;
	}
	public void setNothing_weight(Integer nothing_weight) {
		this.nothing_weight = nothing_weight;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	
}
