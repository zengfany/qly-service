package com.qly.model;

/**
 * BkShopWeb
 * @author qys
 * 上午03:15:35
 * 活动报名的照片存放
 */
public class ErPhoto {
	
	private Long er_photo_id = null; // ID 主键
	
	private Long er_event_reg_id = null; // 活动报名表的ID
	
	private String er_photo_path = null; // 照片存放路径
	
	private com.qly.model.EventReg eventReg = null; // 所属的报名提交表单
	private Integer is_cover ; 
	public com.qly.model.EventReg getEventReg() {
		return eventReg;
	}

	public void setEventReg(com.qly.model.EventReg eventReg) {
		this.eventReg = eventReg;
	}

	public Long getEr_photo_id() {
		return er_photo_id;
	}

	public void setEr_photo_id(Long erPhotoId) {
		er_photo_id = erPhotoId;
	}

	public Long getEr_event_reg_id() {
		return er_event_reg_id;
	}

	public void setEr_event_reg_id(Long erEventRegId) {
		er_event_reg_id = erEventRegId;
	}

	public String getEr_photo_path() {
		return er_photo_path;
	}

	public void setEr_photo_path(String erPhotoPath) {
		er_photo_path = erPhotoPath;
	}

	public Integer getIs_cover() {
		return is_cover;
	}

	public void setIs_cover(Integer is_cover) {
		this.is_cover = is_cover;
	}

	
}
