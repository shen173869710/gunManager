package com.auto.di.guan.manager.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.auto.di.guan.manager.utils.AndroidInterface;
import com.auto.di.guan.manager.R;
import com.just.agentweb.AgentWeb;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {


    private AgentWeb mAgentWeb;
    private LinearLayout loginWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginWeb = findViewById(R.id.login_web);


        if(mAgentWeb!=null){
            //注入对象
            mAgentWeb.getJsInterfaceHolder().addJavaObject("android",new AndroidInterface(mAgentWeb,this));
        }
        findViewById(R.id.callJsNoParamsButton).setOnClickListener(mOnClickListener);
        findViewById(R.id.callJsOneParamsButton).setOnClickListener(mOnClickListener);
        findViewById(R.id.callJsMoreParamsButton).setOnClickListener(mOnClickListener);
        findViewById(R.id.jsJavaCommunicationButton).setOnClickListener(mOnClickListener);

        mAgentWeb =AgentWeb.with(this)
                .setAgentWebParent(loginWeb, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator()//进度条
                .createAgentWeb()
                .ready()
                .go("file:///android_asset/js_interaction/hello.html");
    }




    private View.OnClickListener mOnClickListener=new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onClick(View v) {


            switch (v.getId()){

                case R.id.callJsNoParamsButton:
                    mAgentWeb.getJsAccessEntrace().quickCallJs("callByAndroid");

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    break;

                case R.id.callJsOneParamsButton:
                    mAgentWeb.getJsAccessEntrace().quickCallJs("callByAndroidParam","Hello ! Agentweb");
                    break;

                case R.id.callJsMoreParamsButton:
                    mAgentWeb.getJsAccessEntrace().quickCallJs("callByAndroidMoreParams", new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String value) {
                            Log.i("Info","value:"+value);
                        }
                    },getJson(),"say:", " Hello! Agentweb");

                    break;
                case R.id.jsJavaCommunicationButton:
                    mAgentWeb.getJsAccessEntrace().quickCallJs("callByAndroidInteraction","你好Js");
                    break;
            }

        }
    };


    private String getJson(){
        String result="";
        try {
            JSONObject mJSONObject=new JSONObject();
            mJSONObject.put("id",1);
            mJSONObject.put("name","Agentweb");
            mJSONObject.put("age",18);
            result= mJSONObject.toString();
        }catch (Exception e){

        }

        return result;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }

}
