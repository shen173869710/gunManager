package com.auto.di.guan.manager.fragment;

import android.os.Bundle;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.event.DateChangeEvent;

public class ManagerTab4 extends BaseFragment {



    public static ManagerTab4 newInstance(Bundle bundle){
        ManagerTab4 fragment=new ManagerTab4();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public int setLayout() {
        return R.layout.manager_tab_4;
    }

    @Override
    public void init() {

    }

    @Override
    public void dataChange(DateChangeEvent event) {

    }
}
