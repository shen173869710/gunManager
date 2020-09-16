package com.auto.di.guan.manager.rtm;

import com.auto.di.guan.manager.activity.IBaseActivity;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.GroupInfo;
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
        MessageLoginInfo info  = new MessageLoginInfo();
        info.setType(MessageEntiy.TYPE_LOGIN);
        info.setManagerId(BaseApp.getUser().getUserId());
        BaseApp.getInstance().getChatManager().sendPeerMessage(info.toJson());
        send(info,loginId);
        baseActivity.showDialog();
    }

    /**
     *        单个读
     * @param controlInfos
     */
    public static void doSingleRead(ArrayList<ControlInfo> controlInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_SINGLE_READ);
        info.setControlInfos(controlInfos);
        send(info);
    }

    /**
     *        单个开
     * @param controlInfos
     */
    public static void doSingleOpen(ArrayList<ControlInfo> controlInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_SINGLE_OPEN);
        info.setControlInfos(controlInfos);
        send(info);
    }

    /**
     *        单个关
     * @param controlInfos
     */
    public static void doSingleClose(ArrayList<ControlInfo> controlInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_SINGLE_CLOSE);
        info.setControlInfos(controlInfos);
        send(info);
    }

    /**
     *        单组开
     * @param controlInfos
     */
    public static void doGroupOpen(ArrayList<ControlInfo> controlInfos, List<GroupInfo> groupInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_GROUP_OPEN);
        info.setGroupInfos(groupInfos);
        info.setControlInfos(controlInfos);
        send(info);
    }

    /**
     *        单组开
     * @param controlInfos
     */
    public static void doGroupClose(ArrayList<ControlInfo> controlInfos, List<GroupInfo> groupInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_GROUP_CLOSE);
        info.setGroupInfos(groupInfos);
        info.setControlInfos(controlInfos);
        send(info);
    }

    /**
     *        自动轮灌开
     * @param controlInfos
     * @param groupInfos
     */
    public static void doAutoOpen(ArrayList<ControlInfo> controlInfos, List<GroupInfo> groupInfos) {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_OPEN);
        info.setGroupInfos(groupInfos);
        info.setControlInfos(controlInfos);
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
     *        自动轮灌下一组
     */
    public static void doAutoNext() {
        MessageInfo info = new MessageInfo();
        info.setType(MessageEntiy.TYPE_AUTO_NEXT);
        send(info);
    }




}
