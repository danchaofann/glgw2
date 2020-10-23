package com.worktowork.glgw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.activity.AfterSaleOrderActivity;
import com.worktowork.glgw.activity.OrderDetailActivity;
import com.worktowork.glgw.adapter.OrderAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class OrderManagementFragment extends BaseLazyFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_order)
    RecyclerView mRvOrder;
    private String mParam1;
    private List<OrderBean> list=new ArrayList<>();
    private OrderAdapter adapter;

    public static OrderManagementFragment newInstance(String param1, String param2) {
        OrderManagementFragment fragment = new OrderManagementFragment();
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
        return R.layout.fragment_order_management;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new OrderBean());
        }

        adapter = new OrderAdapter(R.layout.item_order,list);
        mRvOrder.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvOrder.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(mActivity, OrderDetailActivity.class));
                startActivity(new Intent(mActivity, AfterSaleOrderActivity.class));
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }
}
