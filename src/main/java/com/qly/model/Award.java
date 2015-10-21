package com.qly.model;

/**
 * 活动奖励
 * @author spykerccc
 *
 */
public class Award {
	private Long award_id		;//` mediumint(8) unsigned NOT NULL AUTO_INCREMENT COMMENT '奖品id',
	private Long event_award_id ;//抽奖活动id
	private Integer weight			;//` int(10) NOT NULL DEFAULT '1' COMMENT '发放权重',
	private Long goods_id		;//` varchar(200) DEFAULT NULL COMMENT '关联商品id',
	private Integer del_flag		;//` smallint(1) DEFAULT '1' COMMENT '删除标记 0 删除 1未删除' ,
	private Integer is_use			;//`  smallint(1) DEFAULT '1' COMMENT '是否启用 0 否 1 是' ,
	private String award_info		;//` varchar(200) COMMENT '奖品描述',
	private Long add_time 			;//数据录入时间
	private String goods_name	;//对应商名称
	
	
	public Long getAward_id() {
		return award_id;
	}
	public void setAward_id(Long award_id) {
		this.award_id = award_id;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
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
	public String getAward_info() {
		return award_info;
	}
	public void setAward_info(String award_info) {
		this.award_info = award_info;
	}
	public Long getEvent_award_id() {
		return event_award_id;
	}
	public void setEvent_award_id(Long event_award_id) {
		this.event_award_id = event_award_id;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

}
