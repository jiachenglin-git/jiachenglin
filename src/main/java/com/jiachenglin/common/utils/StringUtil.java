package com.jiachenglin.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:贾成林
 *
 * 2019年9月9日
 * 
* 方法功能：将字符串转换成html文本，如果遇到“\n”换行换符，则要将这一段文本使用<p></p>标签
* 包起来。如果遇到“\n\r”两个在一起按上面\n处理。如果只遇到一个“\r”则替换成<br/>标签。
* 使用场景：网页文本框传到后台的字符串就可能就会回车换行。
 */
public class StringUtil {
	public static String toHtml(String text){
		if(!text.contains("\n")&&!text.contains("\n\r")&&!text.contains("\r")) {
			return "<p>"+text+"</p>";
		}
		if(text.contains("\n")||text.contains("\n\r")) {
			String text1 = "";
			List<String> list = new ArrayList<String>();
			String[] split = text.split("\n");
			for (int i = 0; i < split.length; i++) {
				split[i]="<p>"+split[i]+"</p>";
				list.add(split[i]);
			}
			for (String string : list) {
				text1+=string+"\r";
			}
			return text1;
		}
		if(text.contains("\r")) {
			String text1 = "";
			String[] split = text.split("\r");
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < split.length; i++) {
				split[i]=split[i]+"<br/>";
				list.add(split[i]);
			}
			for (String string : list) {
				text1+=string+"\r";
			}
			return text1;
		}
		return text;
	}
	
//	public static void main(String[] args) {
//		String text1 = "9月5日一大早，又有了新情况。上午9点多，传出中美经贸高级别磋商牵头人通话的消息。"
//				+ "9月5日上午，中共中央政治局委员、国务院副总理、中美全面经济对话中方牵头人刘鹤应约与美国贸易代表莱特希泽、"
//				+ "财政部长姆努钦通话。";
//		text1 = StringUtil.toHtml(text1);
//		System.out.println(text1);
//		String text2 = "9月5日一大早，又有了新情况。\n上午9点多，传出中美经贸高级别磋商牵头人通话的消息。\n\r"
//				+ "9月5日上午，中共中央政治局委员、国务院副总理、中美全面经济对话中方牵头人刘鹤应约与美国贸易代表莱特希泽、"
//				+ "财政部长姆努钦通话。";
//		text2 = StringUtil.toHtml(text2);
//		System.out.println(text2);
//		String text3 = "9月5日一大早，又有了新情况。\r上午9点多，传出中美经贸高级别磋商牵头人通话的消息。\r"
//				+ "9月5日上午，中共中央政治局委员、国务院副总理、中美全面经济对话中方牵头人刘鹤应约与美国贸易代表莱特希泽、"
//				+ "财政部长姆努钦通话。";
//		text3 = StringUtil.toHtml(text3);
//		System.out.println(text3);
//	}
}
