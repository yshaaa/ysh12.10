package com.bawei.yanshenghao20191203.adapter;

/**
 * * @ActivityName: MyAdapter
 * * @Description: Activity介绍
 * * @author: 闫圣豪
 * * @date: 2019/12/3
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.yanshenghao20191203.R;
import com.bawei.yanshenghao20191203.bean.ShopBean;
import com.bawei.yanshenghao20191203.glide.GlideUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context activity;
    private ArrayList<ShopBean.CardDataBean> list;

    public MyAdapter(FragmentActivity activity, ArrayList<ShopBean.CardDataBean> list) {

        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        view = LayoutInflater.from(activity).inflate(R.layout.item, null);
        holder = new OneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof OneHolder){
            ((OneHolder) holder).total.setText(list.get(position).getTotal());
            ((OneHolder) holder).billdate.setText(list.get(position).getBilldate());
            ((OneHolder) holder).repaydate.setText(list.get(position).getRepaymentdate());
            ((OneHolder) holder).bill.setText(list.get(position).getBill());
            GlideUtil.LoadImage(list.get(position).getImageurl(),((OneHolder) holder).image);
        }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (setItemClid != null) {
                        setItemClid.getItemclick(position);
                    }
                }
            });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OneHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.total)
        TextView total;
        @BindView(R.id.billdate)
        TextView billdate;
        @BindView(R.id.repaydate)
        TextView repaydate;
        @BindView(R.id.bill)
        TextView bill;
        public OneHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    public interface setItemClid{
        void getItemclick(int postion);
    }
    private setItemClid setItemClid;
    public void setSetItemClid(setItemClid setItemClid){
        this.setItemClid=setItemClid;
    }

}
