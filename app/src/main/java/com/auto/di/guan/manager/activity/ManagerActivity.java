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
import com.auto.di.guan.manager.basemodel.presenter.BasePresenter;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.utils.DensityUtil;
import com.auto.di.guan.manager.utils.GridSpaceItemDecoration;
import com.auto.di.guan.manager.utils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

public class ManagerActivity extends IBaseActivity {

    @BindView(R.id.title_bar_back_layout)
    RelativeLayout titleBarBackLayout;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.manager_list)
    RecyclerView managerList;

    private ManagerAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_manager;
    }

    @Override
    protected void init() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAvatar("");
            user.setProjectName("项目名称"+i);
            user.setPhonenumber("10000000"+i);

            if (i == 1 || i == 3 || i ==5) {
                user.setStatus(1);
            }
            users.add(user);
        }

        int count= DensityUtil.getWidth()/ DensityUtil.dip2px(this, 180);
        LogUtils.e("Main", "count ="+count);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this, count);
        // 添加间距
        managerList.addItemDecoration(new GridSpaceItemDecoration(count,
                DensityUtil.dip2px(this, 20),
                DensityUtil.dip2px(this, 20)));
        managerList.setLayoutManager(linearLayoutManager);
        mAdapter = new ManagerAdapter(users);
        managerList.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(ManagerActivity.this, MainActivity.class));
            }
        });
    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

}
