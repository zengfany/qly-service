package com.qly.model;
/***
 * 商品推荐表  （用于关联 商品 及 被推荐商品）
 * @author 孙强 spykerccc@sina.com
 *
 */
public class RcmdGoods {
	  private Long goods_id			;// smallint(5) unsigned NOT NULL DEFAULT '0' COMMENT '商品id',
	  private Long rcmd_goods_id	;// varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '被推荐商品id',
	  private Long add_time			;// bigint(255) unsigned NOT NULL DEFAULT '0' COMMENT '商品的添加时间',
	  private Integer sort_order		;// smallint(4) unsigned DEFAULT '0' COMMENT '显示排序',
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public Long getRcmd_goods_id() {
		return rcmd_goods_id;
	}
	public void setRcmd_goods_id(Long rcmd_goods_id) {
		this.rcmd_goods_id = rcmd_goods_id;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Integer getSort_order() {
		return sort_order;
	}
	public void setSort_order(Integer sort_order) {
		this.sort_order = sort_order;
	}
	  
}
