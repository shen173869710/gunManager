package com.auto.di.guan.manager.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.Toast;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.app.BaseApp;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.presenter.LoginPresenter;
import com.auto.di.guan.manager.basemodel.view.ILoginView;
import com.auto.di.guan.manager.customview.XEditText;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends IBaseActivity<LoginPresenter> implements ILoginView {

    @BindView(R.id.login_name)
    XEditText loginName;
    @BindView(R.id.login_pwd)
    XEditText loginPwd;
    @BindView(R.id.login)
    Button login;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {


    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @Override
    public void loginSuccess(BaseRespone respone) {
        User user = (User) respone.getData();
        if (user != null) {
            BaseApp.setUser(user);
        }
    }

    @Override
    public void loginFail(Throwable error, Integer code, String msg) {
        ToastUtils.showLongToast(msg+"");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        String name = loginName.getText().toString().trim();
//        id = "13300000000";
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(LoginActivity.this, "请输入账号", Toast.LENGTH_LONG).show();
            return;
        }
        String pwd = loginPwd.getText().toString().trim();
//        pwd = "123456";
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_LONG).show();
            return;
        }

        mPresenter.doLogin(name, pwd);
    }
}
