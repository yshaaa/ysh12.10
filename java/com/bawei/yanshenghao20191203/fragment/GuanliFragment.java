package com.bawei.yanshenghao20191203.fragment;

/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.yanshenghao20191203.R;
import com.bawei.yanshenghao20191203.adapter.MyAdapter;
import com.bawei.yanshenghao20191203.base.BaseFragment;
import com.bawei.yanshenghao20191203.base.BasePreaenter;
import com.bawei.yanshenghao20191203.bean.ShopBean;
import com.bawei.yanshenghao20191203.presenter.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GuanliFragment extends BaseFragment {


    private ArrayList<ShopBean.CardDataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;
    private RecyclerView recy;

    @Override
    protected void startCoding() {

        String url="http://blog.zhaoliang5156.cn/api/card/card.json";
        mPresenter.start(url);
        myAdapter = new MyAdapter(getActivity(),list);
        recy.setAdapter(myAdapter);
        myAdapter.setSetItemClid(new MyAdapter.setItemClid() {
            @Override
            public void getItemclick(int postion) {
                Toast.makeText(getContext(), "总额度"+list.get(postion).getTotal()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected BasePreaenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View view) {
        recy = view.findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected int layout() {
        return R.layout.fragment_guanli;
    }

    @Override
    public void Success(String json) {
        ShopBean shopBean = new Gson().fromJson(json, ShopBean.class);
        list.clear();
        list.addAll(shopBean.getCardData());
        myAdapter.notifyDataSetChanged();

    }

    @Override
    public void Error(String error) {

    }
}
