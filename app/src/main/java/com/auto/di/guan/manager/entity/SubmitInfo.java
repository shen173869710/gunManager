package com.auto.di.guan.manager.entity;

import java.util.ArrayList;

public class SubmitInfo {
    private String title;
    private int index = -1;
    private String desc;
    private String info;
    private ArrayList<String>lists = new ArrayList<>();

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

    public ArrayList<String> getLists() {
        return lists;
    }

    public void setLists(ArrayList<String> lists) {
        this.lists = lists;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
