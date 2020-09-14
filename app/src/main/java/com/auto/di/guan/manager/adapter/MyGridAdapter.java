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
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */

public class MyGridAdapter  extends BaseQuickAdapter<DeviceInfo, BaseViewHolder> {

    public MyGridAdapter(List<DeviceInfo> data) {
        super(R.layout.grid_item, data);
    }

//    @Override
//    public int getCount() {
//        return datas.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return datas.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder = null;
//        if (convertView == null) {
//            holder = new ViewHolder();
//            convertView = mInflater.inflate(R.layout.grid_item, null);
//            holder.grid_item_layout = (RelativeLayout) convertView.findViewById(R.id.grid_item_layout);
//            holder.grid_item_device = (ImageView) convertView.findViewById(R.id.grid_item_device);
//            holder.grid_item_device_id = (TextView) convertView.findViewById(R.id.grid_item_device_id);
//            holder.grid_item_device_name = (TextView) convertView.findViewById(R.id.grid_item_device_name);
//            holder.grid_item_device_value = (TextView) convertView.findViewById(R.id.grid_item_device_value);
//
//            holder.grid_item_left_layout = (RelativeLayout) convertView.findViewById(R.id.grid_item_left_layout);
//            holder.grid_item_left_image = (ImageView) convertView.findViewById(R.id.grid_item_left_image);
//            holder.grid_item_left_group = (TextView) convertView.findViewById(R.id.grid_item_left_group);
//            holder.grid_item_left_sel = (TextView) convertView.findViewById(R.id.grid_item_left_sel);
//            holder.grid_item_left_id = (TextView) convertView.findViewById(R.id.grid_item_left_id);
//            holder.grid_item_right_layout = (RelativeLayout) convertView.findViewById(R.id.grid_item_right_layout);
//            holder.grid_item_right_image = (ImageView) convertView.findViewById(R.id.grid_item_right_image);
//            holder.grid_item_right_group = (TextView) convertView.findViewById(R.id.grid_item_right_group);
//            holder.grid_item_right_sel = (TextView) convertView.findViewById(R.id.grid_item_right_sel);
//            holder.grid_item_right_id = (TextView) convertView.findViewById(R.id.grid_item_right_id);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        int itemWidth = screenWidth - (int)context.getResources().getDimension(R.dimen.main_table_list_width);
//        int itemHeight = screenHight - (int)context.getResources().getDimension(R.dimen.main_grid_width)- MainActivity.windowTop;
//        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(itemWidth/ Entiy.GRID_COLUMNS, itemWidth/ Entiy.GRID_COLUMNS);
//        holder.grid_item_layout.setLayoutParams(layoutParams);
//
//        final DeviceInfo deviceInfo = datas.get(position);
//        holder.grid_item_device_id.setText(deviceInfo.getDeviceSort()+"");
//        holder.grid_item_device_id.setVisibility(View.VISIBLE);
//        /******设备未绑定******/
//        if (deviceInfo.getDeviceStatus() == Entiy.DEVEICE_UNBIND) {
//            holder.grid_item_device_name.setVisibility(View.INVISIBLE);
//            holder.grid_item_device.setVisibility(View.INVISIBLE);
//            holder.grid_item_device_value.setVisibility(View.INVISIBLE);
//            holder.grid_item_left_layout.setVisibility(View.INVISIBLE);
//            holder.grid_item_right_layout.setVisibility(View.INVISIBLE);
//        }else {
//            if (!TextUtils.isEmpty(deviceInfo.getDeviceName())) {
//                holder.grid_item_device_name.setText(deviceInfo.getDeviceName()+"");
//                holder.grid_item_device_name.setVisibility(View.VISIBLE);
//            }
//            holder.grid_item_device_id.setVisibility(View.VISIBLE);
//            holder.grid_item_device.setVisibility(View.VISIBLE);
//            holder.grid_item_device_value.setVisibility(View.VISIBLE);
//            holder.grid_item_device_value.setText(deviceInfo.getElectricQuantity()+"%");
//            holder.grid_item_left_layout.setVisibility(View.VISIBLE);
//            holder.grid_item_left_sel.setVisibility(View.GONE);
//
//            ControlInfo controlInfo0 = deviceInfo.getValveDeviceSwitchList().get(0);
//            if (controlInfo0.getValve_group_id() == 0) {
//                holder.grid_item_left_group.setVisibility(View.GONE);
//            }else {
//                holder.grid_item_left_group.setVisibility(View.VISIBLE);
//                holder.grid_item_left_group.setText(controlInfo0.getValve_group_id()+"");
//            }
//
//            if (controlInfo0.getValve_imgage_id() == 0) {
//                holder.grid_item_left_image.setVisibility(View.INVISIBLE);
//                holder.grid_item_left_id.setText("");
//            }else {
//                holder.grid_item_left_image.setVisibility(View.VISIBLE);
//                holder.grid_item_left_image.setImageResource(controlInfo0.getValve_imgage_id());
//                holder.grid_item_left_id.setText(controlInfo0.getValve_alias()+"");
//            }
//
//            holder.grid_item_right_layout.setVisibility(View.VISIBLE);
//            holder.grid_item_right_sel.setVisibility(View.GONE);
//
//            ControlInfo controlInfo1 = deviceInfo.getValveDeviceSwitchList().get(1);
//            if (controlInfo1.getValve_group_id() == 0) {
//                holder.grid_item_right_group.setVisibility(View.GONE);
//            }else {
//                holder.grid_item_right_group.setVisibility(View.VISIBLE);
//                holder.grid_item_right_group.setText(controlInfo1.getValve_group_id()+"");
//            }
//            if (controlInfo1.getValve_imgage_id() == 0) {
//                holder.grid_item_right_image.setVisibility(View.INVISIBLE);
//                holder.grid_item_right_id.setText("");
//            }else {
//                holder.grid_item_right_image.setVisibility(View.VISIBLE);
//                holder.grid_item_right_image.setImageResource(controlInfo1.getValve_imgage_id());
//                holder.grid_item_right_id.setText(controlInfo1.getValve_alias()+"");
//
//            }
//
//        }
//        return convertView;
//    }
//
//    public void setData(List<DeviceInfo> controlInfos) {
//        datas.clear();
//        datas.addAll(controlInfos);
//        notifyDataSetChanged();
//    }

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


        /******设备未绑定******/
        if (deviceInfo.getDeviceStatus() == Entiy.DEVEICE_UNBIND) {
            grid_item_device_name.setVisibility(View.INVISIBLE);
            grid_item_device.setVisibility(View.INVISIBLE);
            grid_item_device_value.setVisibility(View.INVISIBLE);
            grid_item_left_layout.setVisibility(View.INVISIBLE);
            grid_item_right_layout.setVisibility(View.INVISIBLE);
        }else {
            if (!TextUtils.isEmpty(deviceInfo.getDeviceName())) {
                grid_item_device_name.setText(deviceInfo.getDeviceName()+"");
                grid_item_device_name.setVisibility(View.VISIBLE);
            }
            grid_item_device_id.setVisibility(View.VISIBLE);
            grid_item_device.setVisibility(View.VISIBLE);
            grid_item_device_value.setVisibility(View.VISIBLE);
            grid_item_device_value.setText(deviceInfo.getElectricQuantity()+"%");
            grid_item_left_layout.setVisibility(View.VISIBLE);
            grid_item_left_sel.setVisibility(View.GONE);

            ControlInfo controlInfo0 = deviceInfo.getValveDeviceSwitchList().get(0);
            if (controlInfo0.getValveGroupId() == 0) {
                grid_item_left_group.setVisibility(View.GONE);
            }else {
                grid_item_left_group.setVisibility(View.VISIBLE);
                grid_item_left_group.setText(controlInfo0.getValveGroupId()+"");
            }

            if (controlInfo0.getValveStatus() == 0) {
               grid_item_left_image.setVisibility(View.INVISIBLE);
                grid_item_left_id.setText("");
            }else {
                grid_item_left_image.setVisibility(View.VISIBLE);
                grid_item_left_image.setImageResource(controlInfo0.getValveImgageId());
                grid_item_left_id.setText(controlInfo0.getValveAlias()+"");
            }

            grid_item_right_layout.setVisibility(View.VISIBLE);
            grid_item_right_sel.setVisibility(View.GONE);

            ControlInfo controlInfo1 = deviceInfo.getValveDeviceSwitchList().get(1);
            if (controlInfo1.getValveGroupId() == 0) {
                grid_item_right_group.setVisibility(View.GONE);
            }else {
                grid_item_right_group.setVisibility(View.VISIBLE);
                grid_item_right_group.setText(controlInfo1.getValveGroupId()+"");
            }
            if (controlInfo1.getValveStatus() == 0) {
                grid_item_right_image.setVisibility(View.INVISIBLE);
                grid_item_right_id.setText("");
            }else {
                grid_item_right_image.setVisibility(View.VISIBLE);
                grid_item_right_image.setImageResource(controlInfo1.getValveImgageId());
                grid_item_right_id.setText(controlInfo1.getValveAlias()+"");
            }
        }
    }

}
