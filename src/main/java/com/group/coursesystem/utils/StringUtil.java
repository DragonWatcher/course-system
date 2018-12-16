package com.group.coursesystem.utils;

import org.junit.Test;

public class StringUtil {

    /**
     * 字符串首字母大写
     * <br>作者： mht<br> 
     * 时间：2018年12月13日-下午10:53:22<br>
     * @param arg
     * @return
     */
    public static String capitalUpperCase(String arg) {
        arg = arg.trim();
        char capital = arg.charAt(0);
        return arg.replace(String.valueOf(capital), String.valueOf(capital).toUpperCase());
    }
    
}
