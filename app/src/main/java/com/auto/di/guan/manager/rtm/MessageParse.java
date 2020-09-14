package com.auto.di.guan.manager.rtm;

import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.sql.ControlInfoSql;
import com.auto.di.guan.manager.event.LoginEvent;
import com.auto.di.guan.manager.utils.LogUtils;
import com.google.gson.Gson;
import org.greenrobot.eventbus.EventBus;

/**
 *     解析消息
 */
public class MessageParse {
    public static final String TAG = "MessageParse";

    public static void praseData(String data) {
        MessageInfo info = new Gson().fromJson(data, MessageInfo.class);
        if (info == null) {
            LogUtils.e(TAG, "gson 数据解析异常");
            return;
        }
        switch (info.getType()) {
            case MessageEntiy.TYPE_LOGIN:
                // 登录
                EventBus.getDefault().post(new LoginEvent(true));
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
                break;
            case MessageEntiy.TYPE_GROUP_OPEN:
                // 单组操作 开
                break;
            case MessageEntiy.TYPE_GROUP_CLOSE:
                // 单组操作 关
                break;
            case MessageEntiy.TYPE_AUTO_OPEN:
                // 单组自动轮灌开
                break;
            case MessageEntiy.TYPE_AUTO_STOP:
                // 单组自动轮灌 暂停
                break;
            case MessageEntiy.TYPE_AUTO_START:
                // 单组自动轮灌 开始
                break;
            case MessageEntiy.TYPE_AUTO_NEXT:
                // 单组自动轮灌 下一组
                break;
            case MessageEntiy.TYPE_MESSAGE:
                // 单组自动轮灌 下一组
                break;
        }
    }

    /**
     *   处理单个操作
     */
    public static void dealSingle(ControlInfo controlInfo) {
        ControlInfoSql.updataControlInfo(controlInfo);
//        EventBus.getDefault().post(new ControlEvent());
    }

}
