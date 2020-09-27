package com.auto.di.guan.manager.rtm;

import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.db.GroupInfo;
import com.auto.di.guan.manager.db.sql.ControlInfoSql;
import com.auto.di.guan.manager.db.sql.GroupInfoSql;
import com.auto.di.guan.manager.entity.CmdStatus;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.auto.di.guan.manager.event.LoginEvent;
import com.auto.di.guan.manager.socket.SocketBengEvent;
import com.auto.di.guan.manager.socket.SocketResult;
import com.auto.di.guan.manager.utils.LogUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 *     解析消息
 */
public class MessageParse {
    public static final String TAG = "MessageParse----app 同步信息--";

    public static void praseData(String data, String peerId) {
        MessageInfo info = new Gson().fromJson(data, MessageInfo.class);
        if (info == null) {
            LogUtils.e(TAG, "gson 数据解析异常");
            return;
        }
        switch (info.getType()) {
            case MessageEntiy.TYPE_LOGIN:
                // 登录
                if (info.getDeviceInfos() != null && info.getGroupInfos() != null) {
                    BaseApp.setDeviceInfos(info.getDeviceInfos());
                    BaseApp.setGroupInfos(info.getGroupInfos());
                    Entiy.GRID_COLUMNS = info.getCloumn();
                    EventBus.getDefault().post(new LoginEvent(true));
                    BaseApp.getInstance().getChatManager().setLoginId(peerId);
                }
                break;
            case MessageEntiy.TYPE_LOGOUT:
                // 登出
                EventBus.getDefault().post(new LoginEvent(false));
                break;
            case MessageEntiy.TYPE_SINGLE_READ:
                // 单个操作 读
            case MessageEntiy.TYPE_SINGLE_OPEN:
                // 单个操作 开
            case MessageEntiy.TYPE_SINGLE_CLOSE:
                // 单个操作 关
                if (info.getControlInfo() != null) {
                    dealSingle(info.getControlInfo());
                }
                break;
            case MessageEntiy.TYPE_GROUP_OPEN:
                LogUtils.e(TAG, "单组轮灌开启成功");
                // 单组操作 开
                dealSingle(info.getControlInfo());
                break;
            case MessageEntiy.TYPE_GROUP_CLOSE:
                LogUtils.e(TAG, "单组轮灌关闭成功");
                // 单组操作 关
                break;
            case MessageEntiy.TYPE_AUTO_OPEN:
                LogUtils.e(TAG, "自动轮灌开启成功");
                // 单组自动轮灌开
            case MessageEntiy.TYPE_AUTO_CLOSE:
                LogUtils.e(TAG, "自动轮灌关闭成功");
                // 单组自动轮灌 开始
            case MessageEntiy.TYPE_AUTO_START:
                LogUtils.e(TAG, "自动轮灌开始成功");
                // 单组自动轮灌 暂停
            case MessageEntiy.TYPE_AUTO_STOP:
                LogUtils.e(TAG, "自动轮灌暂停成功");
                // 单组自动轮灌 开始
            case MessageEntiy.TYPE_AUTO_NEXT:
                LogUtils.e(TAG, "自动轮灌下一组成功");
                // 单组自动轮灌 下一组
                if (info.getGroupInfos() != null && info.getControlInfos() != null) {
                    dealAuto(info.getControlInfos(), info.getGroupInfos());
                }
                break;

            case MessageEntiy.TYPE_CREATE_GROUP:
            case MessageEntiy.TYPE_DEL_GROUP:
            case MessageEntiy.TYPE_EXIT_GROUP:
            case MessageEntiy.TYPE_DISS_GROUP:
                dealGoupOption(info.getDeviceInfos(), info.getGroupInfos());
                break;
            case MessageEntiy.TYPE_GROUP_LEVEL:
                if (info.getGroupInfos() != null) {
                    dealGoupLevel(info.getGroupInfos());
                }

            case MessageEntiy.TYPE_BENG_CLOSE:
            case MessageEntiy.TYPE_BENG_OPEN:
                if (info.getSocketResults()!= null) {
                    dealBengOption(info.getSocketResults());
                }
            case MessageEntiy.TYPE_MESSAGE:
                if (info.getCmdStatus() != null) {
                    dealMessage(info.getCmdStatus());
                }
                break;
        }
    }



    /**
     *   处理单个操作
     */
    public static void dealSingle(ControlInfo controlInfo) {
        LogUtils.e(TAG, "单个操作成功");
        ControlInfoSql.updataControlInfo(controlInfo);
        EventBus.getDefault().post(new DateChangeEvent(false));
    }

    /**
     *  处理单组操作
     */
    public static void dealGroup(List<ControlInfo>list, GroupInfo groupInfo) {
        LogUtils.e(TAG, "单组操作成功");
        ControlInfoSql.updataControlList(list);
        GroupInfoSql.updateGroup(groupInfo);
        EventBus.getDefault().post(new DateChangeEvent(true));
    }

    /**
     *  处理自动轮灌
     */
    public static void dealAuto(List<ControlInfo>list, List<GroupInfo> infos) {
        ControlInfoSql.updataControlList(list);
        GroupInfoSql.updateGroups(infos);
        EventBus.getDefault().post(new DateChangeEvent(true));
    }

    /**
     *        处理操作信息同步
     * @param cmdStatus
     */
    public static void dealMessage(CmdStatus cmdStatus) {
        EventBus.getDefault().post(cmdStatus);
    }

    /**
     *  同步 组设置相关信息
     */
    public static void dealGoupOption(ArrayList<DeviceInfo>deviceInfos, ArrayList<GroupInfo> groupInfos) {
        BaseApp.setDeviceInfos(deviceInfos);
        BaseApp.setGroupInfos(groupInfos);
        EventBus.getDefault().post(new DateChangeEvent(true));
    }

    public static void dealGoupLevel(ArrayList<GroupInfo> groupInfos) {
        BaseApp.setGroupInfos(groupInfos);
        EventBus.getDefault().post(new DateChangeEvent(true));
    }

    /**
     *        处理开泵相关信息
     * @param socketResults
     */
    public static void dealBengOption(List<SocketResult> socketResults) {
        EventBus.getDefault().post(new SocketBengEvent(socketResults));
    }
}
