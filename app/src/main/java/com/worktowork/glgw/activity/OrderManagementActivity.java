package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.OrderManagementAdapter;
import com.worktowork.glgw.adapter.OrderRevenueAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.OrderManagementBean;
import com.worktowork.glgw.fragment.OrderManagementFragment;
import com.worktowork.glgw.weight.CenterLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderManagementActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_all)
    TextView mTvAll;
    @BindView(R.id.tv_today)
    TextView mTvToday;
    @BindView(R.id.ll_filter)
    LinearLayout mLlFilter;
    @BindView(R.id.rv_order_management)
    RecyclerView mRvOrderManagement;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private String[] titleList=new String[]{"默认","待付款","待发货","待收货","已完成","已取消","售后中","已关闭"};
    private List<OrderManagementBean> list=new ArrayList<>();
    private OrderManagementAdapter adapter;
    private ArrayList<Fragment> mFragments;
    private CenterLayoutManager centerLayoutManager;

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
        return R.layout.activity_order_management;
    }

    @Override
    protected void initData() {
        mFragments = new ArrayList<>();
        for (int i = 0; i <titleList.length; i++) {
            if (i==0){
                list.add(new OrderManagementBean(titleList[i],true));
            }else {
                list.add(new OrderManagementBean(titleList[i],false));
            }
            mFragments.add(OrderManagementFragment.newInstance(titleList[i],""));
        }


        mViewPager.setCurrentItem(0);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(titleList.length+1);


        adapter = new OrderManagementAdapter(R.layout.itme_order_management,list);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mActivity);
//        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        centerLayoutManager = new CenterLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRvOrderManagement.setLayoutManager(centerLayoutManager);
        mRvOrderManagement.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                for (int i = 0; i < titleList.length; i++) {
                    list.get(i).setSelect(false);
                }
                list.get(position).setSelect(true);
                mViewPager.setCurrentItem(position);
                adapter.notifyDataSetChanged();
            }
        });


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < titleList.length; i++) {
                    list.get(i).setSelect(false);
                }
                list.get(position).setSelect(true);
                centerLayoutManager.smoothScrollToPosition(mRvOrderManagement, new RecyclerView.State(), position);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initView() {
        mTvTitle.setText("订单管理");
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
}
