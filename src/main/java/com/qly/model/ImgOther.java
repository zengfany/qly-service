package com.qly.model;

import com.qly.util.MyDateUtil;

/**
 * 图片管理(首页背景, 轮播等)
 * @author qys
 * @date 2015年8月11日 下午7:06:35
 */
public class ImgOther {
	
	private Long img_id	 = null;//int	11	0	0	-1	0	0	0		0	主键ID				-1	0
	private String img_path = null;//	varchar	255	0	-1	0	0	0	0		0	图片存储路径	utf8	utf8_unicode_ci		0	0
	private String img_url	 = null;//varchar	255	0	-1	0	0	0	0		0	跳转路径	utf8	utf8_unicode_ci		0	0
	private Integer img_type = null;//	int	1	0	-1	0	0	0	0	0	0	图片类型1 首页背景图片 0 轮播图片				0	0
	private Integer del_flag = null;//	smallint	1	0	-1	0	0	0	0	1	0	是否删除 0 删除 1 未删除				0	0
	private Integer img_sort = null; // 排序字段，数值越大，排序越靠前
	private Long add_time = null; // 添加时间
	private Long update_time = null; // 修改时间
	
	public Long getImg_id() {
		return img_id;
	}
	public void setImg_id(Long img_id) {
		this.img_id = img_id;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public Integer getImg_type() {
		return img_type;
	}
	public void setImg_type(Integer img_type) {
		this.img_type = img_type;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Integer getImg_sort() {
		return img_sort;
	}
	public void setImg_sort(Integer img_sort) {
		this.img_sort = img_sort;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public String getAdd_timeStr(){
		return MyDateUtil.dbTimeToFmtShowSimpleIsDay(this.add_time);
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	public String getUpdate_timeStr(){
		return MyDateUtil.dbTimeToFmtShowSimpleIsDay(this.update_time);
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	
}
