package com.auto.di.guan.manager.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.ManagerAdapter;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.presenter.ManagerPresenter;
import com.auto.di.guan.manager.basemodel.view.IBaseView;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.event.LoginEvent;
import com.auto.di.guan.manager.event.UserStatusEvent;
import com.auto.di.guan.manager.rtm.ChatManager;
import com.auto.di.guan.manager.rtm.MessageSend;
import com.auto.di.guan.manager.utils.DensityUtil;
import com.auto.di.guan.manager.utils.GridSpaceItemDecoration;
import com.auto.di.guan.manager.utils.LogUtils;
import com.auto.di.guan.manager.utils.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;

public class ManagerActivity extends IBaseActivity<ManagerPresenter> implements IBaseView {

    @BindView(R.id.title_bar_back_layout)
    RelativeLayout titleBarBackLayout;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.manager_list)
    RecyclerView managerList;
    private ManagerAdapter mAdapter;

    private ChatManager mChatManager;

    private List<User> users = new ArrayList<>();
    @Override
    protected int setLayout() {
        return R.layout.activity_manager;
    }

    @Override
    protected void init() {
        users = (List<User>) getIntent().getSerializableExtra("list");
        titleBarTitle.setText("轮灌操作");
        int count= DensityUtil.getWidth()/ DensityUtil.dip2px(this, 180);
        LogUtils.e("Main", "count ="+count);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, count);
        // 添加间距
        managerList.addItemDecoration(new GridSpaceItemDecoration(count, DensityUtil.dip2px(this, 20), DensityUtil.dip2px(this, 20)));
        managerList.setLayoutManager(linearLayoutManager);
        mAdapter = new ManagerAdapter(users);
        managerList.setAdapter(mAdapter);

        mAdapter.addChildClickViewIds(R.id.manager_item_login);
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.manager_item_login){
                    User user = users.get(position);
                    if (user.getLoginStatus() != 0) {
                        ToastUtils.showLongToast("用户不在线");
                        return;
                    }
                    MessageSend.doLogin(ManagerActivity.this, users.get(position).getUserId().toString());
                }
            }
        });
        mChatManager = BaseApp.getInstance().getChatManager();
        mChatManager.doLogin();
        Set<String> user = new HashSet<>();
        int size = users.size();
        for (int i = 0; i < size; i++) {
            user.add(users.get(i).getUserId().toString());
        }
        mChatManager.addPeersOnlineStatusListen(user);
    }

    @Override
    protected ManagerPresenter createPresenter() {
        return new ManagerPresenter();
    }


    @Override
    public void success(BaseRespone respone) {

    }

    @Override
    public void fail(Throwable error, Integer code, String msg) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEvent(LoginEvent event) {
        if (event.isLogin()) {
            dismissDialog();
            startActivity(new Intent(ManagerActivity.this, MainActivity.class));
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserStatusEvent(UserStatusEvent event) {
        int size = users.size();
        for (int i = 0; i < size; i++) {
            User user = users.get(i);
            if (event.getPeerId().equals(user.getUserId().toString())) {
                user.setLoginStatus(event.getStatus());
            }
        }
        if (mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mChatManager != null) {
            mChatManager.doLogout();
        }
    }
}
