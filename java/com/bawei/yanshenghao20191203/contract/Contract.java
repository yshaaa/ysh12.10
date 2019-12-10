package com.bawei.yanshenghao20191203.contract;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
public interface Contract {

    interface IModel{
        void getInfo(String url,Mycallback mycallback);
    }
    interface IView{
        void Success(String json);
        void Error(String error);
    }
    interface IPresenter{
        void start(String url);
    }
    interface Mycallback{
        void Success(String json);
        void Error(String error);
    }
}
