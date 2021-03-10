package com.auto.di.guan.manager.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.SubmitAdapter;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.model.respone.RaiseCropsRecord;
import com.auto.di.guan.manager.basemodel.presenter.CommonPresenter;
import com.auto.di.guan.manager.basemodel.view.IBaseView;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.entity.SubmitInfo;
import com.auto.di.guan.manager.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 产量日志
 */
public class AddRaiseActivity extends IBaseActivity<CommonPresenter> implements IBaseView {

    @BindView(R.id.title_bar_back_layout)
    RelativeLayout titleBarBackLayout;
    @BindView(R.id.add_spinner)
    Spinner addSpinner;
    @BindView(R.id.add_submit)
    Button addSubmit;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.add_list)
    RecyclerView addList;

    private List<User> users;
    private int index = 0;
    private SubmitAdapter submitAdapter;
    private List<SubmitInfo> submitInfos = new ArrayList<>();

    @Override
    protected int setLayout() {
        return R.layout.activity_add_raise;
    }

    @Override
    protected void init() {
        users = (List<User>) getIntent().getSerializableExtra(Entiy.INTENT_USER_LIST);
        if (users == null) {
            return;
        }
        titleBarTitle.setText(R.string.manager_tab_3);
        int size = users.size();
        ArrayList<String> mItems = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            mItems.add(users.get(i).getLoginName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        addSpinner.setAdapter(adapter);
        addSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addList.setLayoutManager(new LinearLayoutManager(this));

        int length = Entiy.RAISE.length;
        submitInfos.clear();
        for (int i = 0; i < length; i++) {
            submitInfos.add(new SubmitInfo(Entiy.RAISE[i], ""));
        }
        submitAdapter = new SubmitAdapter(submitInfos);
        addList.setAdapter(submitAdapter);

    }

    @Override
    protected CommonPresenter createPresenter() {
        return new CommonPresenter();
    }


    @Override
    public void success(BaseRespone respone) {

    }

    @Override
    public void fail(Throwable error, Integer code, String msg) {
    }


    public void submitInfo() {
        int size = submitInfos.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.isEmpty(submitInfos.get(i).getDesc())) {
                ToastUtils.showToast("输入信息为空");
                return;
            }
        }
        User user = users.get(index);
        RaiseCropsRecord record = new RaiseCropsRecord();
        record.setWaterUserId(BaseApp.getUser().getUserId());
        record.setMemberUserId(user.getUserId());
        record.setProjectName(user.getLoginName());
        record.setCropName(submitInfos.get(0).getDesc());
        record.setVarieties(submitInfos.get(1).getDesc());
        record.setSowingTime(System.currentTimeMillis());
        record.setCollectingTime(System.currentTimeMillis());
        record.setOutputUnit(submitInfos.get(4).getDesc());
        record.setOutputYm(submitInfos.get(5).getDesc());
        mPresenter.addRaise(record);
    }


    @OnClick({R.id.title_bar_back_layout, R.id.add_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_bar_back_layout:
                finish();
                break;
            case R.id.add_submit:
                submitInfo();
                break;
        }
    }

}
