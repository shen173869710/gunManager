package com.auto.di.guan.manager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.event.ControlEvent;
import com.auto.di.guan.manager.event.DeviceEvent;
import com.auto.di.guan.manager.event.GroupEvent;


/**
 *
 */
public class FragmentTab7 extends BaseFragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_7, null);
		return view;
	}


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


}
