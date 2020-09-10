package com.auto.di.guan.manager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.MyGridAdapter;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.event.ControlEvent;
import com.auto.di.guan.manager.event.DeviceEvent;
import com.auto.di.guan.manager.event.GroupEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FragmentTab0 extends BaseFragment {

    @BindView(R.id.fragment_0_list)
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
    public void controlChange(ControlEvent event) {

    }

    @Override
    public void deviceChange(DeviceEvent event) {

    }

    @Override
    public void groupChange(GroupEvent event) {

    }


}
