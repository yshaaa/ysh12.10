package com.bawei.yanshenghao20191203.model;

import com.bawei.yanshenghao20191203.contract.Contract;
import com.bawei.yanshenghao20191203.okhttp.OKHttpUtil;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
public class Model implements Contract.IModel {
    @Override
    public void getInfo(String url, Contract.Mycallback mycallback) {
        OKHttpUtil.getInstance().asyget(url, new OKHttpUtil.OKCallBack() {
            @Override
            public void onSuccess(String json) {
                mycallback.Success(json);
            }

            @Override
            public void onError(String error) {
                mycallback.Error(error);
            }
        });
    }
}
