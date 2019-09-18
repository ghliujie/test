package com.ljlover.travel.domain;

import java.io.Serializable;

/**
 * @Program travel
 * @Description  收藏实体类
 * @Author ljlover
 * @Date 2019/8/7 11:43
 * All rights reserved.
 */

public class Favorite implements Serializable {

    /**
     * 旅游线路对象
     */
    private Route route;


    /**
     * 收藏时间
     */
    private String date;


    /**
     * 所属用户
     */
    private User user;

    public Favorite() {
    }

    public Favorite(Route route, String date, User user) {
        this.route = route;
        this.date = date;
        this.user = user;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "route=" + route +
                ", date='" + date + '\'' +
                ", user=" + user +
                '}';
    }
}
