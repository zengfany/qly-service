package com.qly.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
public class MyDateUtil {
	private static final Logger LOG = Logger.getLogger(MyDateUtil.class) ; 
	/**
	 * d_monitor_data 访问时间 格式
	 */
	public static final String DATA_TIME_FMT ="yyyyMMddHHmmss";
	
	/**
	 * 格式成月份形式
	 */
	public static final String DATA_TIME_MONTH_FMT = "yyyyMM";
	/**
	 * 格式成天形式
	 */
	public static final String DATA_TIME_DAY_FMT = "yyyyMMdd";
	/**
	 * 显示到页面的时间格式
	 */
	public static final String DETAIL_SHOW_TIME_FMT="yyyy-MM-dd HH:mm:ss";
	/**
	 * 显示到页面的时间格式 到分钟
	 */
	public static final String DETAIL_SHOW_TIME_FMT_MIN="yyyy-MM-dd HH:mm";
	/**
	 * d_monitor_data 当天起始时间格式
	 */
	public static final String START_DAY_TIME_FMT="yyyyMMdd000000" ; 
	/**
	 * 显示到页面的时间格式
	 */
	public static final String SIMPLE_SHOW_TIME_FMT="HH:mm:ss";
	
	/**
	 * 显示到页面的日期格式 不含时分秒 XXXX-XX-XX
	 */
	public static final String SIMPLE_SHOW_DAY_FMT = "yyyy-MM-dd";
	
	/**
	 * 显示到月份
	 */
	public static final String SIMPLE_SHOW_MONTH_FMT = "yyyy-MM";
	
	/**
	 * 将日期转换成简单中文
	 * @param date
	 * @return
	 */
	public static String parseDate_simple_zh(Date date){    
        try {
            String ret = "";
            long tarTime = date.getTime();
            Calendar now = Calendar.getInstance();
            long ms  = 1000*(now.get(Calendar.HOUR_OF_DAY)*3600+now.get(Calendar.MINUTE)*60+now.get(Calendar.SECOND));//毫秒数
            long ms_now = now.getTimeInMillis();
            long cha = ms_now-tarTime;
            if(cha<1000*60){//一分前
            	ret = "刚刚";
            }else if(cha<1000*60*60){//一小时内
                ret = cha/(1000*60)+"分钟前";
            }else if(cha<1000*60*60*5){//5小时内
                ret = cha/(1000*60*60)+"小时前";
            }else if(cha<ms){
            	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                ret = sdf.format(date);
            }else if(cha<(ms+24*3600*1000)){
                ret = "昨天";
            }else if(cha<(ms+24*3600*1000*2)){
                ret = "前天";
            }else{
                ret= "更早";
            }
            return ret;
            } catch (Exception e) {
            e.printStackTrace();
            }
        return null;
    }
	
	/**
	 * 获取date 的其实时间 自定义timer格式
	 * @param date
	 * @return
	 */
	public static Long getDayStartTimer(Date date){
		if(date==null)return null; 
		SimpleDateFormat sdf =  new SimpleDateFormat(START_DAY_TIME_FMT);
		String dateStr =  sdf.format(date);
		return Long.parseLong(dateStr) ;
	}
	
	
	/** 
	 * @param dbtime
	 * @return 将数据库中yyyyMMddHHmmss 转换成 yyyy-MM-dd HH:mm:ss
	 * @author Sun Qiang
	 * @create_time 2014-3-19 下午06:11:47
	 * @update_time 2014-3-19 下午06:11:47
	 */ 
	public static String dbTimerToFmtShowTime(Long dbtime){
		SimpleDateFormat showSdf = new SimpleDateFormat(DETAIL_SHOW_TIME_FMT);
		SimpleDateFormat dbSdf = new SimpleDateFormat(DATA_TIME_FMT);
		String showStr = "NOTHING";
		if(dbtime!=null){
			try {
				showStr= showSdf.format(dbSdf.parse(dbtime+""));
			} catch (ParseException e) {
				LOG.error(dbtime+"日期转换异常",e);
				e.printStackTrace();
			}
		}
		return showStr ; 
//		return null;
	}
	
	
	/** 
	 * @param dbtime
	 * @return 将数据库中yyyyMMddHHmmss 转换成 yyyy-MM-dd HH:mm
	 * @author Sun Qiang
	 * @create_time 2014-3-19 下午06:11:47
	 * @update_time 2014-3-19 下午06:11:47
	 */ 
	public static String dbTimerToFmtShowMin(Long dbtime){
		SimpleDateFormat showSdf = new SimpleDateFormat(DETAIL_SHOW_TIME_FMT_MIN);
		SimpleDateFormat dbSdf = new SimpleDateFormat(DATA_TIME_FMT);
		String showStr = "NOTHING";
		if(dbtime!=null){
			try {
				showStr= showSdf.format(dbSdf.parse(dbtime+""));
			} catch (ParseException e) {
				LOG.error(dbtime+"日期转换异常",e);
				e.printStackTrace();
			}
		}
		return showStr ; 
//		return null;
	}
	
	/** 
	 * @param dbtime
	 * @return 将数据库中yyyyMMddHHmmss 转换成 yyyy-MM-dd HH:mm
	 * @author Sun Qiang
	 * @create_time 2014-3-19 下午06:11:47
	 * @update_time 2014-3-19 下午06:11:47
	 */ 
	public static String dbTimerToFmtShowMin(Object dbtimeObj){
		if(dbtimeObj==null) return "NOTHING" ;
		Long dbtime = 0l ; 
		
		try {
			dbtime = Long.parseLong(dbtimeObj.toString());
		} catch (NumberFormatException e1) {
			return "NOTHING" ;
		}
		SimpleDateFormat showSdf = new SimpleDateFormat(DETAIL_SHOW_TIME_FMT_MIN);
		SimpleDateFormat dbSdf = new SimpleDateFormat(DATA_TIME_FMT);
		String showStr = "NOTHING";
		if(dbtime!=null){
			try {
				showStr= showSdf.format(dbSdf.parse(dbtime+""));
			} catch (ParseException e) {
				LOG.error(dbtime+"日期转换异常",e);
				e.printStackTrace();
			}
		}
		return showStr ; 
//		return null;
	}
	
	
	/** 
	 * @param dbtime
	 * @return 将数据库中yyyyMMddHHmmss 转换成 HH:mm:ss
	 * @author Sun Qiang
	 * @create_time 2014-3-19 下午06:11:47
	 * @update_time 2014-3-19 下午06:11:47
	 */ 
	public static String dbTimerToFmtShowSimple(Long dbtime){
		SimpleDateFormat showSdf = new SimpleDateFormat(SIMPLE_SHOW_TIME_FMT);
		SimpleDateFormat dbSdf = new SimpleDateFormat(DATA_TIME_FMT);
		String showStr = "NOTHING";
		if(dbtime!=null){
			try {
				showStr= showSdf.format(dbSdf.parse(dbtime+""));
			} catch (ParseException e) {
				LOG.error(dbtime+"日期转换异常",e);
				e.printStackTrace();
			}
		}
		return showStr ; 
	}
	
	/**
	 * 将字符串转换成Date
	 * @param time 转换的字符串
	 * @param fmtType 字符串的格式
	 * @return
	 */
	public static Date strFmtDate(String time, String fmtType){
		SimpleDateFormat dbSdf = new SimpleDateFormat(fmtType);
		Date d = null;
		if(time!=null){
			try {
				d = dbSdf.parse(time);
			} catch (ParseException e) {
				LOG.error(time+"日期转换异常",e);
				e.printStackTrace();
			}
		}
		return d ; 
	}
	
	/**
	 * 将数据库中 yyyyMMddHHmmss 转换成 yyyy-MM-dd
	 * 显示到天
	 * @param dbtime
	 * @return
	 */
	public static String dbTimeToFmtShowSimpleIsDay(Long dbtime){
		SimpleDateFormat showSdf = new SimpleDateFormat(MyDateUtil.SIMPLE_SHOW_DAY_FMT);
		SimpleDateFormat dbSdf = new SimpleDateFormat(MyDateUtil.DATA_TIME_FMT);
		String showStr = "NOTHING";
		if(dbtime!=null){
			try {
				showStr = showSdf.format(dbSdf.parse(dbtime+""));
			} catch (ParseException e) {
				LOG.error(dbtime+"日期转换异常",e);
				e.printStackTrace();
			}
		}
		return showStr ;
	}
	
	
	/**
	 * 将Date转换成 yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String dateToShowSimpleDay(Date date){
		SimpleDateFormat showSdf = new SimpleDateFormat(MyDateUtil.SIMPLE_SHOW_DAY_FMT);
		return showSdf.format(date);
	}
	
	/**
	 * 将数据库中 yyyyMMddHHmmss 转换成 yyyy-MM
	 * 显示月份
	 * @param dbtime
	 * @return
	 */
	public static String dbTimeToFmtShowSimpleIsMonth(Long dbtime){
		SimpleDateFormat showSdf = new SimpleDateFormat(MyDateUtil.SIMPLE_SHOW_MONTH_FMT);
		SimpleDateFormat dbSdf = new SimpleDateFormat(MyDateUtil.DATA_TIME_MONTH_FMT);
		String showStr = "NOTHING";
		if(dbtime!=null){
			try {
				showStr = showSdf.format(dbSdf.parse(dbtime+""));
			} catch (ParseException e) {
				LOG.error(dbtime+"日期转换异常",e);
				e.printStackTrace();
			}
		}
		return showStr ;
	}
	
	/** 
	 * 将自定义的时间格式转换成Date 如20140101000011 转换
	 * @param timer
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-13 下午04:25:41
	 * @update_time 2014-4-13 下午04:25:41
	 */ 
	public static Date myTimerToDate(Long timer){
		if(timer==null||timer<=0){
			return null; 
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATA_TIME_FMT);
		try {
			return sdf.parse(timer.toString());
		} catch (ParseException e) {
			LOG.error(timer+"日期转换异常",e);
			return null;
		}
	}
	
	/** 
	 * 将 date 转换成yyyyMMddHHmmss格式的 long 类型
	 * 精确到时分秒
	 * @param date
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-23 下午01:16:06
	 * @update_time 2014-4-23 下午01:16:06
	 */ 
	public static Long dateFmtTimer(Date date){
		if(date==null)return null; 
		SimpleDateFormat sdf =  new SimpleDateFormat(DATA_TIME_FMT);
		String dateStr =  sdf.format(date);
		return Long.parseLong(dateStr) ; 
	}
	
	/**
	 * 将 date 转换成yyyyMM格式 Long 类型
	 * 精确到月
	 * @return
	 */
	public static Long dateFmtMonth(Date date){
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATA_TIME_MONTH_FMT);
		String dateStr = sdf.format(date);
		return Long.parseLong(dateStr);
	}
	
	/**
	 * 将 date 转换成yyyyMMdd格式 Long 类型
	 * 精确到天
	 * @return
	 */
	public static Long dateFmtDay(Date date){
		if (null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATA_TIME_DAY_FMT);
		String dateStr = sdf.format(date);
		return Long.parseLong(dateStr);
	}
	
	
	/**
	 * Date  中 天 的 加减法  val 支持正负值 正 加  负 减 
	 * @param date
	 * @param val
	 * @return
	 */
	public static Date dateAddDay(Date date , int amount ){
		GregorianCalendar gc =new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.DAY_OF_MONTH, amount);
		return gc.getTime();
	}
	
	/**
	 * Date  中 小时  的 加减法  val 支持正负值 正 加  负 减 
	 * @param date
	 * @param val
	 * @return
	 */
	public static Date dateAddHour(Date date , int amount ){
		GregorianCalendar gc =new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.HOUR, amount);
		return gc.getTime();
	}
	
	/**
	 * Date  中 分钟  的 加减法  val 支持正负值 正 加  负 减 
	 * @param date
	 * @param val
	 * @return
	 */
	public static Date dateAddMinute(Date date , int amount ){
		GregorianCalendar gc =new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.MINUTE, amount);
		return gc.getTime();
	}
	
	/**
	 * Date  中月  的 加减法  val 支持正负值 正 加  负 减 
	 * @param date
	 * @param val
	 * @return
	 */
	public static Date dateAddMonth(Date date , int amount ){
		GregorianCalendar gc =new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.MONTH, amount);
		return gc.getTime();
	}
	
	

	/**
	 * Date  中 年  的 加减法  val 支持正负值 正 加  负 减 
	 * @param date
	 * @param val
	 * @return
	 */
	public static Date dateAddYear(Date date , int amount ){
		GregorianCalendar gc =new GregorianCalendar();
		gc.setTime(date);
		gc.add(GregorianCalendar.YEAR, amount);
		return gc.getTime();
	}
	
	
	/**
	 * 获取给定时间当天的起始时间  即 0时 0分 0秒 的时间
	 * @param date
	 * @return
	 */
	public static Date getDateDayStart(Date date){
		if(date == null ) return null; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = null; 
		try {
			d =  sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d ; 
	}
	
	/**
	 * 自定义时间timer 增减 分钟数
	 * @param fmtTimer
	 * @param amount
	 * @return
	 */
	public static Long addMinuteFmtTimer(Long fmtTimer,int amount){
		Date cDate = myTimerToDate(fmtTimer);
		GregorianCalendar cal = new GregorianCalendar(); 
		cal.setTime(cDate);
		cal.add(GregorianCalendar.MINUTE, amount);
		return dateFmtTimer(cal.getTime());
	}
	
	/**
	 * 自定义时间timer 增减 秒
	 * @param fmtTimer
	 * @param amount
	 * @return
	 */
	public static Long addSecondFmtTimer(Long fmtTimer,int amount){
		Date cDate = myTimerToDate(fmtTimer);
		GregorianCalendar cal = new GregorianCalendar(); 
		cal.setTime(cDate);
		cal.add(GregorianCalendar.SECOND, amount);
		return dateFmtTimer(cal.getTime());
	}
	
	/**
	 * 自定义时间timer 增减 小时
	 * @param fmtTimer
	 * @param amount
	 * @return
	 */
	public static Long addHourFmtTimer(Long fmtTimer,int amount){
		Date cDate = myTimerToDate(fmtTimer);
		GregorianCalendar cal = new GregorianCalendar(); 
		cal.setTime(cDate);
		cal.add(GregorianCalendar.HOUR, amount);
		return dateFmtTimer(cal.getTime());
	}
	
	
	/**
	 * 自定义时间timer 增减 小时
	 * @param fmtTimer
	 * @param amount
	 * @return
	 */
	public static Long addDayFmtTimer(Long fmtTimer,int amount){
		Date cDate = myTimerToDate(fmtTimer);
		GregorianCalendar cal = new GregorianCalendar(); 
		cal.setTime(cDate);
		cal.add(GregorianCalendar.DAY_OF_YEAR, amount);
		return dateFmtTimer(cal.getTime());
	}
	
	/**
	 * 自定义时间timer 增减 月
	 * @param fmtTimer
	 * @param amount
	 * @return
	 */
	public static Long addMonthFmtTimer(Long fmtTimer,int amount){
		Date cDate = myTimerToDate(fmtTimer);
		GregorianCalendar cal = new GregorianCalendar(); 
		cal.setTime(cDate);
		cal.add(GregorianCalendar.MONTH, amount);
		return dateFmtTimer(cal.getTime());
	}
	
	
	/***
	 * 判断是星期几
	 * 周日 是 1 周一 是 2 周六 是 7  
	 * @param date
	 * @return 
	 *@author 孙强 spykerccc@sina.com
	 */
	public static int weekday(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		 
		return c.get(Calendar.DAY_OF_WEEK) ; 
	}
	
	/***
	 * 将 精确到天的 String 转换为 timer 格式
	 * @param dayStr
	 * @return
	 *@author 孙强 spykerccc@sina.com
	 */
	public static Long dayStrToTimer(String dayStr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=   sdf.parse(dayStr);
			return dateFmtTimer(date);
		} catch (ParseException e) {
			return -1l;
		}
	}
	
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150816000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150815000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150814000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150813000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150812000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150811000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150810000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150809000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150808000000l)));
		System.out.println(MyDateUtil.weekday(MyDateUtil.myTimerToDate(20150807000000l)));
		
		
//		Long cTimer = dateFmtTimer(new Date());
//		System.out.println(dbTimerToFmtShowMin(cTimer));
//		System.out.println("增加  5秒		:"+addSecondFmtTimer(cTimer, 5));
//		System.out.println("原始时间 		:"+cTimer);
//		System.out.println("减少  5秒		:"+addSecondFmtTimer(cTimer, -5));
//		System.out.println("___________________________________");
//		
//		System.out.println("增加 5分钟	:"+addMinuteFmtTimer(cTimer, 5));
//		System.out.println("原始时间 		:"+cTimer);
//		System.out.println("减少 5分钟	:"+addMinuteFmtTimer(cTimer, -5));
//		System.out.println("___________________________________");
//		System.out.println("增加 5小时	:"+addHourFmtTimer(cTimer, 5));
//		System.out.println("原始时间 		:"+cTimer);
//		System.out.println("减少 5小时	:"+addHourFmtTimer(cTimer, -5));
//		System.out.println("___________________________________");
//		System.out.println("增加  5天		:"+addDayFmtTimer(cTimer, 5));
//		System.out.println("原始时间 		:"+cTimer);
//		System.out.println("减少  5天		:"+addDayFmtTimer(cTimer, -5));
//		System.out.println("___________________________________");
//		System.out.println("增加  5月		:"+addMonthFmtTimer(cTimer, 5));
//		System.out.println("原始时间 		:"+cTimer);
//		System.out.println("减少  5月		:"+addMonthFmtTimer(cTimer, -5));
	}
}
