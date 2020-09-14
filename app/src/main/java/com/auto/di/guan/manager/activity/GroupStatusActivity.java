package com.auto.di.guan.manager.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.GroupStatusAdapter;
import com.auto.di.guan.manager.adapter.StatusAdapter;
import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.GroupInfo;
import com.auto.di.guan.manager.db.sql.GroupInfoSql;
import com.auto.di.guan.manager.dialog.GroupOptionDialog;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.auto.di.guan.manager.utils.DiffStatusCallback;
import com.auto.di.guan.manager.utils.NoFastClickUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 *   轮灌设置
 */
public class GroupStatusActivity extends FragmentActivity {
    private View view;
    private TextView textView;
    private TextView title_bar_status;
    private RecyclerView recyclerView;
    private List<GroupInfo> groupInfos = new ArrayList<>();
    private GroupStatusAdapter adapter;

    private StatusAdapter openAdapter;
    private RecyclerView openList;
    private StatusAdapter closeAdapter;
    private RecyclerView closeList;

    private List<ControlInfo> openInfos = new ArrayList<>();
    private List<ControlInfo> closeInfos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_status_layout);

        view = findViewById(R.id.title_bar);
        EventBus.getDefault().register(this);

        textView = (TextView) view.findViewById(R.id.title_bar_title);
        textView.setText("自动轮灌状态");

        title_bar_status = (TextView) view.findViewById(R.id.title_bar_status);
        title_bar_status.setVisibility(View.VISIBLE);
        title_bar_status.setText("轮灌操作");
        title_bar_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NoFastClickUtils.isFastClick()){
                    return;
                }
                GroupOptionDialog.ShowDialog(GroupStatusActivity.this, "自动轮灌操作", new GroupOptionDialog.ItemClick() {
                    @Override
                    public void onItemClick(int index) {

                    }
                });
            }
        });
        view.findViewById(R.id.title_bar_back_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GroupStatusActivity.this.finish();
            }
        });

        groupInfos = GroupInfoSql.getJoinGroup();
        recyclerView = (RecyclerView) findViewById(R.id.group_option_view);
        adapter = new GroupStatusAdapter(groupInfos);
        adapter.setDiffCallback(new DiffStatusCallback());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        openList = findViewById(R.id.group_option_open);
        openList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        openAdapter = new StatusAdapter(openInfos);
        openList.setAdapter(openAdapter);

        closeList = findViewById(R.id.group_option_close);
        closeList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        closeAdapter = new StatusAdapter(closeInfos);
        closeList.setAdapter(closeAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGroupEvent(DateChangeEvent event) {

    }
}
