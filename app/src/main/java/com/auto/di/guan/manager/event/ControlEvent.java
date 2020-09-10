package com.auto.di.guan.manager.event;

import com.auto.di.guan.manager.db.ControlInfo;

import java.util.List;

public class ControlEvent {
    private List<ControlInfo> list;
    public List<ControlInfo> getList() {
        return list;
    }
    public void setList(List<ControlInfo> list) {
        this.list = list;
    }
}
