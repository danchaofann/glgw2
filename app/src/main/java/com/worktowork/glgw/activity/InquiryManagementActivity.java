package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.fragment.InquiryManagementFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//询价管理
public class InquiryManagementActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.icon_search)
    ImageView mIconSearch;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ll_toolbar)
    LinearLayout mLlToolbar;
    @BindView(R.id.et_question)
    EditText mEtQuestion;
    @BindView(R.id.tab_receiving_layout)
    SlidingTabLayout mTabReceivingLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private String[] mTitleDataList = new String[]{
            "全部", "待接单", "待报单", "待报价", "待调价", "已关闭"
    };

    private MyPagerAdapter mAdapter;
    private ArrayList<Fragment> mWorkOrderFragmentList = new ArrayList<>();
    /**
     * 初始化沉浸式
     */
    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }
    @Override
    protected int setLayoutId() {
        return R.layout.activity_inquiry_management;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mTitleDataList.length; i++) {
            mWorkOrderFragmentList.add(InquiryManagementFragment.newInstance(mTitleDataList[i], ""));
        }
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(mWorkOrderFragmentList.size());
        mTabReceivingLayout.setViewPager(mViewPager);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("询价管理");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mWorkOrderFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleDataList[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mWorkOrderFragmentList.get(position);
        }
    }
}
