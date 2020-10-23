package com.worktowork.glgw.bean;

import java.io.Serializable;

public class WorkBean implements Serializable {
    private Integer icon;
    private String content;
    private int number;

    public WorkBean(Integer icon, String content, int number) {
        this.icon = icon;
        this.content = content;
        this.number = number;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
