package com.worktowork.glgw.bean;

import java.io.Serializable;

public class SearchHot implements Serializable {
    /**
     * member_id : 0
     * search_key : 小米
     */

    private int member_id;
    private String search_key;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getSearch_key() {
        return search_key;
    }

    public void setSearch_key(String search_key) {
        this.search_key = search_key;
    }
}
