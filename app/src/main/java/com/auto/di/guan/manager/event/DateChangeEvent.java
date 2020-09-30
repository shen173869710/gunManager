package com.auto.di.guan.manager.event;

public class DateChangeEvent {
    private boolean group;
    private int postion;

    public DateChangeEvent(boolean group) {
        this.group = group;
    }


    public DateChangeEvent(boolean group, int postion) {
        this.group = group;
        this.postion = postion;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    /**
     *    是否要更新组信息
     */

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }
}
