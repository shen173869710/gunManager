package com.auto.di.guan.manager.entity;

import com.auto.di.guan.manager.utils.LogUtils;

/**
 * Created by Administrator on 2017/7/16.
 */

public class Entiy {
    /*设置项目的行数*/
    public static final int GUN_ROW = 16;
    /*设置项目的列数*/
    public static final int GUN_COLUMN = 16;
    /**设置项目的通讯id**/
    public static final String GUN_ID = "00002";
    /**设置项目的名称**/
    public static final String GUN_NAME= "测试项目";
    /**
     *   数据保存本地时间间隔 单位毫秒
     */
    public static final int DB_SAVE_TIME = 2 * 60 * 1000;
    /**
     *  自动查询 时间间隔 单位秒
     **/
    public static final int ALERM_TIME = 10 * 60;

    /**
     *   绑定     上开关  右
     *            下开关  右
     *            按下复位  写
     *
     *   操作     上开关  左
     *            按下复位
     *            操作
     *
     *
     *
     *
     */

    /**
     *  施肥管理相关参数设置
     */
    public static String [] PUMP_PRAM = {
            "参数1",
            "参数2",
            "参数3",
            "参数4"
    };


    /**
     * 操作的页面
     * 400  单个手动操作
     * 310  单个分组操作
     * 320  自动分组操作
     */

    /**
     *   设置轮灌时间比例时间 目前是分钟
     */
    public static final int RUN_TIME = 60;
    /**
     *   设置轮灌定时器  1000ms
     */
    public static final int RUN_TIME_COUNT = 1000;
    /**
     *    暂停轮灌计时
     */
    public static final int RUN_DO_STOP = 1;
    /**
     *    开启轮灌时间
     */
    public static final int RUN_DO_START = 2;
    /**
     *    自动轮灌完成
     */
    public static final int RUN_DO_NEXT = 3;
    /**
     *    自动轮灌完成
     */
    public static final int RUN_DO_FINISH = 4;
    /**
     *  报警信息
     */
    //  开阀异常
    public static final int VIDEO_OPEN_ERROR = 1;
    //  关阀异常
    public static final int VIDEO_CLOSE_ERROR =2;
    //  查询异常
    public static final int VIDEO_READ_ERROR = 5;

    public static String ALERM_ACTION = "com.auto.di.guan.utils.LongRunningService";
    public static int GRID_ROW = 3;
    public static int GRID_COLUMNS = 3;

//    public static String []TAB_TITLE = {"减阀控器",
//            "绑定阀门",
//            "轮灌分组",
//            "轮灌操作",
//            "手动操作",
//            "查询用户",
//            "水泵控制",
//            "施肥管理",
////            "读取参数",
//            "视频监控",
//            "农田管理",
//            "退出登录"
//    };

    public static String []TAB_TITLE = {
            "减阀状态",
            "轮灌分组",
            "轮灌设置",
            "单个操作",
            "单组操作",
            "自动轮灌",
            "操作信息",
            "农田信息",
            "水泵控制",
            "视频监控"
    };

    /**
     *    可以分组
     */
    public static final int LEVEL_2 = 200;
    /**
     *    可以轮灌
     */
    public static final int LEVEL_3 = 300;
    /**
     *    可以手动
     */
    public static final int LEVEL_4 = 400;
    /**
     *    可以分组 可以轮灌
     */
    public static final int LEVEL_2_3 = 500;
    /**
     *    可以分组 可以手动
     */
    public static final int LEVEL_2_4 = 700;
    /**
     *    可以轮灌 可以手动
     */
    public static final int LEVEL_3_4 = 800;
    /**
     *    可以分组 可以手动
     */
    public static final int LEVEL_2_3_4 = 900;

    /**
     *    群组状态 关闭
     */
    public static final int GROUP_STATUS_COLSE = 0;
    /**
     *    群组状态 开启
     */
    public static final int GROUP_STATUS_OPEN = 1;


    /**
     *    设备是否添加
     */
    public static final int DEVEICE_UNBIND = 0;
    /**
     *    设备已经添加
     */
    public static final int DEVEICE_BIND = 1;
    /**控制阀已经链接成功**/
    public static final int CONTROL_STATUS＿CONNECT = 100;
    /**设备已经处于运行状态**/
    public static final int CONTROL_STATUS＿RUN = 200;
    /**设备已经处于错误状态**/
    public static final int CONTROL_STATUS＿ERROR = 300;
    /**设备无法关闭**/
    public static final int CONTROL_STATUS＿NOTCLOSE = 400;
    /**设备断开链接**/
    public static final int CONTROL_STATUS＿DISCONNECT = 0;


    public static  String writeBid(String bid) {
        if (bid != null) {
            if (bid.length() == 1) {
                bid = "00"+bid;
            }else if (bid.length() ==2) {
                bid = "0"+bid;
            }
        }

        return "sbid"+bid;
    }

    public static  String getBid(String bid) {
        if (bid != null) {
            if (bid.length() == 1) {
                bid = "00"+bid;
            }else if (bid.length() ==2) {
                bid = "0"+bid;
            }
        }

        return bid;
    }

    public static  String writeGid(String gid) {
        if (gid != null) {
            if (gid.length() == 1) {
                gid = "00"+gid;
            }else if (gid.length() ==2) {
                gid = "0"+gid;
            }
        }
        return "sgid"+gid;
    }

    /**
     *        rs 012 004 0 01
     *        zt 012 004 xxxx
     *
     *        串命令“rs xxx xxx 0 01↙”(最后一个字符是”回车”)。其中第三个字符是空格符，第
             4、5、6字符是三位ASCII字符表示的一个0-255的数，该数是无线阀控器的项目
             ID, 第7个字符是空格，第8、9、10字符是三位ASCII字符表示的一个0-255的数，
             该数是无线阀控器的板ID, 第11个字符是空格，第12个字符是ASCII字符“0”,第
             13个字符是空格，第14和15字符是ASCII字符“0”和“1”。例如要查询项目ID为
             12，板ID为4的无线阀控器连接的2个电磁阀的状态可以使用以下命令
             “rs 012 004 0 01↙”。

     *         控制项目ID为12，板ID为4的无线阀控器收到“rs 012 004 0 01↙”命令，除
                 了查询2个连接的电磁阀的状态，还会向控制终端返馈以下字符串
                 “zt 012 004 xxxx↙”(最后一个字符是”回车”)，第12个字符是ASCII字符“0”或“1”，
                 如果是“0”，表明本阀控器第一个端口没有连接电磁阀，如果是“1”， 表明本阀控器
                 第一个端口有连接电磁阀，第13个字符是ASCII字符“0”或“1”， 如果是“0”，表明
                 本阀控器第2个端口没有连接电磁阀，如果是“1”， 表明本阀控器第2个端口有连
                 接电磁阀，第14个字符是ASCII字符“0”或“1”， 如果是“1”，表明本阀控器第一个
                 端口连接的电磁阀已打开，如果是“0”， 表明本阀控器第一个端口连接的电磁阀
                 已关闭。第15个字符是ASCII字符“0”或“1”， 如果是“1”，表明本阀控器第2个端
                 口连接的电磁阀已打开，如果是“0”， 表明本阀控器第2个端口连接的电磁阀已关
                 闭。

     * @param groupId
     * @param deviceId
     * @return
     */
    public static  String cmdRead(String groupId, String deviceId) {
        return "rs"+" "+groupId+" "+deviceId;
    }

    /**
     *       kf 012 004 0 01
     *       kf 012 004 0 ok
     * @param groupId
     * @param deviceId
     * @param deveiceName
     * @return
     */
    public static  String cmdOpen(String groupId, String deviceId, String deveiceName) {
        return "kf"+" "+groupId+" "+deviceId+" "+deveiceName;
    }

    /**
     *        gf 012 004 0 01
     *        gf 012 004 0 ok
     * @param groupId
     * @param deviceId
     * @param deveiceName
     * @return
     */
    public static  String cmdClose(String groupId, String deviceId, String deveiceName) {
        return "gf"+" "+groupId+" "+deviceId+" "+deveiceName;
    }

    /**
     * 操作的页面
     * 400  单个手动操作
     * 310  单个分组操作
     * 320  自动分组操作
     */
    public static int ACTION_TYPE_4 = 100;
    public static int ACTION_TYPE_31 = 31;
    public static int ACTION_TYPE_32 = 32;
    public static int ACTION_TYPE_ERROR = -1;




    /**
     *  根据项目位置生成通信ID
     * @return
     */
    public static  String createProtocalId(int id) {
        return String.format("%03d",id);
    }

    //对端已接收到点对点消息。
    public static int PEER_MESSAGE_ERR_OK = 0;
    public static String PEER_MESSAGE_ERR_OK_VALUE = "对端已接收到点对点消息";
    //发送点对点消息失败。
    public static int PEER_MESSAGE_ERR_FAILURE = 1;
    public static String PEER_MESSAGE_ERR_FAILURE_VALUE = "发送点对点消息失败";
    //发送点对点消息超时。超时时间设置为 10 秒。可能原因：用户正处于 CONNECTION_STATE_ABORTED 状态或 CONNECTION_STATE_RECONNECTING 状态。。
    public static int PEER_MESSAGE_ERR_TIMEOUT = 2;
    public static String PEER_MESSAGE_ERR_TIMEOUT_VALUE = "发送点对点消息超时。超时时间设置为 10 秒。可能原因：用户正处于 CONNECTION_STATE_ABORTED 状态或 CONNECTION_STATE_RECONNECTING 状态";
    //对方不在线，发出的点对点消息未被收到。
    public static int PEER_MESSAGE_ERR_PEER_UNREACHABLE = 3;
    public static String PEER_MESSAGE_ERR_PEER_UNREACHABLE_VALUE = "对方不在线，发出的点对点消息未被收到";
    //对方不在线，发出的离线点对点消息未被收到。但是服务器已经保存这条消息并将在用户上线后重新发送。
    public static int PEER_MESSAGE_ERR_CACHED_BY_SERVER = 4;
    public static String PEER_MESSAGE_ERR_CACHED_BY_SERVER_VALUE = "对方不在线，发出的离线点对点消息未被收到。但是服务器已经保存这条消息并将在用户上线后重新发送";
    //（RTM SDK for Android Java）发送消息（点对点消息和频道消息一并计算在内）超过 每 3 秒 180 次的上限。（RTM SDK for Linux Java）发送消息（点对点消息和频道消息一并计算在内）超过每 3 秒 1500 次的上限。
    public static int PEER_MESSAGE_ERR_TOO_OFTEN = 5;
    public static String PEER_MESSAGE_ERR_TOO_OFTEN_VALUE = "发送消息（点对点消息和频道消息一并计算在内）超过 每 3 秒 180 次的上限。（RTM SDK for Linux Java）发送消息（点对点消息和频道消息一并计算在内）超过每 3 秒 1500 次的上限";
    //用户 ID 无效。
    public static int PEER_MESSAGE_ERR_INVALID_USERID = 6;
    public static String PEER_MESSAGE_ERR_INVALID_USERID_VALUE = "用户 ID 无效";
    //消息为 null 或超出 32 KB 的长度限制。
    public static int PEER_MESSAGE_ERR_INVALID_MESSAGE = 7;
    public static String PEER_MESSAGE_ERR_INVALID_MESSAGE_VALUE = "消息为 null 或超出 32 KB 的长度限制";
    // SDK 未完成初始化。
    public static int PEER_MESSAGE_ERR_NOT_INITIALIZED = 101;
    public static String PEER_MESSAGE_ERR_NOT_INITIALIZED_VALUE = "SDK 未完成初始化";
    // 发送点对点消息前未调用 login 方法或者 login 方法调用未成功。
    public static int PEER_MESSAGE_ERR_USER_NOT_LOGGED_IN = 102;
    public static String PEER_MESSAGE_ERR_USER_NOT_LOGGED_IN_VALUE = "发送点对点消息前未调用 login 方法或者 login 方法调用未成功";

    public static void onPeerError(String TAG,int code) {
        switch (code) {
            case 0:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_OK_VALUE);
                break;
            case 1:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_FAILURE_VALUE);
                break;
            case 2:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_TIMEOUT_VALUE);
                break;
            case 3:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_PEER_UNREACHABLE_VALUE);
                break;
            case 4:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_CACHED_BY_SERVER_VALUE);
                break;
            case 5:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_TOO_OFTEN_VALUE);
                break;
            case 6:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_INVALID_USERID_VALUE);
                break;
            case 7:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_INVALID_MESSAGE_VALUE);
                break;
            case 101:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_NOT_INITIALIZED_VALUE);
                break;
            case 102:
                LogUtils.e(TAG, PEER_MESSAGE_ERR_USER_NOT_LOGGED_IN_VALUE);
                break;

        }
    }

}
