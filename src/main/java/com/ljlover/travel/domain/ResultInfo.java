package com.ljlover.travel.domain;

import java.io.Serializable;

/**
 * @Program travel
 * @Description 用于封装后端返回前端数据对象
 * @Author ljlover
 * @Date 2019/8/7 11:45
 * All rights reserved.
 */

public class ResultInfo implements Serializable {

    /**
     * 后端返回结果,正常:true，异常:false
     */
    private boolean flag;


    /**
     * 后端返回结果数据对象
     */
    private Object data;


    /**
     * 发生异常的错误消息
     */
    private String errorMsg;

    public ResultInfo() {
    }

    public ResultInfo(boolean flag) {
        this.flag = flag;
    }

    public ResultInfo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public ResultInfo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
