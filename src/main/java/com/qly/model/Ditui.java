package com.qly.model;

public class Ditui {
	private Long		ditui_id		;//mediumint	20	0	0		地推人员id	0	0	0
	private String		name			;//varchar	100	0	1		姓名			0
	private Integer		sex				;//int	2	0	1	0	性别 0男 1女	0	0	0
	private String		phone			;//varchar	20	0	1		手机号			0
	private String		url				;//varchar	200	0	1		推广url			0
	private String		ercode_path		;//varchar	200	0	1		推广二维码地址			0
	private String		ticket			;//varchar	200	0	1		获取 二维码 票据			0
	private Long		admin_user_id	;//mediumint	20	0	1		地推主管id	0	0	0
	
	private Long create_time = null; //	bigint	80	0	-1	0	0	0	0		0	创建时间				0	0
	private Long update_timne = null; //	bigint	80	0	-1	0	0	0	0		0	更新时间				0	0
	private Integer del_flag = null; //	smallint	1	0	-1	0	0	0	0	1	0	是否删除 0 删除 1 未删除				0	0

	
	
	public Long getDitui_id() {
		return ditui_id;
	}
	public void setDitui_id(Long ditui_id) {
		this.ditui_id = ditui_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getErcode_path() {
		return ercode_path;
	}
	public void setErcode_path(String ercode_path) {
		this.ercode_path = ercode_path;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public Long getAdmin_user_id() {
		return admin_user_id;
	}
	public void setAdmin_user_id(Long admin_user_id) {
		this.admin_user_id = admin_user_id;
	}
	public Long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}
	public Long getUpdate_timne() {
		return update_timne;
	}
	public void setUpdate_timne(Long update_timne) {
		this.update_timne = update_timne;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	
	
}
