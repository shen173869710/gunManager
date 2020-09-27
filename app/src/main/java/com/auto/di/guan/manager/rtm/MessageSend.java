package com.auto.di.guan.manager.rtm;

import com.auto.di.guan.manager.activity.IBaseActivity;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.db.GroupInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageSend {
    public static void send(MessageInfo info) {
        BaseApp.getInstance().getChatManager().sendPeerMessage(info.toJson());
    }


    public static void send(MessageInfo info, String loginId) {
        BaseApp.getInstance().getChatManager().sendLoginPeerMessage(loginId,info.toJson());
    }

    /**
     *  登录
     */
    public static void doLogin(IBaseActivity baseActivity, String loginId) {
        MessageInfo info  = new MessageInfo();
        info.setType(MessageEntiy.TYPE_LOGIN);
        info.setManagerId(BaseApp.getUser().getUserId());
        send(info,loginId);
        baseActivity.showDialog();
    }

    /**
     *  管理员登出
     */
    public static void doLogout() {
        MessageInfo info  = new MessageInfo();
        info.setType(MessageEntiy.TYPE_LOGOUT);
        info.setManagerId(BaseApp.getUser().getUserId());
        send(info);
    }

    /**
     *        单个读
     */
    public static void doSingleRead(ControlInfo controlInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_SINGLE_READ);
        info.setControlInfo(controlInfo);
        send(info);
    }

    /**
     *        单个开
     */
    public static void doSingleOpen(ControlInfo controlInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_SINGLE_OPEN);
        info.setControlInfo(controlInfo);
        send(info);
    }
    /**
     *        单个关
     */
    public static void doSingleClose(ControlInfo controlInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_SINGLE_CLOSE);
        info.setControlInfo(controlInfo);
        send(info);
    }
    /**
     *        单组开
     */
    public static void doGroupOpen(GroupInfo groupInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_GROUP_OPEN);
        info.setGroupInfo(groupInfo);
        send(info);
    }

    /**
     *        单组关
     */
    public static void doGroupClose(GroupInfo groupInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_GROUP_CLOSE);
        info.setGroupInfo(groupInfo);
        send(info);
    }

    /**
     *        自动轮灌开
     */
    public static void doAutoOpen() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_OPEN);
        send(info);
    }

    /**
     *        自动轮灌暂停
     */
    public static void doAutoStop() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_STOP);
        send(info);
    }

    /**
     *        自动轮灌开始
     */
    public static void doAutoStart() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_START);
        send(info);
    }

    /**
     *        自动轮灌开始
     */
    public static void doAutoClose() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_CLOSE);
        send(info);
    }

    /**
     *        自动轮灌下一组
     */
    public static void doAutoNext() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_NEXT);
        send(info);
    }

    /**
     *        设置自动轮灌时间
     * @param groupInfo
     */
    public static void doAutoTime(GroupInfo groupInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_TIME);
        info.setGroupInfo(groupInfo);
        send(info);
    }


    /**
     *       自动查询开
     */
    public static void doAutoPollStart() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_POLL_START);
        send(info);
    }

    /**
     *       自动查询关
     */
    public static void doAutoPollClose() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_POLL_CLOSE);
        send(info);
    }

    /**
     *        创建一个分组
     * @param groupInfo
     */
    public static void doCreateGroup(GroupInfo groupInfo, ArrayList<DeviceInfo> deviceInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_CREATE_GROUP);
        info.setGroupInfo(groupInfo);
        info.setDeviceInfos(deviceInfos);
        send(info);
    }

    /**
     *        删除全部分组
     */
    public static void doDelGroup() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_DEL_GROUP);
        send(info);
    }

    /**
     *         退出当前组
     * @param controlInfo
     */
    public static void doExitGroup(ControlInfo controlInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_EXIT_GROUP);
        info.setControlInfo(controlInfo);
        send(info);
    }

    /**
     *       解散一个小组
     */
    public static void doDissGroup(GroupInfo groupInfo) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_DISS_GROUP);
        info.setGroupInfo(groupInfo);
        send(info);
    }

    /**
     *    轮灌设置相关
     */
    public static void doGroupLevel(List<GroupInfo> groupInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_GROUP_LEVEL);
//        info.setGroupInfos(groupInfos);
        send(info);
    }


    /**
     *  开泵
     */
    public static void doBengOpen(int postion) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_BENG_OPEN);
        info.setPostion(postion);
        send(info);
    }

    /**
     *  开泵
     */
    public static void doBengClose(int postion) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_BENG_CLOSE);
        info.setPostion(postion);
        send(info);
    }

}
