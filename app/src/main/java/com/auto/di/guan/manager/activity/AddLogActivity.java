package com.auto.di.guan.manager.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.presenter.LoginPresenter;
import com.auto.di.guan.manager.basemodel.view.IBaseView;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddLogActivity extends IBaseActivity<LoginPresenter> implements IBaseView {

    @BindView(R.id.title_bar_back_layout)
    RelativeLayout titleBarBackLayout;
    @BindView(R.id.add_spinner)
    Spinner addSpinner;
    @BindView(R.id.add_info)
    EditText addInfo;
    @BindView(R.id.add_submit)
    Button addSubmit;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;

    private List<User> users;
    private int index = 0;


    @Override
    protected int setLayout() {
        return R.layout.activity_add_log;
    }

    @Override
    protected void init() {
        users = (List<User>) getIntent().getSerializableExtra(Entiy.INTENT_USER_LIST);
        if (users == null) {
            return;
        }

        titleBarTitle.setText("操作日志");
        int size = users.size();
        ArrayList<String> mItems = new ArrayList<>();

        String name = users.get(0).getLoginName();
        for (int i = 0; i < 7; i++) {
            mItems.add(name + i);
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
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @Override
    public void success(BaseRespone respone) {

    }

    @Override
    public void fail(Throwable error, Integer code, String msg) {
    }


    public void submitInfo() {
        String info = addInfo.getText().toString().trim();
        if (TextUtils.isEmpty(info)) {
            ToastUtils.showToast("输入信息为空");
            return;
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
