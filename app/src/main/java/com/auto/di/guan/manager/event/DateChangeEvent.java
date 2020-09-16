package com.auto.di.guan.manager.event;

public class DateChangeEvent {
    /**
     *    是否是单个操作
     */
    private boolean singleType;
    private boolean group;


    public DateChangeEvent(boolean singleType) {
        this.singleType = singleType;
    }

    public boolean isSingleType() {
        return singleType;
    }

    public void setSingleType(boolean singleType) {
        this.singleType = singleType;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }
}
