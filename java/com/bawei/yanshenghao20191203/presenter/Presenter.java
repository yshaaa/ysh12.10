package com.bawei.yanshenghao20191203.presenter;

import com.bawei.yanshenghao20191203.base.BasePreaenter;
import com.bawei.yanshenghao20191203.contract.Contract;
import com.bawei.yanshenghao20191203.model.Model;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
public class Presenter extends BasePreaenter {
    private Model models;
    @Override
    protected void initModel() {
        models=new Model();
    }


    @Override
    public void start(String url) {
        models.getInfo(url, new Contract.Mycallback() {
            @Override
            public void Success(String json) {
                getView().Success(json);
            }

            @Override
            public void Error(String error) {
                getView().Error(error);
            }
        });
    }
}
