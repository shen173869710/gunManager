package com.auto.di.guan.manager.adapter;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.basemodel.model.respone.ApplyFertilizerRecord;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

public class Tab4Adapter extends BaseQuickAdapter<ApplyFertilizerRecord, BaseViewHolder> {

    public Tab4Adapter(List<ApplyFertilizerRecord> data) {
        super(R.layout.manager_tab_4_item, data);
    }

    public void setData(List<ApplyFertilizerRecord> data) {
        getData().clear();
        getData().addAll(data);
        notifyDataSetChanged();
    }
    @Override
    protected void convert(BaseViewHolder holder, ApplyFertilizerRecord data) {
//        holder.setText(R.id.item_title, data.getNoticeTitle()+"");
//        holder.setText(R.id.item_desc,data.getNoticeContent()+"");
//        holder.setText(R.id.item_time,data.getCreateTime()+"");
    }

}
