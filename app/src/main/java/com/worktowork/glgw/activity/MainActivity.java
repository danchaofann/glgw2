package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.fragment.ClassificationFragment;
import com.worktowork.glgw.fragment.HomeFragment;
import com.worktowork.glgw.fragment.MineFragment;
import com.worktowork.glgw.fragment.PartnerWorkFragment;
import com.worktowork.glgw.fragment.WorkFragment;
import com.worktowork.glgw.weight.CustomViewPager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.viewPager)
    CustomViewPager mViewPager;
    @BindView(R.id.dd)
    ImageView mDd;
    @BindView(R.id.ll_home)
    RelativeLayout mLlHome;
    @BindView(R.id.dd2)
    ImageView mDd2;
    @BindView(R.id.ll_work)
    RelativeLayout mLlWork;
    @BindView(R.id.dd4)
    ImageView mDd4;
    @BindView(R.id.ll_mine)
    RelativeLayout mLlMine;
    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;
    @BindView(R.id.dd3)
    ImageView mDd3;
    @BindView(R.id.ll_classification)
    RelativeLayout mLlClassification;
    private ArrayList<Fragment> mFragments;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(HomeFragment.newInstance("", ""));
        mFragments.add(ClassificationFragment.newInstance("", ""));
        mFragments.add(WorkFragment.newInstance("", ""));
//        mFragments.add(PartnerWorkFragment.newInstance("", ""));
        mFragments.add(MineFragment.newInstance("", ""));
        mViewPager.setCurrentItem(0);
    }

    @Override
    protected void initView() {
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setScroll(false);
        mLlHome.setSelected(true);
    }

    @Override
    protected void setListener() {
        mLlHome.setOnClickListener(this);
        mLlClassification.setOnClickListener(this);
        mLlWork.setOnClickListener(this);
        mLlMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_home:
                mViewPager.setCurrentItem(0);
                tabSelected(mLlHome);
                break;
            case R.id.ll_classification:
                mViewPager.setCurrentItem(1);
                tabSelected(mLlClassification);
                break;
            case R.id.ll_work:
                mViewPager.setCurrentItem(2);
                tabSelected(mLlWork);
                break;
            case R.id.ll_mine:
                mViewPager.setCurrentItem(3);
                tabSelected(mLlMine);
                break;

        }
    }

    private void tabSelected(RelativeLayout linearLayout) {
        mLlHome.setSelected(false);
        mLlClassification.setSelected(false);
        mLlWork.setSelected(false);
        mLlMine.setSelected(false);
        linearLayout.setSelected(true);
    }

    public void setCurrentItem(int i) {
        mViewPager.setCurrentItem(i, true);
    }

    private class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
