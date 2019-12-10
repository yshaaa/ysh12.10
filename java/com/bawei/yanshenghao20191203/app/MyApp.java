package com.bawei.yanshenghao20191203.app;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
import android.content.Context;

import com.uuzuche.lib_zxing.ZApplication;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class MyApp extends ZApplication {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
        context=this;
    }
}
