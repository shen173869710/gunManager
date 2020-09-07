package com.auto.di.guan.manager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.ChooseGridAdapter;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.db.GroupInfo;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.utils.LogUtils;
import com.auto.di.guan.manager.utils.NoFastClickUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ChooseGroupctivity extends Activity {
	private Button button;
	private GridView gridView;
	private ChooseGridAdapter adapter;
	private List<DeviceInfo> deviceInfos = new ArrayList<>();
	private GroupInfo groupInfo;
	private int groupId;
	View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_group_layout);

		groupId = getIntent().getIntExtra("groupId", 0);

		view = findViewById(R.id.title_bar);
		((TextView)view.findViewById(R.id.title_bar_title)).setText("设备分组");
		view.findViewById(R.id.title_bar_back_layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		button = (Button) findViewById(R.id.choose_ok);
		gridView = (GridView) findViewById(R.id.choose_gridview);
		LogUtils.e("----", ""+(new Gson().toJson(deviceInfos)));
		adapter = new ChooseGridAdapter(this, deviceInfos);
		gridView.setAdapter(adapter);
		groupInfo = new GroupInfo();
		gridView.setNumColumns(Entiy.GRID_COLUMNS);
		gridView.setHorizontalSpacing(0);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
		gridView.setLayoutParams(layoutParams);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(NoFastClickUtils.isFastClick()){
					return;
				}
				int count = 0;
				int size = deviceInfos.size();
				for (int i = 0; i < size; i++) {
					if (deviceInfos.get(i).getValveDeviceSwitchList().get(0).isSelect()) {
						count++;
					}
					if (deviceInfos.get(i).getValveDeviceSwitchList().get(1).isSelect()) {
						count++;
					}
				}
				if (count == 0) {
					Toast.makeText(ChooseGroupctivity.this, "没有选中设备",Toast.LENGTH_LONG).show();
					return;
				}

			}
		});
	}
}
