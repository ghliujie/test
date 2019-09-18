package com.ljlover.travel.domain;

import java.io.Serializable;

/**
 * @Program travel
 * @Description 商家实体类
 * @Author ljlover
 * @Date 2019/8/7 11:28
 * All rights reserved.
 */

public class Seller implements Serializable {

    /**
     * 商家id
     */
    private int sid;

    /**
     * 商家名称
     */
    private String sname;


    /**
     * 商家电话
     */
    private String consphone;


    /**
     * 商家地址
     */
    private String address;



    public Seller(){}
    public Seller(int sid, String sname, String consphone, String address) {
        this.sid = sid;
        this.sname = sname;
        this.consphone = consphone;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getConsphone() {
        return consphone;
    }

    public void setConsphone(String consphone) {
        this.consphone = consphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", consphone='" + consphone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
