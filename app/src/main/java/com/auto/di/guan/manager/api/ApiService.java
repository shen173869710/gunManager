package com.auto.di.guan.manager.api;


import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.model.respone.LoginRespone;
import com.auto.di.guan.manager.db.User;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 请求的相关接口
 */
public interface ApiService {

    /**
     *  设备激活
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/api//user/deviceActivation")
    Observable<BaseRespone<LoginRespone>> deviceActivation(@FieldMap Map<String, Object> map);

    /**
     *  用户登录接口
     * @param map
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/login")
    Observable<BaseRespone<User>> login(@FieldMap Map<String, Object> map);
}
