package com.hwua.util;

public class StringUtil {
    public static String repaceStr(String str) {
	str = str.replace(">", "&gt;");
	str = str.replace("<", "&lt;");
	str = str.replace(" ", "&nbsp;");
	str = str.replace("\"", "&quot;");
	str = str.replace("\n", "<br>");
	return str;
    }

}
