package com.auto.di.guan.manager.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.Tab4Adapter;
import com.auto.di.guan.manager.api.ApiUtil;
import com.auto.di.guan.manager.api.HttpManager;
import com.auto.di.guan.manager.basemodel.model.request.BaseRequest;
import com.auto.di.guan.manager.basemodel.model.respone.ApplyFertilizerRecord;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;

public class ManagerTab4 extends BaseFragment {


    @BindView(R.id.tab_4_list)
    RecyclerView tabList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private Tab4Adapter mAdapter;

    List<ApplyFertilizerRecord> list = new ArrayList<>();

    public static ManagerTab4 newInstance(Bundle bundle) {
        ManagerTab4 fragment = new ManagerTab4();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int setLayout() {
        return R.layout.manager_tab_4;
    }

    @Override
    public void init() {
        tabList.setLayoutManager(new LinearLayoutManager(activity));
        mAdapter = new Tab4Adapter(list);
        tabList.setAdapter(mAdapter);
        refreshLayout.setRefreshHeader(new ClassicsHeader(activity));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                loadMore();
            }
        });
        loadMore();
    }

    public void loadMore() {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("pageNum", 1);
        treeMap.put("pageSize", 100);
        HttpManager.syncData(ApiUtil.createApiService().getNotice(BaseRequest.toMerchantTreeMap(treeMap)), new HttpManager.OnResultListener() {
            @Override
            public void onSuccess(BaseRespone respone) {
                refreshLayout.finishRefresh(1000);
                if (respone.getData() != null) {
                    List<ApplyFertilizerRecord> list = (List<ApplyFertilizerRecord>) respone.getData();
                    if (list != null) {
                        mAdapter.setData(list);
                    }
                }
            }

            @Override
            public void onError(Throwable error, Integer code, String msg) {
                refreshLayout.finishRefresh(false);
            }
        });
    }
    @Override
    public void dataChange(DateChangeEvent event) {

    }
}
