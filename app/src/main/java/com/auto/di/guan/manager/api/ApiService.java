package com.auto.di.guan.manager.api;


import com.auto.di.guan.manager.basemodel.model.request.LoginRequest;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.model.respone.LoginRespone;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * 请求的相关接口
 */
public interface ApiService {
    /**
     *  用户登录接口
     * @return
     */

    @GET("/api/user/login")
    Observable<BaseRespone<LoginRespone>> login(@Body LoginRequest request);
}
