package com.auto.di.guan.manager.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.activity.AddLogActivity;
import com.auto.di.guan.manager.adapter.Tab2Adapter;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;

import butterknife.BindView;

public class ManagerTab2 extends BaseFragment {

    @BindView(R.id.title_bar_add)
    TextView titleBarAdd;

    @BindView(R.id.tab_2_list)
    RecyclerView tab2List;
    Tab2Adapter mAdapter;

    @Override
    public int setLayout() {
        return R.layout.manager_tab_2;
    }

    @Override
    public void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        mAdapter = new Tab2Adapter(null);
        tab2List.setAdapter(mAdapter);
        mAdapter.addChildClickViewIds(R.id.manager_item_login);
        mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {

            }
        });


        titleBarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, AddLogActivity.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public void dataChange(DateChangeEvent event) {

    }
}
