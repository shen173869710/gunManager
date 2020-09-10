package com.auto.di.guan.manager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.event.ControlEvent;
import com.auto.di.guan.manager.event.DeviceEvent;
import com.auto.di.guan.manager.event.GroupEvent;


/**
 *
 */
public class FragmentTab9 extends BaseFragment {
	private Button login_out;
	private View view;



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_9, null);
		login_out = (Button) view.findViewById(R.id.login_out);

		login_out.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				activity.finish();
			}
		});

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
