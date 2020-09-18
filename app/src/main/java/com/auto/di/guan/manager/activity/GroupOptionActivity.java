package com.auto.di.guan.manager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.RecyclerListAdapter;
import com.auto.di.guan.manager.db.GroupInfo;
import com.auto.di.guan.manager.db.sql.GroupInfoSql;
import com.auto.di.guan.manager.rtm.MessageSend;
import com.auto.di.guan.manager.utils.LogUtils;
import com.auto.di.guan.manager.utils.NoFastClickUtils;
import com.auto.di.guan.manager.utils.SPUtils;
import com.auto.di.guan.manager.utils.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *  设置轮灌相关参数
 */
public class GroupOptionActivity extends Activity  {

	private static final String TAG = "GroupOptionActivity";
	private View view;
	private TextView textView;
	private TextView title_bar_status;
	private RecyclerView recyclerView;
	private List<GroupInfo> groupInfos = new ArrayList<>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_group_option_layout);
		view = findViewById(R.id.title_bar);

		groupInfos = GroupInfoSql.getJoinGroup();

		textView = (TextView)view.findViewById(R.id.title_bar_title);
		textView.setText("自动轮灌设置");
		title_bar_status  = (TextView)view.findViewById(R.id.title_bar_status);
		title_bar_status.setVisibility(View.VISIBLE);
		title_bar_status.setText("保存设置");
		title_bar_status.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(NoFastClickUtils.isFastClick()){
					return;
				}
				int size = groupInfos.size();
				HashMap<Integer, Integer> lv = new HashMap<>();
				for (int i = 0; i < size; i++) {
					GroupInfo groupInfo = groupInfos.get(i);
					if (groupInfo.getGroupIsJoin()) {
						if (groupInfo.getGroupTime() == 0 || groupInfo.getGroupLevel() == 0) {
							ToastUtils.showLongToast("轮灌优先级或者轮灌时长不能为0");
							return;
						}
					}else {
						groupInfo.setGroupRunTime(0);
						groupInfo.setGroupLevel(0);
						groupInfo.setGroupTime(0);
					}

					int level = groupInfo.getGroupLevel();
					if (level > 0) {
						if (lv.containsKey(level)) {
							ToastUtils.showLongToast("不能设置相同的轮灌优先级,或者优先级不能为空");
							return;
						}
						lv.put(level,level);
					}
				}

				MessageSend.doGroupLevel(groupInfos);
			}
		});
		view.findViewById(R.id.title_bar_back_layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				GroupOptionActivity.this.finish();
			}
		});
		recyclerView = (RecyclerView) findViewById(R.id.group_option_view);
		RecyclerListAdapter adapter = new RecyclerListAdapter(groupInfos);
		recyclerView.setHasFixedSize(true);
		recyclerView.setAdapter(adapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
	}



}
