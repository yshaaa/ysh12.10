package com.bawei.yanshenghao20191203.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bawei.yanshenghao20191203.R;
import com.bawei.yanshenghao20191203.base.BaseFragment;
import com.bawei.yanshenghao20191203.base.BasePreaenter;
import com.bawei.yanshenghao20191203.presenter.Presenter;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private Button xiangji;
    private EditText edit;
    private Button erweima;
    private ImageView imageview;
    private TextView text;
    private String name="aaa";


    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePreaenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView(View view) {
        xiangji=view.findViewById(R.id.xiangji);

        erweima=view.findViewById(R.id.erweima);
        imageview=view.findViewById(R.id.imageview);
        text=view.findViewById(R.id.text);
        xiangji.setOnClickListener(this);
        erweima.setOnClickListener(this);

    }

    @Override
    protected int layout() {
        return R.layout.fragment_home;
    }


    @Override
    public void Success(String json) {

    }

    @Override
    public void Error(String error) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.xiangji:

                break;
            case R.id.erweima:
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
                    Bitmap image = CodeUtils.createImage(name, 300, 200, bitmap);
                    imageview.setImageBitmap(image);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            String type = data.getStringExtra("type");
            String result_string = data.getStringExtra("RESULT_STRING");
            text.setText(type+result_string+"");
        }
    }
}
