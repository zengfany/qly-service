package com.qly.model;

import com.qly.util.MyDateUtil;

/**
 * 公告
 * @author spykerccc
 *
 */
public class Notice {
	private Long notice_id	 = null; //mediumint	8	0	0	-1	0	0	0		0	主键ID				-1	0
	private String notice_name	 = null; //varchar	255	0	0	0	0	0	0		0	公告名称	utf8	utf8_general_ci		0	0
	private String notice_url	 = null; //varchar	255	0	-1	0	0	0	0		0	跳转地址	utf8	utf8_general_ci		0	0
	private Integer del_flag	 = null; //smallint	1	0	-1	0	0	0	0	1	0	是否删除 0 删除 1 未删除				0	0
	private Long add_time	 = null; //bigint	60	0	-1	0	0	0	0		0	创建时间				0	0
	private Long update_time	 = null; //bigint	60	0	-1	0	0	0	0		0	更新时间				0	0
	public Long getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Long notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_name() {
		return notice_name;
	}
	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}
	public String getNotice_url() {
		return notice_url;
	}
	public void setNotice_url(String notice_url) {
		this.notice_url = notice_url;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Long getAdd_time() {
		return add_time;
	}
	/**
	 * 对应页面显示
	 * @author qys
	 * @date 2015年8月16日 上午9:30:22
	 * @return
	 */
	public String getAdd_timeStr(){
		return MyDateUtil.dbTimerToFmtShowMin(add_time);
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	/**
	 * 对应页面显示
	 * @author qys
	 * @date 2015年8月16日 上午9:30:50
	 * @return
	 */
	public String getUpdate_timeStr(){
		return MyDateUtil.dbTimerToFmtShowMin(update_time);
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	
	

}
