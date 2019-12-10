package com.bawei.yanshenghao20191203;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.yanshenghao20191203.fragment.GuanliFragment;
import com.bawei.yanshenghao20191203.fragment.HomeFragment;
import com.bawei.yanshenghao20191203.fragment.ThreeFragment;
import com.bawei.yanshenghao20191203.fragment.TwoFragment;

import java.util.ArrayList;
/**
 *  * @ActivityName: MyAdapter
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/12/3
 */
public class MainActivity extends AppCompatActivity {

    private RadioGroup group;
    private ViewPager viewpager;
    private ArrayList<Fragment> list;
    private HomeFragment homeFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private GuanliFragment guanliFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        group = (RadioGroup) findViewById(R.id.group);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        list = new ArrayList<>();
        homeFragment = new HomeFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        guanliFragment = new GuanliFragment();
        list.add(homeFragment);
        list.add(twoFragment);
        list.add(threeFragment);
        list.add(guanliFragment);

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.one:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.two:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.three:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.four:
                        viewpager.setCurrentItem(3);
                        break;
                }
            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                group.check(group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}
