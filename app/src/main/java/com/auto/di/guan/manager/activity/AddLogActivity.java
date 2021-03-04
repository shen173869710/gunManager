package com.auto.di.guan.manager.activity;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.presenter.LoginPresenter;
import com.auto.di.guan.manager.basemodel.view.IBaseView;

public class AddLogActivity extends IBaseActivity<LoginPresenter> implements IBaseView {


    @Override
    protected int setLayout() {
        return R.layout.activity_add_log;
    }

    @Override
    protected void init() {

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

}
