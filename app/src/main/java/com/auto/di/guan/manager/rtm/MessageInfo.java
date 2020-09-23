package com.auto.di.guan.manager.rtm;

import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.db.GroupInfo;
import com.auto.di.guan.manager.entity.CmdStatus;
import com.auto.di.guan.manager.socket.SocketResult;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
public class MessageInfo {

    private int type;
    private ControlInfo controlInfo;
    private GroupInfo groupInfo;
    private ArrayList<ControlInfo> controlInfos;
    private ArrayList<GroupInfo>groupInfos;
    private CmdStatus cmdStatus;
    private int postion;
    private List<SocketResult> socketResults;
    private ArrayList<DeviceInfo>deviceInfos;

    public ControlInfo getControlInfo() {
        return controlInfo;
    }

    public void setControlInfo(ControlInfo controlInfo) {
        this.controlInfo = controlInfo;
    }

    public GroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<ControlInfo> getControlInfos() {
        return controlInfos;
    }

    public void setControlInfos(ArrayList<ControlInfo> controlInfos) {
        this.controlInfos = controlInfos;
    }

    public ArrayList<GroupInfo> getGroupInfos() {
        return groupInfos;
    }

    public void setGroupInfos(ArrayList<GroupInfo> groupInfos) {
        this.groupInfos = groupInfos;
    }

    public CmdStatus getCmdStatus() {
        return cmdStatus;
    }

    public void setCmdStatus(CmdStatus cmdStatus) {
        this.cmdStatus = cmdStatus;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public ArrayList<DeviceInfo> getDeviceInfos() {
        return deviceInfos;
    }

    public void setDeviceInfos(ArrayList<DeviceInfo> deviceInfos) {
        this.deviceInfos = deviceInfos;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public List<SocketResult> getSocketResults() {
        return socketResults;
    }

    public void setSocketResults(List<SocketResult> socketResults) {
        this.socketResults = socketResults;
    }
}