package com.bawei.yanshenghao20191203.base;

import android.os.Bundle;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.yanshenghao20191203.contract.Contract;

public abstract class BaseActivity <P extends BasePreaenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Layout()!=0){
            setContentView(Layout());
            initView();
            mPresenter=initPresenter();
            mPresenter.Attch(this);
            startCoding();
        }
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int Layout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
