package com.auto.di.guan.manager.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.db.GroupInfo;
import com.auto.di.guan.manager.fragment.ArticleListFragment;
import com.auto.di.guan.manager.rtm.ChatManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    public static int windowTop;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private final String TAG = "MainActivity";

    private ChatManager mChatManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        windowTop = getStatusBarHeight();
        //HuanXinUtil.login();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        final ArticleListFragment articleListFragment = new ArticleListFragment();
        transaction.add(R.id.center, articleListFragment, "center");
        transaction.commitAllowingStateLoss();

        mChatManager = BaseApp.getInstance().getChatManager();
        findViewById(R.id.title_bar_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChatManager.sendPeerMessage("123456", "来着222222222的消息");
            }
        });
        mChatManager.doLogin();


        Set<String> user = new HashSet<>();
        user.add("111111");
        user.add("123456");
        user.add("333333");
        mChatManager.addPeersOnlineStatusListen(user);

        inttTest();
    }

    private void inttTest() {

        List<DeviceInfo> deviceInfos = new ArrayList<>();
       for (int i = 1; i < 10; i++) {
           DeviceInfo deviceInfo = new DeviceInfo();
           deviceInfo.setDeviceId(i);
           deviceInfo.setDeviceSort(i);
           deviceInfo.setDeviceStatus(i);
           deviceInfo.setDeviceName(i+"");
           ControlInfo info1 = new ControlInfo();
           info1.setDevice_id(i);
           info1.setDevice_id(deviceInfo.getDeviceId());
           info1.setValve_name("0");
           info1.setValve_status(1);
           info1.setValve_alias(i+"-"+1);
           ControlInfo info2 = new ControlInfo();
           info2.setDevice_id(i);
           info2.setDevice_id(deviceInfo.getDeviceId());
           info2.setValve_name("1");
           info2.setValve_alias(i+"-"+2);
           info2.setValve_status(1);
           ArrayList<ControlInfo> controlInfos = new ArrayList<>(2);

           int id = 0;
           if (i < 3) {
               id = 1;
           }else if ( i >= 3 && i < 5) {
               id = 2;
           }else if ( i >= 5 && i < 7) {
               id = 3;
           }else if ( i >= 7 && i < 8) {
               id = 4;
           }else {
               id = 5;
           }
           info1.setValve_group_id(id);
           info2.setValve_group_id(id);
           controlInfos.add(info1);
           controlInfos.add(info2);
           deviceInfo.setValveDeviceSwitchList(controlInfos);
           deviceInfos.add(deviceInfo);
       }

        ArrayList<GroupInfo> groupInfos = new ArrayList<>();
       for (int i = 1; i < 6; i++) {
           GroupInfo groupInfo = new GroupInfo();
           groupInfo.setGroupId(i);
           groupInfo.setGroupIsJoin(true);
           groupInfo.setGroupLevel(i);
           groupInfo.setGroupName(i+"");
           groupInfo.setGroupRunTime(0);
           groupInfo.setGroupTime(i + 60);
           groupInfos.add(groupInfo);
       }
       BaseApp.setDeviceInfos(deviceInfos);
        BaseApp.setGroupInfos(groupInfos);
    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //HuanXinUtil.stop();
//        mChatManager.doLogout();
//    }

}
