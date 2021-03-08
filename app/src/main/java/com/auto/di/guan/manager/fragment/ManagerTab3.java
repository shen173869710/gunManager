package com.auto.di.guan.manager.fragment;

import android.os.Bundle;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.event.DateChangeEvent;

public class ManagerTab3 extends BaseFragment {

    public static ManagerTab3 newInstance(Bundle bundle){
        ManagerTab3 fragment=new ManagerTab3();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int setLayout() {
        return R.layout.manager_tab_3;
    }

    @Override
    public void init() {

    }

    @Override
    public void dataChange(DateChangeEvent event) {

    }
}
