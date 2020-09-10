package com.auto.di.guan.manager.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.event.ControlEvent;
import com.auto.di.guan.manager.event.DeviceEvent;
import com.auto.di.guan.manager.event.GroupEvent;


public class FragmentTab8 extends BaseFragment {

	private TextView read_desc;
	private Button read_data;
	private View view;
	private Activity activity;



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_8, null);
//		read_desc = (TextView)view.findViewById(R.id.read_desc);
//		read_data = (Button)view.findViewById(R.id.read_desc);
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
