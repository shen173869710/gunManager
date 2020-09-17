package com.auto.di.guan.manager.rtm;

import com.auto.di.guan.manager.activity.IBaseActivity;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.GroupInfo;
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
        MessageLoginInfo info  = new MessageLoginInfo();
        info.setType(MessageEntiy.TYPE_LOGIN);
        info.setManagerId(BaseApp.getUser().getUserId());
        BaseApp.getInstance().getChatManager().sendPeerMessage(info.toJson());
        send(info,loginId);
        baseActivity.showDialog();
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

}
