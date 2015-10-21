package com.qly.model;
/**
 * 商家图册
 * @author qys
 * @date 2015年8月10日 上午11:59:19
 */
public class VenderAtlas {
	
	private Long vender_atlas_id = null; //	int	11	0	0	-1	0	0	0		0	图册主键				-1	0
	private Long vender_id = null; //int	11	0	0	0	0	0	0		0	商家ID				0	0
	private String img_path = null; //varchar	255	0	-1	0	0	0	0		0	商家图册路径	utf8	utf8_unicode_ci		0	0
	private Integer del_flag = null; // 0 删除 1 未删除
	
	public Long getVender_atlas_id() {
		return vender_atlas_id;
	}
	public void setVender_atlas_id(Long vender_atlas_id) {
		this.vender_atlas_id = vender_atlas_id;
	}
	public Long getVender_id() {
		return vender_id;
	}
	public void setVender_id(Long vender_id) {
		this.vender_id = vender_id;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}

}
