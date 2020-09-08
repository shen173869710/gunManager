package com.auto.di.guan.manager.rtm;

import android.content.Context;
import android.util.Log;

import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.agora.rtm.ErrorInfo;
import io.agora.rtm.ResultCallback;
import io.agora.rtm.RtmClient;
import io.agora.rtm.RtmClientListener;
import io.agora.rtm.RtmFileMessage;
import io.agora.rtm.RtmImageMessage;
import io.agora.rtm.RtmMediaOperationProgress;
import io.agora.rtm.RtmMessage;
import io.agora.rtm.SendMessageOptions;

public class ChatManager {
    private static final String TAG = ChatManager.class.getSimpleName();

    private Context mContext;
    private RtmClient mRtmClient;
    private SendMessageOptions mSendMsgOptions;
    private List<RtmClientListener> mListenerList = new ArrayList<>();
    private RtmMessagePool mMessagePool = new RtmMessagePool();

    public ChatManager(Context context) {
        mContext = context;
    }

    public void init() {
        String appID = "2aa0369d8f7e48d2b993df37ca325897";

        try {
            mRtmClient = RtmClient.createInstance(mContext, appID, new RtmClientListener() {
                @Override
                public void onConnectionStateChanged(int state, int reason) {
                    for (RtmClientListener listener : mListenerList) {
                        listener.onConnectionStateChanged(state, reason);
                    }
                }

                @Override
                public void onMessageReceived(RtmMessage rtmMessage, String peerId) {
                    if (mListenerList.isEmpty()) {
                        mMessagePool.insertOfflineMessage(rtmMessage, peerId);
                    } else {
                        for (RtmClientListener listener : mListenerList) {
                            listener.onMessageReceived(rtmMessage, peerId);
                        }
                    }
                    LogUtils.e(TAG, "onMessageReceived   peerid = "+peerId + "message" +rtmMessage.getText());
                }

                @Override
                public void onImageMessageReceivedFromPeer(final RtmImageMessage rtmImageMessage, final String peerId) {
                    if (mListenerList.isEmpty()) {
                        // If currently there is no callback to handle this
                        // message, this message is unread yet. Here we also
                        // take it as an offline message.
                        mMessagePool.insertOfflineMessage(rtmImageMessage, peerId);
                    } else {
                        for (RtmClientListener listener : mListenerList) {
                            listener.onImageMessageReceivedFromPeer(rtmImageMessage, peerId);
                        }
                    }
                }

                @Override
                public void onFileMessageReceivedFromPeer(RtmFileMessage rtmFileMessage, String s) {

                }

                @Override
                public void onMediaUploadingProgress(RtmMediaOperationProgress rtmMediaOperationProgress, long l) {

                }

                @Override
                public void onMediaDownloadingProgress(RtmMediaOperationProgress rtmMediaOperationProgress, long l) {

                }

                @Override
                public void onTokenExpired() {

                }

                @Override
                public void onPeersOnlineStatusChanged(Map<String, Integer> status) {
                    LogUtils.e(TAG, "onPeersOnlineStatusChanged" + status.toString());
                    for (String key : status.keySet()) {
                        int code = status.get(key);
                        if (code == 0) {
                            LogUtils.e(TAG, "  当前用户ID  peerId = " + key + " 当前状态在线 ");
                        }else {
                            LogUtils.e(TAG, "  当前用户ID  peerId = " + key + " 当前状态离线 ");
                        }
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, Log.getStackTraceString(e));
            throw new RuntimeException("NEED TO check rtm sdk init fatal error\n" + Log.getStackTraceString(e));
        }

        // Global option, mainly used to determine whether
        // to support offline messages now.
        mSendMsgOptions = new SendMessageOptions();
    }

    public RtmClient getRtmClient() {
        return mRtmClient;
    }

    public void registerListener(RtmClientListener listener) {
        mListenerList.add(listener);
    }

    public void unregisterListener(RtmClientListener listener) {
        mListenerList.remove(listener);
    }

    public void enableOfflineMessage(boolean enabled) {
        mSendMsgOptions.enableOfflineMessaging = enabled;
    }

    public boolean isOfflineMessageEnabled() {
        return mSendMsgOptions.enableOfflineMessaging;
    }

    public SendMessageOptions getSendMessageOptions() {
        return mSendMsgOptions;
    }

    public List<RtmMessage> getAllOfflineMessages(String peerId) {
        return mMessagePool.getAllOfflineMessages(peerId);
    }

    public void removeAllOfflineMessages(String peerId) {
        mMessagePool.removeAllOfflineMessages(peerId);
    }

    /**
     *    用户登录
     */
    public void doRtmLogin() {
        mRtmClient.login(null, "222222", new ResultCallback<Void>() {
            @Override
            public void onSuccess(Void responseInfo) {
                LogUtils.e(TAG, "login success");
//                runOnUiThread(() -> {
//
//                });
            }

            @Override
            public void onFailure(ErrorInfo errorInfo) {
                LogUtils.e(TAG, "login failed: " + errorInfo.getErrorCode());
            }
        });
    }


    public void addPeersOnlineStatusListen(Set<String> user) {
        mRtmClient.subscribePeersOnlineStatus(user, new ResultCallback<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                LogUtils.e(TAG, "subscribePeersOnlineStatus: onSuccess" );
            }

            @Override
            public void onFailure(ErrorInfo errorInfo) {
                LogUtils.e(TAG, "subscribePeersOnlineStatus: onFailure" +errorInfo.getErrorDescription());
            }
        });
    }


    public void doLogout() {
        mRtmClient.logout(null);
        MessageUtil.cleanMessageListBeanList();
    }



    public void sendPeerMessage(String dst, String content) {
        final RtmMessage message = mRtmClient.createMessage();
        message.setText(content);
        SendMessageOptions option = new SendMessageOptions();
        option.enableOfflineMessaging = false;
        mRtmClient.sendMessageToPeer(dst, message, option, new ResultCallback<Void>() {

            @Override
            public void onSuccess(Void aVoid) {
                LogUtils.e(TAG, "sendPeerMessage : onSuccess");
            }

            @Override
            public void onFailure(ErrorInfo errorInfo) {
                Entiy.onPeerError(TAG, errorInfo.getErrorCode());
            }
        });
    }

}