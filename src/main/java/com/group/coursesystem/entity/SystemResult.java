package com.group.coursesystem.entity;

/**
 * 系统处理结果 <br>
 * 类名：SystemResult<br>
 * 作者： mht<br>
 * 日期： 2018年12月27日-下午6:15:58<br>
 */
public class SystemResult {
    /** 处理结果代码，必须*/
    private String resCode;
    /** 处理结果消息，可选*/
    private String message;
    /** 处理结果对象，可选*/
    private Object obj;
    
    public SystemResult(String resCode, String message, Object obj) {
        this.resCode = resCode;
        this.message = message;
        this.obj = obj;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "{resCode : " + resCode + ", message : " + message + ", obj : " + obj + "}";
    }

}
