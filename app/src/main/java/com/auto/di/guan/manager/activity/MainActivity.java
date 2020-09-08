package com.auto.di.guan.manager.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.fragment.ArticleListFragment;
import com.auto.di.guan.manager.rtm.ChatManager;

import java.util.HashSet;
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
        mChatManager.doRtmLogin();


        Set<String> user = new HashSet<>();
        user.add("111111");
        user.add("123456");
        user.add("333333");
        mChatManager.addPeersOnlineStatusListen(user);
    }


    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //HuanXinUtil.stop();
        mChatManager.doLogout();
    }

}
