package com.auto.di.guan.manager.adapter;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.db.User;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

public class Tab2Adapter extends BaseQuickAdapter<User, BaseViewHolder> {

    public Tab2Adapter(List<User> data) {
        super(R.layout.manager_tab_2_item, data);
    }

    public void setData(List<User> data) {
        getData().clear();
        getData().addAll(data);
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder holder, User data) {


    }


}
