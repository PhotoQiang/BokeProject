package com.util;



public class StringUtils {
	
	
		
	public static  boolean isNuLLOrBlank(String str){
		if(str==null||"".equals(str.trim()))
			return true;
		return false;
	}
	
	public static String nullOrBlankToEmpty(String str){
		if(isNuLLOrBlank(str))
			str="";
		return str;
	}
	
	
	public static String nullOrBlankToValue(String str){
		if(isNuLLOrBlank(str))
			str="-1";
		return str;
	}
	
	public static String nullOrBlankToValue(String str,int val){
		if(isNuLLOrBlank(str))
			str=val+"";
		return str;
	}
	
	
	
	public static boolean isnum(String ss){
		 { 
			 for(int i=0;i<ss.length();i++)
		    {
		     char a=ss.charAt(i);
		     if(a<'0'||a>'9')
		     {
		      return false;
		     }
		    }
		return true;
		}
	}

//	public static void main(String[] args) {
//		System.out.println(StringUtils.isnum("22"));
//	}
}

