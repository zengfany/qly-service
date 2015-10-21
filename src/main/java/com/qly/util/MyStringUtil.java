package com.qly.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class MyStringUtil {
	/**
	 * 中文验证正则
	 */
	public static final String ZH_REG_EX = "[\\u4e00-\\u9fa5]";   
	/**
	 * String split()扩展 返回值是个list
	 * @param str
	 * @param regex
	 * @return
	 */
	public static List<String> splitToList(String str,String regex){
		List<String> list = new ArrayList<String>();
		if(str==null||"".equals(str.trim())){
			return list;
		}
		String[] strs =  str.split(regex);
		for (String s : strs) {
			list.add(s);
		}
		return list ;
	}
	
	/**
	 * 是否是邮箱
	 * @author qys
	 * @date 2015年8月11日 下午3:24:38
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * String split()扩展 返回值是个list
	 * @param str
	 * @param regex
	 * @return
	 */
	public static List<String> splitToHtmlList(String str,String regex){
		List<String> list = new ArrayList<String>();
		if(str==null||"".equals(str.trim())){
			return list;
		}
		String[] strs =  str.split(regex);
		for (String s : strs) {
			s=MyStringUtil.htmlTrans(s);
			list.add(s);
		}
		return list ;
	}
	/**
	 * 将一个字符串 的中间一段字符替换成*
	 * @param srcStr
	 * @param startInx
	 * @param endInx
	 * @return
	 */
	public static String passStr(String srcStr,int startInx,int endInx){
		if(srcStr==null||"".equals(srcStr)){
			return null;
		}
		endInx=(srcStr.length())>endInx?endInx:(srcStr.length());
		String sStr = srcStr.substring(0, startInx);
		String eStr = srcStr.substring(endInx);
		return sStr+"****"+eStr;
	}
	
	/**
	 * 将一个字符串 的中间一段字符替换成*
	 * @param srcStr 原始字符串
	 * @param f 前保留几个
	 * @param e 后保留几个
	 * @return
	 */
	public static String passStrEnd(String srcStr,int f,int e){
		if(srcStr==null){
			return null;
		}
		if(srcStr.length()<(f+e)){
			return srcStr;
		}
		StringBuilder s = new StringBuilder(); 
		for(int i = 0 ; i <(srcStr.length()-(f+e));i++  ){
			s.append("*");
		}
		return srcStr.subSequence(0, f)+s.toString()+srcStr.substring(srcStr.length()-e, srcStr.length());
	}
	
	/**
	 * 省略一部分字符
	 * @param srcStr
	 * @param leg
	 * @return
	 */
	public static String omitStr(String srcStr,int leg){
		if(srcStr==null){
			return srcStr;
		}
		if(srcStr.length()<leg){
			return srcStr;
		}
		return srcStr.substring(0,leg-1)+"…";
	}
	
	/**
	 * 将手机号码的后几位加密
	 * @param phoneNum
	 * @param leg
	 * @return
	 */
	public static String encryptionPhoneNumEnd(String phoneNum, int leg){
		if (StringUtils.isBlank(phoneNum)) {
			return phoneNum;
		}
		if (phoneNum.length() < leg) {
			return phoneNum;
		}
		return phoneNum.substring(0, leg - 1) + "**";
	}
	
	/** 
	 * 简化 字符串  
	 * 如 strToSimple("1234567890",4) 则返回			1234…
	 * 如 strToSimple("一二三四五六七八九十",4) 则返回 一二…
	 * 即num 对于字母 和数据 是1:1 对于汉字是 2:1
	 * @param str
	 * @param num
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-1 下午05:43:28
	 * @update_time 2014-4-1 下午05:43:28
	 */ 
	public static String strToSimple(String str , int num){
		 if(str==null) return ""; 
		 StringBuffer sb = new StringBuffer();
		 int i = 0 ; 
		 for (char chr : str.toCharArray()) {
			 if(i>=num) return sb.append("…").toString();
			 sb.append(chr);
			 if((int)chr<128){
				 i++ ; 
			 }else{
				 i+=2; 
			 }
		 }
		return str; 
	}
	
	/** 
	 * 判断是否包含中文字符
	 * @param str
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-7 下午12:52:16
	 * @update_time 2014-4-7 下午12:52:16
	 */ 
	public static boolean  containChar_ZH(String str){
		Pattern p=Pattern.compile(ZH_REG_EX);
		Matcher m=p.matcher(str);
		if(m.find())
		{
			return true;
		}
		return false;
	}
	
	/** 
	 * 将毫秒 数 转换成 中文显示
	 * @param tm
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-4 下午07:25:58
	 * @update_time 2014-4-4 下午07:25:58
	 */ 
	public static String timerToViewStr(Double tm){
		if(tm==null){
			return "--";
		}else if(tm<1000){
			return "<&nbsp;1秒钟";
		}else if(tm<5000){
			return "<&nbsp;5秒钟" ;
		}else if(tm<10000){
			return "<&nbsp;10秒钟";
		}else if(tm<30000){
			return "<&nbsp;30秒钟";
		}else if(tm<60000){
			return "<&nbsp;1分钟"; 
		}else if(tm<120000){
			return "<&nbsp;2分钟";
		}else if(tm<300000){
			return "<&nbsp;5分钟";
		}else if(tm<600000){
			return "<&nbsp;10分钟";
		}else{
			return ">&nbsp;10分钟"; 
		}
	}
	/** 
	 * 将毫秒 数 转换成 中文区间显示
	 * @param tm
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-4 下午07:25:58
	 * @update_time 2014-4-4 下午07:25:58
	 */ 
	public static String timerToViewStr(Long tm){
		Double tmDb = 0d ;
		if(tm!=null&&tm>0){
			tmDb = Double.parseDouble(tm.toString());
		}
		return timerToViewStr(tmDb);
	}
	/** 
	 * 将毫秒 数 转换成 中文区间显示
	 * @param tm
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-4 下午07:25:58
	 * @update_time 2014-4-4 下午07:25:58
	 */ 
	public static String timerToViewStr(Integer tm){
		Double tmDb = 0d ;
		if(tm!=null&&tm>0){
			tmDb = Double.parseDouble(tm.toString());
		}
		return timerToViewStr(tmDb);
	}
	
	/** 
	 * 将毫秒 数 转换成 中文区间显示
	 * @param tm
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-4 下午07:25:58
	 * @update_time 2014-4-4 下午07:25:58
	 */ 
	public static String timerToIntervalStr(Double tm){
		if(tm==null){
			return "NOTHING"; 
		}
		
		if(tm<1000||tm==null){
			return "小于1秒";
		}else if(tm<5000){
			return "1-5秒" ;
		}else if(tm<10000){
			return "5-10秒";
		}else if(tm<30000){
			return "10-30秒";
		}else if(tm<60000){
			return "30-60秒"; 
		}else if(tm<120000){
			return "1-2分钟";
		}else if(tm<300000){
			return "2-5分钟";
		}else if(tm<600000){
			return "5-10分钟";
		}else{
			return "大于10分钟"; 
		}
	}
	
	/** 
	 * 将毫秒 数 转换成 中文区间显示
	 * @param tm
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-4 下午07:25:58
	 * @update_time 2014-4-4 下午07:25:58
	 */ 
	public static String timerToIntervalStr(Integer tm){
		Double tmDb = 0d ;
		if(tm!=null&&tm>0){
			tmDb = Double.parseDouble(tm.toString());
		}
		return timerToIntervalStr(tmDb);
	}
	
	/** 
	 * 将毫秒 数 转换成 中文区间显示
	 * @param tm
	 * @return 
	 * @author Sun Qiang
	 * @create_time 2014-4-4 下午07:25:58
	 * @update_time 2014-4-4 下午07:25:58
	 */ 
	public static String timerToIntervalStr(Long tm){
		Double tmDb = 0d ;
		if(tm!=null&&tm>0){
			tmDb = Double.parseDouble(tm.toString());
		}
		return timerToIntervalStr(tmDb);
	}
	
	/**
	 * 计算百分比
	 * @param num1 分母
	 * @param num2 分子
	 * @return
	 */
	public static String calcPercent(Double num1 , Double num2){
		if(num1==null||num1==0){
			return "--";
		}
		if(num2==null||num2==0){
			return "0%";
		}
		Double percent = (num2/num1)*100; 
		DecimalFormat df = new DecimalFormat("0.00");
		String res = df.format(percent);
		return res+"%";
	}
	/**
	 * 计算百分比
	 * @param num1 分母
	 * @param num2 分子
	 * @return
	 */
	public static String calcPercent(Integer num1 , Integer num2){
		if(num1==null) return "--" ;
		if(num2==null) return "0%" ;
		return calcPercent((double)num1,(double) num2);
	}
	
	/**
	 * 将html关键字进行转义
	 * @param htmlStr
	 * @return
	 */
	public static String htmlTrans(String htmlStr){
		if(htmlStr==null)return "";
		return htmlStr
			.replaceAll("&", "&amp;")
			.replaceAll("<", "&lt;")
			.replaceAll(">", "&gt;")
			.replaceAll(" ", "&nbsp;")
			.replaceAll("©", "&copy;")
			.replaceAll("®", "&reg");
	}
	
	
	/**
	 * 将 String List 按照 splitFlag 分割 组成新的String
	 * @param strList
	 * @param split
	 * @return
	 */
	public static String joinStringList(List<String> strList,String splitFlag){
		StringBuilder sb = new StringBuilder();
		int i = 0 ; 
		for (String str : strList) {
			if(i>0){
				sb.append(splitFlag);
			}
			sb.append(str);
			i++;
		}
		return sb.toString();
	}
	/**
	 * int 转换成 大写英文字母 0 -A ,25=Z ,26-AA
	 * @param i
	 * @return
	 */
	public static String intToUpcase(long i ){
		StringBuilder sb = new StringBuilder();
		boolean duo = false ;
		do{
			i = duo?i-1:i;
			long c =  (i%26)+ 65;
			sb.append((char)(c));
			i = ((i/26));
			duo = true;
		}while(i>0);
		return sb.reverse().toString();
	}
	

	private static final String[] STRING_ARY = {   
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",   
       "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",   
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",   
        "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", 
        "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
        "O", "P", "Q", "R", "S", "T","U", "V", "W", "X", 
        "Y", "Z"   
        }; 
	   //TentoN(这里是你想转换的数 ,这里是你想转换为多少进制 2-62之间）  
    public static String tentoN(long value, int number) {  
        if (number <= 1 || number > STRING_ARY.length) {  
            throw new RuntimeException("Faild");  
        }  
        //负数处理  
        if (value < 0) {  
            return "-" + tentoN(0 - value, number);  
        }  
        if (value < number) {  
            return STRING_ARY[(int)value];  
        } else {  
            long n = value % (long)number;  
            return (tentoN(value / number, number) + STRING_ARY[(int)n]);  
        }  
    }  
	
	 /** 
     * 返回4位随机数 
     * @return 
     */  
    public static Integer getRandom4Int(){  
        Integer i = new Random().nextInt(9999);  
        while(i<1000)    i=i<<1;  
        return i;  
    }  
	
    /** 
     * 返回5位 32位的随机数 
     * @return 
     */  
    public static String getRandom4Str36(){  
        Integer i = new Random().nextInt(60466175-1679616);  
        return tentoN(i+1679616, 36);  
    }  
	
    /**
     * 从一个含有UUID的 String 中 找到uuid 没有返回null
     * @param str
     * @return
     */
    public static String findUUIDByStr(String str){
    	if(str==null) return null; 
    	String regex = "[0-9A-Za-z]{8}-[0-9A-Za-z]{4}-[0-9A-Za-z]{4}-[0-9A-Za-z]{4}-[0-9A-Za-z]{12}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			return matcher.group();
		}else {
			return null;
		}
    }
    
    
    /**
     * 验证手机号码
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }
    
    
	public static String obgToStr(Object obj){
		if(obj==null)return "";
		return obj.toString();
	}
	public static String obgToStr(Object obj,String def){
		if(obj==null)return def==null?"":def;
		return obj.toString();
	}
	
	public static int objToInt(Object obj){
		String str = obgToStr(obj, "1");
		double db = Double.parseDouble(str);
		return (int)db;
	}
	
	public static long objToLong(Object obj){
		String str = obgToStr(obj, "1");
		double db = Double.parseDouble(str);
		return (long)db;
	}
	public static void main(String[] args) {
		System.out.println(objToInt("1.00123"));
	}
}
