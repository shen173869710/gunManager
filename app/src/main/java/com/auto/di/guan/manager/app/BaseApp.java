package com.auto.di.guan.manager.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;

import androidx.multidex.MultiDex;

import com.auto.di.guan.manager.basemodel.model.respone.LoginRespone;
import com.auto.di.guan.manager.db.DeviceInfo;
import com.auto.di.guan.manager.db.User;
import com.auto.di.guan.manager.utils.CrashHandler;
import com.auto.di.guan.manager.utils.FloatWindowUtil;
import com.auto.di.guan.manager.utils.GsonUtil;
import com.auto.di.guan.manager.utils.LogUtils;
import com.auto.di.guan.manager.utils.SPUtils;
import com.facebook.stetho.Stetho;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/6/28.
 */

public class BaseApp extends Application {

    public static String TAG = "BaseApp";
    public static String DB_NAME = "guan.db";

    private static BaseApp instance;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        BaseApp.user = user;
    }

    private static User user;
    public static boolean groupIsStart;

    private  static List<DeviceInfo> deviceInfos = new ArrayList<>();

    private static Context mContext=null;//上下文

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        mContext = getApplicationContext();
        Stetho.initializeWithDefaults(this);
        LogUtils.setFilterLevel(LogUtils.ALL);
        FloatWindowUtil.getInstance().initFloatWindow(this);
        CrashReport.initCrashReport(getApplicationContext(), "d1930c180d", false);

        CrashHandler.getInstance().init(this);

        EMOptions options = new EMOptions();
// 默认添加好友时，是不需要验证的，改成需要验证
        options.setAcceptInvitationAlways(false);
// 是否自动将消息附件上传到环信服务器，默认为True是使用环信服务器上传下载，如果设为 false，需要开发者自己处理附件消息的上传和下载
        options.setAutoTransferMessageAttachments(true);
// 是否自动下载附件类消息的缩略图等，默认为 true 这里和上边这个参数相关联
        options.setAutoDownloadThumbnail(true);
//初始化
        EMClient.getInstance().init(this, options);
//在做打包混淆时，关闭debug模式，避免消耗不必要的资源
        EMClient.getInstance().setDebugMode(true);

    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
    public static BaseApp getInstance() {
        return instance;
    }

    public static Context getContext() {
        return mContext;
    }





    public void exit() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, 200);
    }




    /**
     * 判断网络是否连接
     */
    public static boolean isConnectNomarl() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (null == connectivityManager) {
                return false;
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return true;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        return true;
                    }  else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)){
                        return true;
                    }
                }
            }else{
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        return true;
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG,e.getMessage());
                }
            }

            //根据Android版本判断网络是否可用：6.0以后系统提供API可用，6.0之前使用ping命令
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if(null !=networkCapabilities){
                    return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
                }
            } else {
                Process ipProcess = null;
                try {
                    Runtime runtime = Runtime.getRuntime();
                    if(null !=runtime){
                        ipProcess = runtime.exec("ping -c 3 t.wuzhenpay.com");
                    }

                    if(null !=ipProcess){
                        int exitValue = ipProcess.waitFor();
                        LogUtils.i(TAG, "Process:" + exitValue);
                        return (exitValue == 0);
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, e.getMessage());
                    return false;
                }finally {
                    if(null !=ipProcess){
                        ipProcess.destroy();
                    }
                }
            }

            InputStream stream = null;
            try {
                URL url = new URL("https://www.baidu.com");
                stream = url.openStream();
                if (null != stream) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }finally {
                if(null !=stream){
                    stream.close();
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 用户登录的token信息
     */
    private static LoginRespone loginRespone;

    public static LoginRespone getLoginRespone() {
        if (loginRespone == null) {
            String info = SPUtils.getInstance().getString(SPUtils.SAVE_TOKEN_INFO);
            if (!TextUtils.isEmpty(info)) {
                loginRespone = GsonUtil.fromJson(info, LoginRespone.class);
            }
        }
        return loginRespone;
    }


    public static String getProjectId() {
        return user.getProjectId();
    }


    public static List<DeviceInfo> getDeviceInfos() {
        return deviceInfos;
    }

    public static void setDeviceInfos(List<DeviceInfo> deviceInfos) {
        BaseApp.deviceInfos = deviceInfos;
    }
}
