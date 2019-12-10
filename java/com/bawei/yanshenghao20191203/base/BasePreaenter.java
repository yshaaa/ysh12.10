package com.bawei.yanshenghao20191203.base;

import com.bawei.yanshenghao20191203.contract.Contract;

import java.lang.ref.WeakReference;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
public abstract class BasePreaenter <V extends Contract.IView> implements Contract.IPresenter {

    public WeakReference<V> vWeakReference;

    public BasePreaenter(){
        initModel();
    }

    protected abstract void initModel();

    protected void Attch(V iView){
        vWeakReference = new WeakReference<>(iView);
    }
    protected void onEnd(){
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    protected V getView(){
        return vWeakReference.get();
    }

}
