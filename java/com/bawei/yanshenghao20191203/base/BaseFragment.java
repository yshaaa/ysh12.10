package com.bawei.yanshenghao20191203.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.yanshenghao20191203.contract.Contract;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePreaenter> extends Fragment implements Contract.IView {
    public P mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(layout(),container,false);
        ButterKnife.bind(this,view);
        initView(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter=initPresenter();
        if (mPresenter!=null){
            mPresenter.Attch(this);
        }
        startCoding();
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView(View view);

    protected abstract int layout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
