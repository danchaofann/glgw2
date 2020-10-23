package com.worktowork.glgw.bean;

import java.io.Serializable;

public class OrderManagementBean implements Serializable {
    private String content;
    private boolean select;

    public OrderManagementBean(String content, boolean select) {
        this.content = content;
        this.select = select;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
