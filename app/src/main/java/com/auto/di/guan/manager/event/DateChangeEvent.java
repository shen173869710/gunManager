package com.auto.di.guan.manager.event;

public class DateChangeEvent {

    public DateChangeEvent(boolean group) {
        this.group = group;
    }

    /**
     *    是否要更新组信息
     */
    private boolean group;
    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }
}
