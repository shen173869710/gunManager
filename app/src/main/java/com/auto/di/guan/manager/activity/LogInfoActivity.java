package com.auto.di.guan.manager.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.basemodel.model.respone.RaiseCropsRecord;
import com.auto.di.guan.manager.basemodel.model.respone.WateringRecord;
import com.auto.di.guan.manager.basemodel.presenter.CommonPresenter;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.utils.DateUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加操作日志
 */

public class LogInfoActivity extends IBaseActivity {

    @BindView(R.id.title_bar_back_layout)
    RelativeLayout titleBarBackLayout;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;

    @BindView(R.id.log_title)
    TextView logTitle;
    @BindView(R.id.log_desc)
    TextView logDesc;
    @BindView(R.id.log_time)
    TextView logTime;

    WateringRecord record;

    @Override
    protected int setLayout() {
        return R.layout.activity_log_info;
    }

    @Override
    protected void init() {
        titleBarTitle.setText("操作详情");
        record = (WateringRecord) getIntent().getSerializableExtra("water");
        if (record != null) {
            logTitle.setText("项目:"+ record.getProjectName());
            logDesc.setText(record.getFlowMeterCount()+"");
            logTime.setText(DateUtils.timet(String.valueOf(record.getRecordDate())));
        }
    }

    @Override
    protected CommonPresenter createPresenter() {
        return null;
    }






    @OnClick({R.id.title_bar_back_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back_layout:
                finish();
                break;
        }
    }

}
