package com.auto.di.guan.manager.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.adapter.Fragment8LeftAdapter;
import com.auto.di.guan.manager.adapter.Fragment8RightAdapter;
import com.auto.di.guan.manager.api.ApiEntiy;
import com.auto.di.guan.manager.basemodel.model.respone.EDepthRespone;
import com.auto.di.guan.manager.basemodel.model.respone.MeteoRespone;
import com.auto.di.guan.manager.dialog.DialogContent;
import com.auto.di.guan.manager.dialog.InputDialog;
import com.auto.di.guan.manager.dialog.OnDialogClick;
import com.auto.di.guan.manager.event.ActivityItemEvent;
import com.auto.di.guan.manager.event.DateChangeEvent;
import com.auto.di.guan.manager.rtm.MessageEntiy;
import com.auto.di.guan.manager.rtm.MessageSend;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class FragmentTab7 extends BaseFragment {

    @BindView(R.id.add_memto)
    Button add_memto;
    @BindView(R.id.add_poi)
    Button add_poi;
    @BindView(R.id.fragment_7_left)
    RecyclerView recyclerViewLeft;
    Fragment8LeftAdapter leftAdapter;
    @BindView(R.id.fragment_7_right)
    RecyclerView recyclerViewRight;
    Fragment8RightAdapter rightAdapter;


    List<MeteoRespone> meteoRespones = new ArrayList<>();
    List<EDepthRespone> eDepthRespones = new ArrayList<>();



    @Override
    public int setLayout() {
        return R.layout.fragment_7;
    }

    @Override
    public void init() {
        recyclerViewLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        leftAdapter = new Fragment8LeftAdapter(meteoRespones);
        recyclerViewLeft.setAdapter(leftAdapter);


        recyclerViewRight.setLayoutManager(new LinearLayoutManager(getContext()));
        rightAdapter = new Fragment8RightAdapter(eDepthRespones);
        recyclerViewRight.setAdapter(rightAdapter);


        leftAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                MessageSend.doActivityItem(position);

            }
        });

        add_memto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                addDevice("添加气象", ApiEntiy.DEVICE_TYPE,"19101600107861");

            }
        });


        add_poi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDevice("添加墒情", "","18121700094125");
            }
        });
    }

    @Override
    public void dataChange(DateChangeEvent event) {

    }


    public void addDevice(String title,String snType, String device) {
        DialogContent dialogContent = new DialogContent();
        dialogContent.setDesc(title);
        dialogContent.setCancle(device);
        InputDialog.show(getActivity(), dialogContent, new OnDialogClick() {
            @Override
            public void onDialogOkClick(final String value) {
                MessageSend.doFarmLand(MessageEntiy.TYPE_FARMLAND, snType, value);
            }

            @Override
            public void onDialogCloseClick(String value) {

            }
        });
    }


    /**
     *         处理web端相关操作
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onActivityItemEvent(ActivityItemEvent event) {
        if (event == null) {
            return;
        }


        if (event.getMeteoRespones().size() > 0) {
            meteoRespones.clear();
            meteoRespones.addAll(event.getMeteoRespones());
            rightAdapter.notifyDataSetChanged();
        }

        if (event.geteDepthRespones().size() > 0) {
            eDepthRespones.clear();;
            eDepthRespones.addAll(event.geteDepthRespones());
            leftAdapter.notifyDataSetChanged();
        }
    };


}
