package com.auto.di.guan.manager.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.activity.ManagerActivity;
import com.auto.di.guan.manager.adapter.Tab2Adapter;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ManagerTab2 extends BaseFragment {

    @BindView(R.id.tab_2_list)
    RecyclerView tab2List;
    Tab2Adapter mAdapter;
    private List<User> users;

    public static ManagerTab2 newInstance(Bundle bundle){
        ManagerTab2 fragment=new ManagerTab2();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int setLayout() {
        return R.layout.manager_tab_2;
    }

    @Override
    public void init() {
        users = (List<User>)getArguments().getSerializable(Entiy.INTENT_USER_LIST);
        if (users == null) {
            users = new ArrayList<>();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        mAdapter = new Tab2Adapter(null);
        tab2List.setAdapter(mAdapter);
        mAdapter.addChildClickViewIds(R.id.manager_item_login);
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {

            }
        });

        ManagerActivity managerActivity = (ManagerActivity) activity;
        managerActivity.setRightOnClick();
//        titleBarAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity, AddLogActivity.class);
//                intent.putExtra(Entiy.INTENT_USER_LIST, (Serializable) users);
//                activity.startActivity(intent);
//            }
//        });
    }

    @Override
    public void dataChange(DateChangeEvent event) {

    }
}
