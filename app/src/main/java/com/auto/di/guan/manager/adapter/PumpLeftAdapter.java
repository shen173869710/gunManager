package com.auto.di.guan.manager.adapter;

import androidx.annotation.Nullable;


import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.entity.PumpInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

public class PumpLeftAdapter extends BaseQuickAdapter<PumpInfo, BaseViewHolder> {
    public PumpLeftAdapter(@Nullable List<PumpInfo> data) {
        super(R.layout.pump_left_item, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final PumpInfo info) {
        holder.setText(R.id.list_item, info.getPumpName());
    }

}
