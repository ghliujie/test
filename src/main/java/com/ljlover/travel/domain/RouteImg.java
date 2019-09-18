package com.ljlover.travel.domain;

import java.io.Serializable;

/**
 * @Program travel
 * @Description  旅游线路图片实体类
 * @Author ljlover
 * @Date 2019/8/7 11:30
 * All rights reserved.
 */

public class RouteImg implements Serializable {

    /**
     * 商品图片id
     */
    private int rgid;


    /**
     * 旅游商品id
     */
    private int rid;

    /**
     * 详情商品大图
     */
    private String bigPic;

    /**
     * 详情商品小图
     */
    private String smallPic;

    public RouteImg() {
    }

    public RouteImg(int rgid, int rid, String bigPic, String smallPic) {
        this.rgid = rgid;
        this.rid = rid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
    }

    public int getRgid() {
        return rgid;
    }

    public void setRgid(int rgid) {
        this.rgid = rgid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    @Override
    public String toString() {
        return "RouteImg{" +
                "rgid=" + rgid +
                ", rid=" + rid +
                ", bigPic='" + bigPic + '\'' +
                ", smallPic='" + smallPic + '\'' +
                '}';
    }
}
