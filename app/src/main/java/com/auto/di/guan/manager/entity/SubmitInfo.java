package com.auto.di.guan.manager.entity;

public class SubmitInfo {
    private String title;
    private int index = -1;
    private String desc;

    public SubmitInfo(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
