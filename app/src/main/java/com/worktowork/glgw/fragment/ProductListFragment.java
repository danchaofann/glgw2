package com.worktowork.glgw.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.ProductListAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.ProductListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProductListFragment extends BaseLazyFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_product_list)
    RecyclerView mRvProductList;
    private String mParam1;
    private List<ProductListBean> list=new ArrayList<>();
    private ProductListAdapter adapter;

    public static ProductListFragment newInstance(String param1, String param2) {
        ProductListFragment fragment = new ProductListFragment();
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
        return R.layout.fragment_product_list;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new ProductListBean());
        }
        adapter = new ProductListAdapter(R.layout.item_product_list,list);
        mRvProductList.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvProductList.setAdapter(adapter);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }
}
