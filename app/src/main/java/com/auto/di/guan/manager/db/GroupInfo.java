package com.auto.di.guan.manager.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2017/7/9.
 */

public class GroupInfo {
    private Long id;
    private int groupId;
    private String groupName;
    /**轮灌的状态 **/
    private int groupStatus;
    private int groupImage;
    /** 轮灌优先级**/
    private int groupLevel;
    /** 运行的总时间**/
    private int groupTime;
    /** 已经运行的时间**/
    private int groupRunTime;
    // 是否参与轮灌设置
    private boolean groupIsJoin;
    /**轮灌是否已经暂停计时**/
    private boolean groupStop;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getGroupId() {
        return this.groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return this.groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public int getGroupStatus() {
        return this.groupStatus;
    }
    public void setGroupStatus(int groupStatus) {
        this.groupStatus = groupStatus;
    }
    public int getGroupImage() {
        return this.groupImage;
    }
    public void setGroupImage(int groupImage) {
        this.groupImage = groupImage;
    }
    public int getGroupLevel() {
        return this.groupLevel;
    }
    public void setGroupLevel(int groupLevel) {
        this.groupLevel = groupLevel;
    }
    public int getGroupTime() {
        return this.groupTime;
    }
    public void setGroupTime(int groupTime) {
        this.groupTime = groupTime;
    }
    public int getGroupRunTime() {
        return this.groupRunTime;
    }
    public void setGroupRunTime(int groupRunTime) {
        this.groupRunTime = groupRunTime;
    }
    public boolean getGroupIsJoin() {
        return this.groupIsJoin;
    }
    public void setGroupIsJoin(boolean groupIsJoin) {
        this.groupIsJoin = groupIsJoin;
    }
    public boolean getGroupStop() {
        return this.groupStop;
    }
    public void setGroupStop(boolean groupStop) {
        this.groupStop = groupStop;
    }

}
