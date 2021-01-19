package com.auto.di.guan.manager.fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.MyGridAdapter;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.auto.di.guan.manager.utils.LogUtils;

import butterknife.BindView;

public class FragmentTab0 extends BaseFragment {
    @BindView(R.id.fragment_0_gridview)
    RecyclerView fragment0List;
    private MyGridAdapter adapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_0;
    }

    @Override
    public void init() {
        LinearLayoutManager manager = new GridLayoutManager(activity, Entiy.GRID_COLUMNS);
        fragment0List.setLayoutManager(manager);
        adapter = new MyGridAdapter(BaseApp.getDeviceInfos());
        fragment0List.setAdapter(adapter);
    }

    @Override
    public void dataChange(DateChangeEvent event) {
        LogUtils.e("FragmentTab0", "更新组信息");
        adapter = new MyGridAdapter(BaseApp.getDeviceInfos());
        fragment0List.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
