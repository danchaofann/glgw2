package com.worktowork.glgw.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.ProductDetailAdapter;
import com.worktowork.glgw.adapter.ProductModelAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.ProductModelBean;
import com.worktowork.glgw.fragment.ProductDesciptionFragment;
import com.worktowork.glgw.fragment.ProductParametersFragment;
import com.worktowork.glgw.fragment.ProductSpecificationsFragment;
import com.worktowork.glgw.fragment.ProductStatementFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.del)
    LinearLayout mDel;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.del2)
    LinearLayout mDel2;
    @BindView(R.id.frame_ad)
    FrameLayout mFrameAd;
    @BindView(R.id.tv_product_name)
    TextView mTvProductName;
    @BindView(R.id.tv_product_brand)
    TextView mTvProductBrand;
    @BindView(R.id.tv_product_model)
    TextView mTvProductModel;
    @BindView(R.id.tv_money_start)
    TextView mTvMoneyStart;
    @BindView(R.id.tv_money_end)
    TextView mTvMoneyEnd;
    @BindView(R.id.tv_unit)
    TextView mTvUnit;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.rv_product_model)
    RecyclerView mRvProductModel;
    @BindView(R.id.appbarlayout)
    AppBarLayout mAppbarlayout;
    @BindView(R.id.tv_product_desciption)
    TextView mTvProductDesciption;
    @BindView(R.id.tv_specifications)
    TextView mTvSpecifications;
    @BindView(R.id.tv_packaging_parameters)
    TextView mTvPackagingParameters;
    @BindView(R.id.tv_guarantee_statement)
    TextView mTvGuaranteeStatement;
    @BindView(R.id.viewPager_product)
    ViewPager mViewPagerProduct;
    @BindView(R.id.cdl)
    CoordinatorLayout mCdl;
    private List<ProductModelBean> productModelBeanList = new ArrayList<>();
    private List<ProductModelBean> productDetailList = new ArrayList<>();
    private ProductModelAdapter productModelAdapter;
    private ArrayList<Fragment> mFragments;
    private AlertDialog dialog;
    private ProductDetailAdapter productDetailAdapter;

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
        return R.layout.activity_product_details;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            productModelBeanList.add(new ProductModelBean());
            productDetailList.add(new ProductModelBean());
        }
        productModelAdapter = new ProductModelAdapter(R.layout.item_product_model, productModelBeanList);
        mRvProductModel.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvProductModel.setAdapter(productModelAdapter);
        productModelAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.tv_specification_model:
                        showProduct();
                        break;
                }
            }
        });


        mViewPagerProduct.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position==0)
                    tabSelected(mTvProductDesciption);
                else if (position==1)
                    tabSelected(mTvSpecifications);
                else if (position==2)
                    tabSelected(mTvPackagingParameters);
                else if (position==3)
                    tabSelected(mTvGuaranteeStatement);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void showProduct() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_product_details, null);
        TextView tv_name=view.findViewById(R.id.tv_name);
        RecyclerView rv_product_detail = view.findViewById(R.id.rv_product_detail);
        Button btn_close = view.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        productDetailAdapter = new ProductDetailAdapter(R.layout.item_product_details,productDetailList);
        rv_product_detail.setLayoutManager(new LinearLayoutManager(mActivity));
        rv_product_detail.setAdapter(productDetailAdapter);

        dialog = new AlertDialog.Builder(mActivity).setView(view).create();
        dialog.show();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }

    @Override
    protected void initView() {
        mTvTitle.setText("产品详情");

        mFragments = new ArrayList<>();
        mFragments.add(ProductDesciptionFragment.newInstance("", ""));
        mFragments.add(ProductSpecificationsFragment.newInstance("", ""));
        mFragments.add(ProductParametersFragment.newInstance("", ""));
        mFragments.add(ProductStatementFragment.newInstance("", ""));
        mViewPagerProduct.setCurrentItem(0);
        mViewPagerProduct.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mViewPagerProduct.setOffscreenPageLimit(5);
        mTvProductDesciption.setSelected(true);

    }

    @Override
    protected void setListener() {
        mTvPackagingParameters.setOnClickListener(this);
        mTvProductDesciption.setOnClickListener(this);
        mTvSpecifications.setOnClickListener(this);
        mTvGuaranteeStatement.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_product_desciption:
                tabSelected(mTvProductDesciption);
                mViewPagerProduct.setCurrentItem(0);
                break;
            case R.id.tv_specifications:
                tabSelected(mTvSpecifications);
                mViewPagerProduct.setCurrentItem(1);
                break;
            case R.id.tv_packaging_parameters:
                tabSelected(mTvPackagingParameters);
                mViewPagerProduct.setCurrentItem(2);
                break;
            case R.id.tv_guarantee_statement:
                tabSelected(mTvGuaranteeStatement);
                mViewPagerProduct.setCurrentItem(3);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void tabSelected(TextView linearLayout) {
        mTvProductDesciption.setSelected(false);
        mTvSpecifications.setSelected(false);
        mTvPackagingParameters.setSelected(false);
        mTvGuaranteeStatement.setSelected(false);
        linearLayout.setSelected(true);
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
