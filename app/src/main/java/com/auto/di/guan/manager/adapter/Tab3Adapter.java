package com.auto.di.guan.manager.adapter;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.basemodel.model.respone.RaiseCropsRecord;
import com.auto.di.guan.manager.utils.DateUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

public class Tab3Adapter extends BaseQuickAdapter<RaiseCropsRecord, BaseViewHolder> {

    public Tab3Adapter(List<RaiseCropsRecord> data) {
        super(R.layout.manager_tab_3_item, data);
    }

    public void setData(List<RaiseCropsRecord> data) {
        getData().clear();
        getData().addAll(data);
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder holder, RaiseCropsRecord data) {
        holder.setText(R.id.item_0, data.getProjectName()+"");
        holder.setText(R.id.item_1, data.getCropName()+"");
        holder.setText(R.id.item_2, data.getVarieties()+"");
        holder.setText(R.id.item_3, DateUtils.timet(String.valueOf(data.getSowingTime()))+"");
        holder.setText(R.id.item_4, DateUtils.timet(String.valueOf(data.getCollectingTime()))+"");
        holder.setText(R.id.item_5, data.getOutputUnit()+"");
        holder.setText(R.id.item_6, data.getOutputYm()+"");
    }
}
