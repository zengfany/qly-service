package com.qly.model;

public class VoteInfo {
	  private Long vote_info_id		;// mediumint(8) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	  private String open_id			;// varchar(60) NOT NULL COMMENT '微信open_id',
	  private String ip				;// varchar(60) DEFAULT '0' COMMENT '投票时所使用的ip',
	  private Long event_reg_type_id	;// mediumint(8) DEFAULT NULL COMMENT '活动类型',
	  private Long event_reg_id			;// mediumint(8) DEFAULT NULL COMMENT '报名id',
	  private Long add_time			;// bigint(20) NOT NULL COMMENT '创建时间',
	  private Integer del_flag			;// smallint(1) DEFAULT '1' COMMENT '是否删除 0 删除 1 未删除', 
	public Long getVote_info_id() {
		return vote_info_id;
	}
	public void setVote_info_id(Long vote_info_id) {
		this.vote_info_id = vote_info_id;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Long getEvent_reg_type_id() {
		return event_reg_type_id;
	}
	public void setEvent_reg_type_id(Long event_reg_type_id) {
		this.event_reg_type_id = event_reg_type_id;
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
	public Long getEvent_reg_id() {
		return event_reg_id;
	}
	public void setEvent_reg_id(Long event_reg_id) {
		this.event_reg_id = event_reg_id;
	}
	  
	  

}
