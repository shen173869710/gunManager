package com.auto.di.guan.manager.event;

import com.auto.di.guan.manager.db.DeviceInfo;

public class DeviceEvent {
    private DeviceInfo info;

    public DeviceInfo getInfo() {
        return info;
    }

    public void setInfo(DeviceInfo info) {
        this.info = info;
    }
}
