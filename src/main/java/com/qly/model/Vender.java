package com.qly.model;

import com.qly.util.MyDateUtil;

import java.text.DecimalFormat;


/**
 * 商家
 * @author spykerccc
 *
 */
public class Vender {
	
	private Long vender_id = null; //mediumint	8	0	0	-1	0	0	0		0	商家ID				-1	0
	private String vender_name = null; //varchar	60	0	0	0	0	0	0		0	商家名称	utf8	utf8_general_ci		0	0
	private String site = null; //varchar	60	0	-1	0	0	0	0	'0'	0	地址	utf8	utf8_general_ci		0	0
	private String tel = null; //varchar	20	0	-1	0	0	0	0		0	商家电话	utf8	utf8_general_ci		0	0
	private String phone = null; //	varchar	20	0	-1	0	0	0	0		0	手机	utf8	utf8_general_ci		0	0
	private String email = null; //	varchar	50	0	-1	0	0	0	0		0	邮件	utf8	utf8_general_ci		0	0
	private Integer threshold_1 = null; //	int	8	0	-1	0	0	0	0	0	0	阈值1(娱乐设施)				0	0
	private Integer threshold_2 = null; //	int	8	0	-1	0	0	0	0		0	阈值1(乐园环境)				0	0
	private Integer threshold_3 = null; //	int	8	0	-1	0	0	0	0	0	0	阈值1(开心指数)				0	0
	private String province = null; //	varchar	255	0	-1	0	0	0	0		0	省	utf8	utf8_general_ci		0	0
	private String city = null; // varchar	255	0	-1	0	0	0	0		0	城市	utf8	utf8_general_ci		0	0
	private String region = null; //varchar	255	0	-1	0	0	0	0		0	地区	utf8	utf8_general_ci		0	0
	private String logo_path = null; //	varchar	255	0	-1	0	0	0	0		0	商家宣传图片地址	utf8	utf8_general_ci		0	0
	private String short_desc = null; //	varchar	255	0	-1	0	0	0	0		0	简短描述	utf8	utf8_general_ci		0	0
	private String detail = null; //text	0	0	-1	0	0	0	0		0	详情	utf8	utf8_general_ci		0	0
	private Long add_time = null; //bigint	20	0	0	0	0	0	0		0	创建时间				0	0
	private Long update_time = null; // 更新时间
	private Integer del_flag = null; //	smallint	1	0	-1	0	0	0	0	1	0	是否删除 0 删除 1 未删除				0	0

	private Long category_id ;  //商家分类id
	
	private Integer coupons_1 ; // 能否使用代金券 0否 1是
	private Integer coupons_2 ; // 能否使用畅玩卡 0 否 1 是
	private Double map_lng;//0	map_lng	double	20	8	1	0.00000000	地图 经度 (百度地图数据)	0	0
	private Double map_lat;//0	map_lat	double	20	8	1		地图 纬度 (百度地图数据)	0	0
	
	private Double average_score = null; // 商家的综合平均分
	private Double avg_score_1 = null; // 商家第一个平均分数
	private Double avg_score_2 = null; // 商家第一个平均分数
	private Double avg_score_3 = null; // 商家第一个平均分数
	
	
	private Integer order_flag ; //排序字段
	
	
	/** 非数据库 对应字段**/
	private Double distance_mi ; //与用户所在位置距离  单位 mi 
	
	
	public Double getDistance_mi() {
		return distance_mi;
	}
	public void setDistance_mi(Double distance_mi) {
		this.distance_mi = distance_mi;
	}
	
	public String getDistance_mi_str(){
		DecimalFormat km_df = new DecimalFormat("0.00");
		if(this.distance_mi==null){
			return "" ;
		}else if(this.distance_mi<=1000){
			return distance_mi.intValue() +" m" ;
		}else{
			Double db = this.distance_mi/1000d ; 
			return km_df.format(db)+" km";
		}
		
	}
	
	/****/
	public Long getVender_id() {
		return vender_id;
	}
	public void setVender_id(Long vender_id) {
		this.vender_id = vender_id;
	}
	public String getVender_name() {
		return vender_name;
	}
	public void setVender_name(String vender_name) {
		this.vender_name = vender_name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Long add_time) {
		this.add_time = add_time;
	}
	public String getAddTimeStr(){
		return MyDateUtil.dbTimerToFmtShowTime(add_time);
	}
	public Integer getThreshold_1() {
		if (null == threshold_1) {
			return 0;
		}
		return threshold_1;
	}
	public void setThreshold_1(Integer threshold_1) {
		this.threshold_1 = threshold_1;
	}
	public Integer getThreshold_2() {
		if (null == threshold_2) {
			return 0;
		}
		return threshold_2;
	}
	public void setThreshold_2(Integer threshold_2) {
		this.threshold_2 = threshold_2;
	}
	public Integer getThreshold_3() {
		if (null == threshold_1) {
			return 0;
		}
		return threshold_3;
	}
	public void setThreshold_3(Integer threshold_3) {
		this.threshold_3 = threshold_3;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLogo_path() {
		return logo_path;
	}
	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(Integer del_flag) {
		this.del_flag = del_flag;
	}
	public Long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public Integer getCoupons_1() {
		return coupons_1==null?0:coupons_1;
	}
	public void setCoupons_1(Integer coupons_1) {
		this.coupons_1 = coupons_1;
	}
	public Integer getCoupons_2() {
		return coupons_2==null?0:coupons_2;
	}
	public void setCoupons_2(Integer coupons_2) {
		this.coupons_2 = coupons_2;
	}
	public Double getMap_lng() {
		return map_lng;
	}
	public void setMap_lng(Double map_lng) {
		this.map_lng = map_lng;
	}
	public Double getMap_lat() {
		return map_lat;
	}
	public void setMap_lat(Double map_lat) {
		this.map_lat = map_lat;
	}
	public Double getAverage_score() {
		return average_score;
	}
	public void setAverage_score(Double average_score) {
		this.average_score = average_score;
	}
	public Double getAvg_score_1() {
		return avg_score_1;
	}
	public void setAvg_score_1(Double avg_score_1) {
		this.avg_score_1 = avg_score_1;
	}
	public Double getAvg_score_2() {
		return avg_score_2;
	}
	public void setAvg_score_2(Double avg_score_2) {
		this.avg_score_2 = avg_score_2;
	}
	public Double getAvg_score_3() {
		return avg_score_3;
	}
	public void setAvg_score_3(Double avg_score_3) {
		this.avg_score_3 = avg_score_3;
	}
	public Integer getOrder_flag() {
		return order_flag;
	}
	public void setOrder_flag(Integer order_flag) {
		this.order_flag = order_flag;
	}
}
