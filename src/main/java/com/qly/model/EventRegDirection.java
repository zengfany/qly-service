package com.qly.model;

public class EventRegDirection {
	private Long   event_reg_direction_id			;//` mediumint(100) NOT NULL AUTO_INCREMENT COMMENT 'ID自增',
	private String   name								;//` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '表单类型',
	private Integer is_judges; // 	int	11	0	-1	0	0	0	0	0	0	0 不是评委 1 评委				0	0
	private Long   add_time							;//` bigint(50) DEFAULT NULL COMMENT '创建时间',
	private Long   del_flag							;//` int(1) DEFAULT '1' COMMENT '删除标记 0删除  1存在',
	private Long   event_reg_type_id				;//` mediumint(100) DEFAULT '-1' COMMENT '活动类别id',
	public Long getEvent_reg_direction_id() {
		return event_reg_direction_id;
	}
	public void setEvent_reg_direction_id(Long event_reg_direction_id) {
		this.event_reg_direction_id = event_reg_direction_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIs_judges() {
		return is_judges;
	}
	public void setIs_judges(Integer is_judges) {
		this.is_judges = is_judges;
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
	public Long getEvent_reg_type_id() {
		return event_reg_type_id;
	}
	public void setEvent_reg_type_id(Long event_reg_type_id) {
		this.event_reg_type_id = event_reg_type_id;
	}
	
}
