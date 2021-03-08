package com.auto.di.guan.manager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.auto.di.guan.manager.R;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.entity.Entiy;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;

public class MapActivity extends Activity{

	private MapView mMapView = null;
	private BaiduMap mBaiduMap;
	private User user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		// 如果数据表里面没有用户信息

		user = (User) getIntent().getSerializableExtra(Entiy.INTENT_USER);
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();

		//定义Maker坐标点
		LatLng point = new LatLng(39.963175, 116.400244);
		View view = LayoutInflater.from(this).inflate(R.layout.map_maker_layout, null);
		BitmapDescriptor bitmap = BitmapDescriptorFactory.fromView(view);
//构建Marker图标
//		BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
//构建MarkerOption，用于在地图上添加Marker
		OverlayOptions option = new MarkerOptions()
				.position(point)
				.icon(bitmap);
//在地图上添加Marker，并显示

		mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
//		mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
		mBaiduMap.addOverlay(option);
	}

	@Override
	protected void onResume() {
		super.onResume();
		//在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
		mMapView.onResume();
	}
	@Override
	protected void onPause() {
		super.onPause();
		//在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
		mMapView.onPause();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		//在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
		mMapView.onDestroy();
	}

}
