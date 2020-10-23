package com.worktowork.glgw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.activity.CityPositioningActivity;
import com.worktowork.glgw.activity.ProductDetailsActivity;
import com.worktowork.glgw.activity.SearchActivity;
import com.worktowork.glgw.adapter.HomeProductAdapter;
import com.worktowork.glgw.adapter.ProductTypeAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.HomeProductBean;
import com.worktowork.glgw.bean.ProductTypeBean;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseLazyFragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";

    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.ll_address)
    LinearLayout mLlAddress;
    @BindView(R.id.ll_search)
    LinearLayout mLlSearch;
    @BindView(R.id.banner_home)
    Banner mBannerHome;
    @BindView(R.id.rv_product_type)
    RecyclerView mRvProductType;
    @BindView(R.id.rv_home_product)
    RecyclerView mRvHomeProduct;
    @BindView(R.id.view)
    View mView;
    private String mParam1;
    private List<ProductTypeBean> productTypeBeansList = new ArrayList<>();
    private ProductTypeAdapter productTypeAdapter;

    private List<HomeProductBean> homeProductBeanList = new ArrayList<>();
    private HomeProductAdapter homeProductAdapter;

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        mImmersionBar.statusBarView(mView);
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
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            productTypeBeansList.add(new ProductTypeBean());
            homeProductBeanList.add(new HomeProductBean());
        }
        productTypeAdapter = new ProductTypeAdapter(R.layout.item_product_type, productTypeBeansList);
        mRvProductType.setLayoutManager(new GridLayoutManager(mActivity, 5));
        mRvProductType.setAdapter(productTypeAdapter);


        homeProductAdapter = new HomeProductAdapter(R.layout.item_home_product, homeProductBeanList);
        mRvHomeProduct.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mRvHomeProduct.setAdapter(homeProductAdapter);
        homeProductAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mActivity, ProductDetailsActivity.class));
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mLlAddress.setOnClickListener(this);
        mLlSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_address:
                startActivity(new Intent(mActivity, CityPositioningActivity.class));
                break;
            case R.id.ll_search:
                startActivity(new Intent(mActivity, SearchActivity.class));
                break;
        }
    }
}
