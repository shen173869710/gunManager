package com.auto.di.guan.manager.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.activity.ManagerActivity;
import com.auto.di.guan.manager.adapter.ManagerAdapter;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.auto.di.guan.manager.event.UserStatusEvent;
import com.auto.di.guan.manager.rtm.MessageSend;
import com.auto.di.guan.manager.utils.DensityUtil;
import com.auto.di.guan.manager.utils.GridSpaceItemDecoration;
import com.auto.di.guan.manager.utils.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ManagerTab1 extends BaseFragment {

    @BindView(R.id.manager_list)
    RecyclerView managerList;
    private ManagerAdapter mAdapter;

    private List<User> users;

    public static ManagerTab1 getInstance(Bundle bundle){
        ManagerTab1 fragment=new ManagerTab1();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public int setLayout() {
        return R.layout.manager_tab_1;
    }

    @Override
    public void init() {
        Bundle bundle = getArguments();
        users = (List<User>)bundle.getSerializable("list");
        if (users == null) {
            users = new ArrayList<>();
        }
        int count= DensityUtil.getWidth()/ DensityUtil.dip2px(activity, 180);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(activity, count);
        if (count < 5) {
            count = 5;
        }
        managerList.addItemDecoration(new GridSpaceItemDecoration(count, DensityUtil.dip2px(activity, 10), DensityUtil.dip2px(activity, 10)));
        managerList.setLayoutManager(linearLayoutManager);
        mAdapter = new ManagerAdapter(users);
        managerList.setAdapter(mAdapter);
//        mAdapter.addChildClickViewIds(R.id.manager_item_login);
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.manager_item_login){
                    User user = users.get(position);
                    if (user.getLoginStatus() != 0) {
                        ToastUtils.showLongToast("用户不在线");
                        return;
                    }

                    ManagerActivity managerActivity = (ManagerActivity)activity;
                    managerActivity.showWaitingDialog("");
                    MessageSend.doLogin((users.get(position).getUserId().toString()));
                }
            }
        });
    }

    @Override
    public void dataChange(DateChangeEvent event) {

    }


    /**
     *        用户状态变化
     * @param event
     */
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



}