package com.qly.model;

import com.qly.util.MyDateUtil;

/**
 * 商家分类信息
 * @author qys
 * @date 2015年8月18日 下午4:31:14
 */
public class Category {
	private Long category_id		;// smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID号',
	private String category_name		;// varchar(90) NOT NULL COMMENT '分类名称',
	private Integer is_show			;// tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否在前台页面显示，1，显示；0，不显示',
	private Integer del_flag			;// smallint(1) DEFAULT '1' COMMENT '0 删除 1 未删除',
	private Double sort_flag ; //排序标记
	private Long add_time ; //创建时间
	
	private boolean is_selected; // 是否选中
	
	
	
	public boolean isIs_selected() {
		return is_selected;
	}

	public void setIs_selected(boolean is_selected) {
		this.is_selected = is_selected;
	}

	/**此处与数据库 不对应 ,用于 页面显示***/
	
	public String getAddTimeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(this.add_time);
	}
	
	/*****/
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public Integer getIs_show() {
		return is_show;
	}
	public void setIs_show(Integer is_show) {
		this.is_show = is_show;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Double getSort_flag() {
		return sort_flag;
	}
	public void setSort_flag(Double sort_flag) {
		this.sort_flag = sort_flag;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
}
