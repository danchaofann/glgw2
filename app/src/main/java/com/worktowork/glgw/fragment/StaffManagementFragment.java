package com.worktowork.glgw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.activity.AddEmployeeActivity;
import com.worktowork.glgw.activity.OrderRevenueActivity;
import com.worktowork.glgw.adapter.StaffManagementAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.StaffManagementBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class StaffManagementFragment extends BaseLazyFragment implements View.OnClickListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.rv_staff_management)
    RecyclerView mRvStaffManagement;
    @BindView(R.id.ll_add_employee)
    LinearLayout mLlAddEmployee;
    private String mParam1;
    private List<StaffManagementBean> list = new ArrayList<>();
    private StaffManagementAdapter adapter;

    public static StaffManagementFragment newInstance(String param1, String param2) {
        StaffManagementFragment fragment = new StaffManagementFragment();
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
        return R.layout.fragment_staff_management;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new StaffManagementBean());
        }
        adapter = new StaffManagementAdapter(R.layout.item_staff_management, list);
        mRvStaffManagement.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvStaffManagement.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.ll_standard:
                        startActivity(new Intent(mActivity, OrderRevenueActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mLlAddEmployee.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_add_employee:
                startActivity(new Intent(mActivity, AddEmployeeActivity.class));
                break;
        }
    }
}
