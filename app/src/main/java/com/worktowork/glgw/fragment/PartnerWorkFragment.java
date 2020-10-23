package com.worktowork.glgw.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.activity.SalesManagementActivity;
import com.worktowork.glgw.base.BaseLazyFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class PartnerWorkFragment extends BaseLazyFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.tab_receiving_layout)
    SlidingTabLayout mTabReceivingLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private String mParam1;
    private String[] mTitleDataList = new String[]{
            "销售", "采购"
    };
    private MyPagerAdapter mAdapter;
    private ArrayList<Fragment> mWorkOrderFragmentList = new ArrayList<>();
    public static PartnerWorkFragment newInstance(String param1, String param2) {
        PartnerWorkFragment fragment = new PartnerWorkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 初始化沉浸式
     */
    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
//        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_partner_work;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mTitleDataList.length; i++) {
            mWorkOrderFragmentList.add(PartnerWorkFragment2.newInstance(mTitleDataList[i], ""));
        }
        mAdapter = new MyPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(mWorkOrderFragmentList.size());
        mTabReceivingLayout.setViewPager(mViewPager);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

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
