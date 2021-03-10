package com.auto.di.guan.manager.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.activity.ManagerActivity;
import com.auto.di.guan.manager.adapter.Tab3Adapter;
import com.auto.di.guan.manager.api.ApiUtil;
import com.auto.di.guan.manager.api.HttpManager;
import com.auto.di.guan.manager.basemodel.model.request.BaseRequest;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.model.respone.RaiseCropsRecord;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;

public class ManagerTab3 extends BaseFragment {

    @BindView(R.id.tab_3_list)
    RecyclerView tabList;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private Tab3Adapter mAdapter;

    List<RaiseCropsRecord> records = new ArrayList<>();
    private List<User> users;

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
        users = (List<User>)getArguments().getSerializable(Entiy.INTENT_USER_LIST);
        if (users == null) {
            users = new ArrayList<>();
        }
        tabList.setLayoutManager(new LinearLayoutManager(activity));
        mAdapter = new Tab3Adapter(records);
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

    @Override
    public void dataChange(DateChangeEvent event) {

    }

    public void loadMore() {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("beginTime", 1);
        treeMap.put("endTime", System.currentTimeMillis());
        HttpManager.syncData(ApiUtil.createApiService().getRaiseList(BaseRequest.toMerchantTreeMap(treeMap)), new HttpManager.OnResultListener() {
            @Override
            public void onSuccess(BaseRespone respone) {
                refreshLayout.finishRefresh(1000);
                if (respone.getData() != null) {
                    List<RaiseCropsRecord> list = (List<RaiseCropsRecord>) respone.getData();
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
}
