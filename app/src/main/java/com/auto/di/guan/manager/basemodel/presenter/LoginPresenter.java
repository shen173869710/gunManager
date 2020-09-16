package com.auto.di.guan.manager.basemodel.presenter;




import com.auto.di.guan.manager.api.HttpManager;
import com.auto.di.guan.manager.basemodel.model.request.BaseRequest;
import com.auto.di.guan.manager.basemodel.model.respone.BaseRespone;
import com.auto.di.guan.manager.basemodel.view.ILoginView;

import java.util.TreeMap;

/**
 * Created by czl on 2019/7/9.
 * 用户登录相关逻辑业务
 */

public class LoginPresenter extends BasePresenter<ILoginView>{

    /**
     *
     * 登录请求
     * **/
    public void doLogin(String userName, final String pwd) {
//        String password = Md5Util.md5(pwd);
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("loginName",userName);
        treeMap.put("password",pwd);
        treeMap.put("mac", "mac");
        doHttpTask(getApiService().login(BaseRequest.toMerchantTreeMap(treeMap)), new HttpManager.OnResultListener() {
            @Override
            public void onSuccess(BaseRespone respone) {
                getBaseView().loginSuccess(respone);
            }
            @Override
            public void onError(Throwable error, Integer code,String msg) {
                getBaseView().loginFail(error,code,msg);
            }
        });
    }

}
