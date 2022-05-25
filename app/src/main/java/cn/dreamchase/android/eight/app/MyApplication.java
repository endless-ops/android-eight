package cn.dreamchase.android.eight.app;

import android.app.Application;

import cn.dreamchase.android.eight.entry.HttpConfig;
import cn.dreamchase.android.eight.net.HTTPCaller;
import cn.dreamchase.android.eight.util.Util;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        HttpConfig httpConfig = new HttpConfig();
        httpConfig.setAgent(true);//有代理的情况能不能访问
        httpConfig.setDebug(true);//是否debug模式 如果是debug模式打印log
        httpConfig.setTagName("ansen");//打印log的tagname

        //可以添加一些公共字段 每个接口都会带上
        httpConfig.addCommonField("pf", "android");
        httpConfig.addCommonField("version_code", "" + Util.getVersionCode(getApplicationContext()));

        //初始化HTTPCaller类
        HTTPCaller.getInstance().setHttpConfig(httpConfig);
    }
}
