package com.qly.model;

/**
 * 用户评分
 * @author qys
 * @date 2015年8月16日 上午11:38:19
 */
public class MarkScore {
	private Long mark_score_id = null; //	int	11	0	0	0	0	0	0		0	主键				-1	0
	private Long user_id	= null; // int	11	0	-1	0	0	0	0		0	用户ID				0	0
	private Long vender_id = null; // int	11	0	-1	0	0	0	0		0	商户ID				0	0
	private Long goods_id = null; // int	11	0	-1	0	0	0	0		0	商品ID				0	0
	private Long order_goods_id =null; // 订单ID 
	private Double score_1	= null; // double	2	1	-1	0	0	0	0	0.0	0	评分1				0	0
	private Double score_2	= null; // double	2	1	-1	0	0	0	0	0.0	0	评分2				0	0
	private Double score_3 = null; // 评分3
	private Double average_score = null; //	double	2	1	-1	0	0	0	0		0	综合平均分数				0	0
	private Long add_time = null; //	bigint	60	0	-1	0	0	0	0		0	评分时间				0	0
	
	
	public Long getMark_score_id() {
		return mark_score_id;
	}
	public void setMark_score_id(Long mark_score_id) {
		this.mark_score_id = mark_score_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getVender_id() {
		return vender_id;
	}
	public void setVender_id(Long vender_id) {
		this.vender_id = vender_id;
	}
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goods_id) {
		this.goods_id = goods_id;
	}
	public Double getScore_1() {
		return score_1;
	}
	public void setScore_1(Double score_1) {
		this.score_1 = score_1;
	}
	public Double getScore_2() {
		return score_2;
	}
	public void setScore_2(Double score_2) {
		this.score_2 = score_2;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public Double getAverage_score() {
		return average_score;
	}
	public void setAverage_score(Double average_score) {
		this.average_score = average_score;
	}
	public Double getScore_3() {
		return score_3;
	}
	public void setScore_3(Double score_3) {
		this.score_3 = score_3;
	}
	public Long getOrder_goods_id() {
		return order_goods_id;
	}
	public void setOrder_goods_id(Long order_goods_id) {
		this.order_goods_id = order_goods_id;
	}
}
