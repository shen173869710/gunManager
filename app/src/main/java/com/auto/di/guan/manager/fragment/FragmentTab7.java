package com.auto.di.guan.manager.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.GunManagerAdapter;
import com.auto.di.guan.manager.entity.GunManager;
import com.auto.di.guan.manager.event.ControlEvent;
import com.auto.di.guan.manager.event.DeviceEvent;
import com.auto.di.guan.manager.event.GroupEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 *
 */
public class FragmentTab7 extends BaseFragment {

	@BindView(R.id.fragment_7_list)
	RecyclerView fragment7List;

    GunManagerAdapter adapter;

    String[] titles = {
            "地表殇情",
            "气象信息",
            "气温",
            "气压",
            "日照",
            "风向",
            "风速",
            "降雨量"
    };


    @Override
    public int setLayout() {
        return R.layout.fragment_7;
    }

    @Override
    public void init() {
		List<GunManager> list = new ArrayList<>();
		int length = titles.length;
		for (int i = 0; i < length; i++) {
			list.add(new GunManager(titles[i], "XXXX"));
		}
		adapter = new GunManagerAdapter(list);
		fragment7List.setLayoutManager(new LinearLayoutManager(getContext()));
		fragment7List.setAdapter(adapter);
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
