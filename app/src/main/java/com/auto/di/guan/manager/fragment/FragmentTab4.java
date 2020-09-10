package com.auto.di.guan.manager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.MyGridOpenAdapter;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.event.ControlEvent;
import com.auto.di.guan.manager.event.DeviceEvent;
import com.auto.di.guan.manager.event.GroupEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FragmentTab4 extends BaseFragment {
    private GridView mGridView;
    private View view;
    private MyGridOpenAdapter adapter;
    private List<DeviceInfo> deviceInfos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_0, null);
//        mGridView = (GridView) view.findViewById(R.id.fragment_0_gridview);
//       // deviceInfos = DeviceInfoSql.queryDeviceList();
//        adapter = new MyGridOpenAdapter(getActivity(), deviceInfos);
//        mGridView.setAdapter(adapter);
//        mGridView.setNumColumns(Entiy.GRID_COLUMNS);
//        EventBus.getDefault().register(this);
        return view;
    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onFragment4Update(Fragment4Event event) {
//        if (adapter != null) {
//            deviceInfos.clear();
//            deviceInfos.addAll(DeviceInfoSql.queryDeviceList());
//            adapter.notifyDataSetChanged();
//        }
//    }

    ;



    @Override
    public int setLayout() {
        return 0;
    }

    @Override
    public void init() {

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
