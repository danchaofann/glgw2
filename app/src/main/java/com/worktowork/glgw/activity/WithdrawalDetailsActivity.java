package com.worktowork.glgw.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.fragment.WithdrawalDetailsFragment;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WithdrawalDetailsActivity extends BaseActivity implements View.OnClickListener {

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
    @BindView(R.id.magic)
    MagicIndicator mMagic;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private String[] mTitleDataList = new String[]{
            "全部", "提现中", "已提现"
    };
    private MyPagerAdapter mAdapter;
    private ArrayList<Fragment> mWorkOrderFragmentList = new ArrayList<>();
    private CommonNavigator commonNavigator;

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
        return R.layout.activity_withdrawal_details;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mTitleDataList.length; i++) {
            mWorkOrderFragmentList.add(WithdrawalDetailsFragment.newInstance(mTitleDataList[i], ""));
        }


        mViewPager.setOffscreenPageLimit(mTitleDataList.length);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mTitleDataList == null ? 0 : mTitleDataList.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.parseColor("#666666"));
                colorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#FFFF7214"));
//                colorTransitionPagerTitleView.setTextColor(Color.parseColor("#666666"));
                colorTransitionPagerTitleView.setTextSize(14);
                colorTransitionPagerTitleView.setLeft(10000);
                colorTransitionPagerTitleView.setText(mTitleDataList[index]);
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setRoundRadius(5);
                indicator.setColors(Color.parseColor("#FFFF7214"));
//                indicator.setLineWidth(100);
                return indicator;
            }
        });
//        mMagic.setBackgroundResource(Color.parseColor("#FFF2F2F2"));
        mMagic.setBackgroundColor(Color.parseColor("#FFF2F2F2"));
        mMagic.setNavigator(commonNavigator);
        LinearLayout titleContainer = commonNavigator.getTitleContainer();
        titleContainer.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        titleContainer.setDividerPadding(UIUtil.dip2px(mActivity, 15));
        titleContainer.setDividerDrawable(getResources().getDrawable(R.drawable.simple_splitter));

        ViewPagerHelper.bind(mMagic, mViewPager);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("提现明细");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
