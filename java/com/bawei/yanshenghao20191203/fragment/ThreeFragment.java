package com.bawei.yanshenghao20191203.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yanshenghao20191203.R;
import com.bawei.yanshenghao20191203.base.BaseFragment;
import com.bawei.yanshenghao20191203.base.BasePreaenter;
import com.bawei.yanshenghao20191203.presenter.Presenter;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
public class ThreeFragment extends BaseFragment {



    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePreaenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int layout() {
        return R.layout.fragment_three;
    }

    @Override
    public void Success(String json) {

    }

    @Override
    public void Error(String error) {

    }
}
