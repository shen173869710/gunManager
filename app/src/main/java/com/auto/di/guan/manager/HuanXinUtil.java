package com.auto.di.guan.manager;

import android.text.TextUtils;
import android.util.Log;


import com.google.gson.Gson;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.chat.EMTextMessageBody;

import java.util.List;

public class HuanXinUtil {
    private static String TAG = "HuanXinUtil";
    public  static EMMessageListener msgListener = new EMMessageListener() {
        @Override
        public void onMessageReceived(List<EMMessage> messages) {
            //收到消息
            EMMessage message = messages.get(0);
            EMTextMessageBody body = (EMTextMessageBody) message.getBody();
            Log.e(TAG, "onMessageReceived------"+(body.getMessage()) );
            if (!TextUtils.isEmpty(body.getMessage()) && body.getMessage().contains("1111")) {
//                EMMessage emMessage = EMMessage.createTxtSendMessage("222222", "13300000001");
//                EMClient.getInstance().chatManager().sendMessage(emMessage);
            }
        }

        @Override
        public void onCmdMessageReceived(List<EMMessage> messages) {
            //收到透传消息
            Log.e(TAG, "onCmdMessageReceived------"+(new Gson().toJson(messages)) );
        }

        @Override
        public void onMessageRead(List<EMMessage> messages) {
            //收到已读回执
            Log.e(TAG, "onMessageRead------"+(new Gson().toJson(messages)) );
        }

        @Override
        public void onMessageDelivered(List<EMMessage> message) {
            //收到已送达回执
        }
        @Override
        public void onMessageRecalled(List<EMMessage> messages) {
            //消息被撤回
        }

        @Override
        public void onMessageChanged(EMMessage message, Object change) {
            //消息状态变动
            Log.e(TAG, "onMessageChanged------");
        }
    };


    public static void login() {
        EMClient.getInstance().login("13300000001","123456",new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.e(TAG, "登录聊天服务器成功！");
                //创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
//                EMMessage emMessage = EMMessage.createTxtSendMessage("收到111", "100");
//                EMClient.getInstance().chatManager().sendMessage(emMessage);
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.e(TAG, "登录聊天服务器失败！"+message);
            }
        });

        EMClient.getInstance().chatManager().addMessageListener(msgListener);
    }


    public static void stop(){
        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
    }

    public static void sendMessage(String msg) {
        EMMessage emMessage = EMMessage.createTxtSendMessage(msg, "13300000002");
        EMClient.getInstance().chatManager().sendMessage(emMessage);
    }
}
