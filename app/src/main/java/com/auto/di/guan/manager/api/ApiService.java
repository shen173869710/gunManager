package com.auto.di.guan.manager.api;


import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.model.respone.LoginRespone;

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
     *  用户登录接口
     * @return
     */
    @FormUrlEncoded
    @POST("/api/user/group/login")
    Observable<BaseRespone<LoginRespone>> login(@FieldMap Map<String, Object> map);
}
