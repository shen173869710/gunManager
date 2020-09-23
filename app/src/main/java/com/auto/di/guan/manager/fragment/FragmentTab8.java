package com.auto.di.guan.manager.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.GunManagerAdapter;
import com.auto.di.guan.manager.entity.GunManager;
import com.auto.di.guan.manager.event.DateChangeEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FragmentTab8 extends BaseFragment {
	@BindView(R.id.fragment_8_list)
	RecyclerView fragment8List;

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
		return R.layout.fragment_8;
	}

	@Override
	public void init() {
		List<GunManager> list = new ArrayList<>();
		int length = titles.length;
		for (int i = 0; i < length; i++) {
			list.add(new GunManager(titles[i], "XXXX"));
		}
		adapter = new GunManagerAdapter(list);
		fragment8List.setLayoutManager(new LinearLayoutManager(getContext()));
		fragment8List.setAdapter(adapter);
	}

	@Override
	public void dataChange(DateChangeEvent event) {

	}
}
