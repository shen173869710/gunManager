package com.auto.di.guan.manager.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.db.ControlInfo;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.entity.Entiy;
import com.auto.di.guan.manager.utils.DensityUtil;
import com.auto.di.guan.manager.utils.NoFastClickUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class ChooseGridAdapter extends BaseQuickAdapter<DeviceInfo, BaseViewHolder> {
    public ChooseGridAdapter(List<DeviceInfo> data) {
        super(R.layout.grid_item, data);

    }
    @Override
    protected void convert(BaseViewHolder holder, DeviceInfo deviceInfo) {

        int itemWidth = DensityUtil.getWidth() - (int)getContext().getResources().getDimension(R.dimen.main_table_list_width);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(itemWidth/ Entiy.GRID_COLUMNS, itemWidth/ Entiy.GRID_COLUMNS);
        /*****设备相关信息****/
        holder.getView(R.id.grid_item_layout).setLayoutParams(layoutParams);
        holder.setText(R.id.grid_item_device_id, deviceInfo.getDeviceSort()+"");

        TextView grid_item_device_name = holder.getView(R.id.grid_item_device_name);
        ImageView grid_item_device = holder.getView(R.id.grid_item_device);
        TextView grid_item_device_value = holder.getView(R.id.grid_item_device_value);
        TextView grid_item_device_id = holder.getView(R.id.grid_item_device_id);
        /*****第一个阀门****/
        RelativeLayout grid_item_left_layout = holder.getView(R.id.grid_item_left_layout);
        TextView grid_item_left_group = holder.getView(R.id.grid_item_left_group);
        ImageView grid_item_left_image = holder.getView(R.id.grid_item_left_image);
        TextView grid_item_left_id = holder.getView(R.id.grid_item_left_id);
        TextView grid_item_left_sel = holder.getView(R.id.grid_item_left_sel);

        /*****第二个阀门****/
        RelativeLayout grid_item_right_layout = holder.getView(R.id.grid_item_right_layout);
        TextView grid_item_right_group = holder.getView(R.id.grid_item_right_group);
        ImageView grid_item_right_image = holder.getView(R.id.grid_item_right_image);
        TextView grid_item_right_id = holder.getView(R.id.grid_item_right_id);
        TextView grid_item_right_sel = holder.getView(R.id.grid_item_right_sel);


        if (deviceInfo.getDeviceStatus() == Entiy.DEVEICE_UNBIND) {
            grid_item_device.setVisibility(View.INVISIBLE);
            grid_item_left_layout.setVisibility(View.INVISIBLE);
            grid_item_right_layout.setVisibility(View.INVISIBLE);
            grid_item_device_name.setVisibility(View.INVISIBLE);
            grid_item_device_value.setVisibility(View.INVISIBLE);
        }else {
            grid_item_device.setVisibility(View.VISIBLE);
            if (!TextUtils.isEmpty(deviceInfo.getDeviceName())) {
                grid_item_device_name.setText(deviceInfo.getDeviceName()+"");
                grid_item_device_name.setVisibility(View.VISIBLE);
            }
            grid_item_device_value.setText(deviceInfo.getElectricQuantity()+"%");
            ControlInfo info1 = deviceInfo.getValveDeviceSwitchList().get(0);

            if (info1.getValve_status() == 0) {
                grid_item_left_layout.setVisibility(View.INVISIBLE);
                grid_item_left_layout.setOnClickListener(null);
            }else {
                grid_item_left_layout.setVisibility(View.VISIBLE);
                grid_item_left_image.setVisibility(View.VISIBLE);
                grid_item_left_image.setImageResource(info1.getValve_imgage_id());
                grid_item_left_sel.setVisibility(View.VISIBLE);
                grid_item_left_id.setText(info1.getValve_alias()+"");
                if (info1.isSelect()) {
                    grid_item_left_sel.setBackgroundResource(R.mipmap.img_selected);
                }else {
                    grid_item_left_sel.setBackgroundResource(R.mipmap.img_unselected);
                }

                if (info1.getValve_group_id() == 0) {
                    grid_item_left_group.setVisibility(View.INVISIBLE);
                }else {
                    grid_item_left_group.setVisibility(View.VISIBLE);
                    grid_item_left_group.setText(info1.getValve_group_id()+"");
                }

                if (info1.getValve_group_id() > 0) {
                    grid_item_left_sel.setVisibility(View.GONE);
                    deviceInfo.getValveDeviceSwitchList().get(0).setSelect(false);
                }else {
                    grid_item_left_layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(NoFastClickUtils.isFastClick()){
                                return;
                            }
                            deviceInfo.getValveDeviceSwitchList().get(0).setSelect(!deviceInfo.getValveDeviceSwitchList().get(0).isSelect());
                            notifyDataSetChanged();
                        }
                    });
                }
            }

            ControlInfo info2 = deviceInfo.getValveDeviceSwitchList().get(1);
            if (info2.getValve_status() == 0) {
                grid_item_right_layout.setVisibility(View.INVISIBLE);
            }else {
                grid_item_right_layout.setVisibility(View.VISIBLE);
                grid_item_right_image.setVisibility(View.VISIBLE);
                grid_item_right_image.setImageResource(info1.getValve_imgage_id());
                grid_item_right_sel.setVisibility(View.VISIBLE);
                grid_item_right_id.setText(info2.getValve_alias()+"");
                if (info2.isSelect()) {
                    grid_item_right_sel.setBackgroundResource(R.mipmap.img_selected);
                }else {
                    grid_item_right_sel.setBackgroundResource(R.mipmap.img_unselected);
                }

                if (info2.getValve_group_id() == 0) {
                    grid_item_right_group.setVisibility(View.INVISIBLE);
                }else {
                    grid_item_right_group.setVisibility(View.VISIBLE);
                    grid_item_right_group.setText(info2.getValve_group_id()+"");
                }

                if (info2.getValve_group_id() > 0) {
                    grid_item_right_sel.setVisibility(View.GONE);
                    deviceInfo.getValveDeviceSwitchList().get(1).setSelect(false);
                }else {
                    grid_item_right_layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(NoFastClickUtils.isFastClick()){
                                return;
                            }
                            deviceInfo.getValveDeviceSwitchList().get(1).setSelect(!deviceInfo.getValveDeviceSwitchList().get(1).isSelect());
                            notifyDataSetChanged();
                        }
                    });
                }
            }
        }
    }

}
