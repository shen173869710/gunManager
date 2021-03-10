package com.auto.di.guan.manager.adapter;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.entity.SubmitInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;
public class SubmitAdapter extends BaseQuickAdapter<SubmitInfo, BaseViewHolder> {

    public SubmitAdapter(List<SubmitInfo> data) {
        super(R.layout.submit_list_item, data);
    }

    public void setData(List<SubmitInfo> data) {
        getData().clear();
        getData().addAll(data);
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder holder, SubmitInfo data) {
        holder.setText(R.id.submit_title, data.getTitle());
        if (TextUtils.isEmpty(data.getDesc())) {
            data.setDesc("");
        }

        if (TextUtils.isEmpty(data.getDesc())){
            holder.setText(R.id.submit_info, "");
        }else {
            holder.setText(R.id.submit_info, data.getDesc());
        }

        EditText editText = holder.getView(R.id.submit_info);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                data.setDesc(s.toString());
            }
        });
    }
}
