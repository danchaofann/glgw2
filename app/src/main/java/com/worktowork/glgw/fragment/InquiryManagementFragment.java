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
import com.worktowork.glgw.activity.CopyDetailsActivity;
import com.worktowork.glgw.activity.InquiryDetailsActivity;
import com.worktowork.glgw.activity.InquiryManagementActivity;
import com.worktowork.glgw.adapter.InquiryManagementAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.InquiryManagementBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class InquiryManagementFragment extends BaseLazyFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_inquiry_management)
    RecyclerView mRvInquiryManagement;
    private String mParam1;
    private List<InquiryManagementBean> list=new ArrayList<>();
    private InquiryManagementAdapter adapter;

    public static InquiryManagementFragment newInstance(String param1, String param2) {
        InquiryManagementFragment fragment = new InquiryManagementFragment();
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
        return R.layout.fragment_inquiry_management;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new InquiryManagementBean());
        }

        adapter = new InquiryManagementAdapter(R.layout.item_inquiry_management,list);
        mRvInquiryManagement.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvInquiryManagement.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(mActivity, CopyDetailsActivity.class));
                startActivity(new Intent(mActivity, InquiryDetailsActivity.class));
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
