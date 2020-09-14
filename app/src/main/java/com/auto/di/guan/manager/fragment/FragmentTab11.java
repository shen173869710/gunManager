package com.auto.di.guan.manager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.GunManagerAdapter;
import com.auto.di.guan.manager.entity.GunManager;
import com.auto.di.guan.manager.event.DateChangeEvent;
import java.util.ArrayList;
import java.util.List;


public class FragmentTab11 extends BaseFragment {
    RecyclerView fragment11List;
    private View view;
    GunManagerAdapter adapter;


    String [] titles = {
        "地表殇情",
            "气象信息",
            "气温",
            "气压",
            "日照",
            "风向",
            "风速",
            "降雨量"

    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_11, null);
        List<GunManager> list = new ArrayList<>();
        int length = titles.length;
        for (int i = 0; i < length; i++) {
            list.add(new GunManager(titles[i], "XXXX"));
        }

        fragment11List = view.findViewById(R.id.fragment_11_list);
        adapter = new GunManagerAdapter(list);
        fragment11List.setLayoutManager(new LinearLayoutManager(getContext()));
        fragment11List.setAdapter(adapter);
        return view;
    }



    @Override
    public int setLayout() {
        return 0;
    }

    @Override
    public void init() {

    }

    @Override
    public void dataChange(DateChangeEvent event) {

    }


}
