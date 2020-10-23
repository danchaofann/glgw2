package com.worktowork.glgw.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.WithdrawalDetailsAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.WithdrawalDetailsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WithdrawalDetailsFragment extends BaseLazyFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_withdrawal_details)
    RecyclerView mRvWithdrawalDetails;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private String mParam1;

    private List<WithdrawalDetailsBean> list=new ArrayList<>();
    private WithdrawalDetailsAdapter adapter;

    public static WithdrawalDetailsFragment newInstance(String param1, String param2) {
        WithdrawalDetailsFragment fragment = new WithdrawalDetailsFragment();
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
        return R.layout.fragment_withdrawal_details;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new WithdrawalDetailsBean());
        }
        adapter = new WithdrawalDetailsAdapter(R.layout.item_withdrawal_details,list);
        mRvWithdrawalDetails.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvWithdrawalDetails.setAdapter(adapter);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {

    }
}
