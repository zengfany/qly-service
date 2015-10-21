package com.qly.model;
import com.qly.util.MyDateUtil;

/**
 * BkShopWeb
 * @author qys
 * 下午12:16:13
 * 虚拟卡号类
 */
public class VirtualCard {
	/*SELECT
	bvc.card_id,
	bvc.order_goods_id,
	bvc.card_sn,
	bvc.add_date,
	bvc.end_date,
	bvc.use_date,
	bvc.is_use
	FROM
	bk_virtual_card AS bvc*/
	
	private Long card_id = null; // 虚拟卡卡号自增id
	private Long order_goods_id = null; // 该虚拟卡对应的商品id，取值于表bk_goods
	private String card_sn = null; // 虚拟卡号
	private Long add_date = null; // 卡号添加日期
	private Long end_date = null; // 卡号截至使用日期
	private Long use_date = null; // 使用时间
	private Integer is_use = null; // 是否使用，0，否；1，是
	private Integer is_send = null; //是否发送 0否 ，1 是
	private Long verifier_id = null; // 验证票据的用户ID
	public Long getCard_id() {
		return card_id;
	}
	public void setCard_id(Long cardId) {
		card_id = cardId;
	}
	public Long getOrder_goods_id() {
		return order_goods_id;
	}
	public void setOrder_goods_id(Long orderGoodsId) {
		order_goods_id = orderGoodsId;
	}
	public String getCard_sn() {
		return card_sn;
	}
	public void setCard_sn(String cardSn) {
		card_sn = cardSn;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public String getAddDateStr(){
		return MyDateUtil.dbTimerToFmtShowTime(add_date);
	}
	public void setAdd_date(Long addDate) {
		add_date = addDate;
	}
	public Long getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Long endDate) {
		end_date = endDate;
	}
	public Long getUse_date() {
		return use_date;
	}
	public String getUseDateStr(){
		return MyDateUtil.dbTimerToFmtShowTime(use_date);
	}
	public void setUse_date(Long useDate) {
		use_date = useDate;
	}
	public Integer getIs_use() {
		return is_use;
	}
	public void setIs_use(Integer isUse) {
		is_use = isUse;
	}
	public Integer getIs_send() {
		return is_send;
	}
	public void setIs_send(Integer is_send) {
		this.is_send = is_send;
	}
	public Long getVerifier_id() {
		return verifier_id;
	}
	public void setVerifier_id(Long verifierId) {
		verifier_id = verifierId;
	}
	
	
}
