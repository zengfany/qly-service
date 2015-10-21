package com.qly.model;

import com.qly.util.MyDateUtil;
import com.qly.util.MyStringUtil;

/**
 * BkShopWeb
 * @author qys
 * 下午12:12:37
 * 商品类
 */
public class Goods {
	/*SELECT
		bk_goods.goods_id,
		bk_goods.cat_id,
		bk_goods.goods_sn,
		bk_goods.goods_name,
		bk_goods.click_count,
		bk_goods.goods_number,
		bk_goods.market_price,
		bk_goods.shop_price,
		bk_goods.keywords,
		bk_goods.goods_brief,
		bk_goods.goods_desc,
		bk_goods.goods_img,
		bk_goods.is_on_sale,
		bk_goods.add_time,
		bk_goods.sort_order,
		bk_goods.del_flag,
		bk_goods.is_best,
		bk_goods.is_new,
		bk_goods.is_hot,
		bk_goods.last_update
	FROM
		bk_goods*/
	
	private Long goods_id    = null;    // 商品的自增id
	private Integer cat_id     = null;     // 商品所属商品分类id，取值bk_category的cat_id
	private String goods_sn   = null;      // 商品的唯一货号
	private String goods_name = null;      // 商品的名称
	private Integer click_count = null;    // 商品点击数
	private Integer goods_number = null;   // 商品库存数量
	private Double market_price = null;    // 市场售价
	private Double shop_price  = null;     // 本店售价
	private String keywords   = null;      // 商品关键字，放在商品页的关键字中，为搜索引擎收录用
	private String goods_brief = null;     // 商品的简短描述
	private String goods_brief_1 = null;   // 首页左下角描述(适合年龄3~6岁)
	private String goods_desc  = null;     // 商品的详细描述
	private String goods_img   = null;     // 商品的实际大小图片，如进入该商品页时介绍商品属性所显示的大图片
	private Integer is_on_sale  = null;    // 该商品是否开放销售，1，是；0，否
	private Long add_time   = null;        // 商品的添加时间
	private Integer sort_order = null;     // 应该是商品的显示顺序，不过该版程序中没实现该功能
	private Integer del_flag   = null;    // 商品是否已经删除，0，否；1，已删除
	private Integer is_best     = null;    // 是否是精品；0，否；1，是
	private Integer is_new    = null;      // 是否是新品；0，否；1，是
	private Integer is_hot      = null;    // 是否热销，0，否；1，是
	private Long last_update  = null;      // 最近一次更新商品配置的时间
	private Integer star_level = null; // 门票级别，显示几颗星星
	private Integer is_award ; //是否是奖品
	
	
	private Integer goods_type ;  // 商品类型 0 票类商品 1 实体商品
	
	private Long validity_begin_time	= null; // bigint	60	0	-1	0	0	0	0		0	有效期开始时间				0	0
	private Long validity_end_time	= null; // bigint	60	0	-1	0	0	0	0		0	有效期结束时间				0	0

	
	private Integer 	is_ditui ;//	mediumint	8	0	1	0	是否是 地推商品 0 否 1是  	0	0	0
	private Long 	ditui_goods_id ;//	mediumint	8	0	1		地推成功后 送的商品id	0	0	0
	
	private String ditui_goods_name ; //此字段不在 goods 表中存在，关联查询得到
	
	
	/*******************************************************/
	private Integer sales  ;  //商品销量 ，此字段 bp_goods 表中没有，用于查询语句，和 bk_order_goods + bk_virtual_card 联查
	
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	
	/***
	 * 获取缩略后的 goods_name 
	 * @return
	 *@author 孙强 spykerccc@sina.com
	 */
	public String getSimpleGoodsName(){
		return MyStringUtil.strToSimple(this.goods_name,20);
	}
	
	/******************************************************/
	
	public Long getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Long goodsId) {
		goods_id = goodsId;
	}
	public Integer getCat_id() {
		return cat_id;
	}
	public void setCat_id(Integer catId) {
		cat_id = catId;
	}
	public String getGoods_sn() {
		return goods_sn;
	}
	public void setGoods_sn(String goodsSn) {
		goods_sn = goodsSn;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goodsName) {
		goods_name = goodsName;
	}
	public Integer getClick_count() {
		return click_count;
	}
	public void setClick_count(Integer clickCount) {
		click_count = clickCount;
	}
	public Integer getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(Integer goodsNumber) {
		goods_number = goodsNumber;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double marketPrice) {
		market_price = marketPrice;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shopPrice) {
		shop_price = shopPrice;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getGoods_brief() {
		return goods_brief;
	}
	public void setGoods_brief(String goodsBrief) {
		goods_brief = goodsBrief;
	}
	public String getGoods_desc() {
		return goods_desc;
	}
	public void setGoods_desc(String goodsDesc) {
		goods_desc = goodsDesc;
	}
	public String getGoods_img() {
		return goods_img;
	}
	public void setGoods_img(String goodsImg) {
		goods_img = goodsImg;
	}
	public Integer getIs_on_sale() {
		return is_on_sale;
	}
	public void setIs_on_sale(Integer isOnSale) {
		is_on_sale = isOnSale;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public String getAddTimeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(add_time);
	}
	public void setAdd_time(Long addTime) {
		add_time = addTime;
	}
	public Integer getSort_order() {
		return sort_order;
	}
	public void setSort_order(Integer sortOrder) {
		sort_order = sortOrder;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer delFlag) {
		del_flag = delFlag;
	}
	public Integer getIs_best() {
		return is_best;
	}
	public void setIs_best(Integer isBest) {
		is_best = isBest;
	}
	public Integer getIs_new() {
		return is_new;
	}
	public void setIs_new(Integer isNew) {
		is_new = isNew;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer isHot) {
		is_hot = isHot;
	}
	public Long getLast_update() {
		return last_update;
	}
	public String getLastUpdateStr(){
		return MyDateUtil.dbTimerToFmtShowTime(last_update);
	}
	public void setLast_update(Long lastUpdate) {
		last_update = lastUpdate;
	}
	public Integer getStar_level() {
		return star_level;
	}
	public void setStar_level(Integer starLevel) {
		star_level = starLevel;
	}
	public String getGoods_brief_1() {
		return goods_brief_1;
	}
	public void setGoods_brief_1(String goodsBrief_1) {
		goods_brief_1 = goodsBrief_1;
	}
	public Integer getIs_award() {
		return is_award;
	}
	public void setIs_award(Integer is_award) {
		this.is_award = is_award;
	}
	public Integer getGoods_type() {
		return goods_type;
	}
	public void setGoods_type(Integer goods_type) {
		this.goods_type = goods_type;
	}
	public Long getValidity_begin_time() {
		return validity_begin_time;
	}
	/**
	 * 转换成页面显示的格式
	 * @author qys
	 * @date 2015年8月15日 上午2:14:09
	 * @return
	 */
	public String getValidity_begin_timeStr(){
		if(validity_begin_time == null || validity_begin_time == 0){
			return null;
		}
		return MyDateUtil.dbTimeToFmtShowSimpleIsDay(validity_begin_time);
	}
	public void setValidity_begin_time(Long validity_begin_time) {
		this.validity_begin_time = validity_begin_time;
	}
	public Long getValidity_end_time() {
		return validity_end_time;
	}
	/**
	 * 转换成页面显示的格式
	 * @author qys
	 * @date 2015年8月15日 下午2:54:16
	 * @return
	 */
	public String getValidity_end_timeStr(){
		if (validity_end_time == null || validity_end_time == 0) {
			return null;
		}
		return MyDateUtil.dbTimeToFmtShowSimpleIsDay(validity_end_time);
	}
	public void setValidity_end_time(Long validity_end_time) {
		this.validity_end_time = validity_end_time;
	}
	public Integer getIs_ditui() {
		return is_ditui;
	}
	public void setIs_ditui(Integer is_ditui) {
		this.is_ditui = is_ditui;
	}
	public Long getDitui_goods_id() {
		return ditui_goods_id;
	}
	public void setDitui_goods_id(Long ditui_goods_id) {
		this.ditui_goods_id = ditui_goods_id;
	}
	public String getDitui_goods_name() {
		if(ditui_goods_name!=null){
			return MyStringUtil.omitStr(ditui_goods_name, 8);
		}
		return ditui_goods_name;
	}
	public void setDitui_goods_name(String ditui_goods_name) {
		this.ditui_goods_name = ditui_goods_name;
	}
	
}
