package com.worktowork.glgw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.activity.AboutUsActivity;
import com.worktowork.glgw.activity.CustomerManagementActivity;
import com.worktowork.glgw.activity.FanListActivity;
import com.worktowork.glgw.activity.MemberCodeActivity;
import com.worktowork.glgw.activity.MoneyManagementActivity;
import com.worktowork.glgw.activity.MyBillActivity;
import com.worktowork.glgw.activity.OrderManagementActivity;
import com.worktowork.glgw.activity.PersonalInformationActivity;
import com.worktowork.glgw.activity.SettingsActivity;
import com.worktowork.glgw.activity.StaffManagementActivity;
import com.worktowork.glgw.base.BaseLazyFragment;

import butterknife.BindView;

public class MineFragment extends BaseLazyFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.iv_avator)
    ImageView mIvAvator;
    @BindView(R.id.tv_nickname)
    TextView mTvNickname;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.ll_mine)
    LinearLayout mLlMine;
    @BindView(R.id.tv_today_money)
    TextView mTvTodayMoney;
    @BindView(R.id.tv_all_money)
    TextView mTvAllMoney;
    @BindView(R.id.tv_watch)
    TextView mTvWatch;
    @BindView(R.id.tv_today_order)
    TextView mTvTodayOrder;
    @BindView(R.id.tv_all_order)
    TextView mTvAllOrder;
    @BindView(R.id.tv_today_fan)
    TextView mTvTodayFan;
    @BindView(R.id.tv_all_fan)
    TextView mTvAllFan;
    @BindView(R.id.ll_customer_management)
    LinearLayout mLlCustomerManagement;
    @BindView(R.id.ll_staff_management)
    LinearLayout mLlStaffManagement;
    @BindView(R.id.ll_promotion)
    LinearLayout mLlPromotion;
    @BindView(R.id.ll_warehouse)
    LinearLayout mLlWarehouse;
    @BindView(R.id.ll_about_us)
    LinearLayout mLlAboutUs;
    @BindView(R.id.ll_parent)
    LinearLayout mLlParent;
    @BindView(R.id.ll_fan_list)
    LinearLayout mLlFanList;
    @BindView(R.id.ll_my_promotion)
    LinearLayout mLlMyPromotion;
    @BindView(R.id.ll_order_management)
    LinearLayout mLlOrderManagement;
    @BindView(R.id.ll_sale_customer_management)
    LinearLayout mLlSaleCustomerManagement;
    @BindView(R.id.ll_sale)
    LinearLayout mLlSale;
    @BindView(R.id.iv_setting)
    ImageView mIvSetting;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.ll_today_order)
    LinearLayout mLlTodayOrder;
    @BindView(R.id.ll_all_order)
    LinearLayout mLlAllOrder;
    @BindView(R.id.ll_order)
    LinearLayout mLlOrder;
    @BindView(R.id.tv_company_name)
    TextView mTvCompanyName;
    @BindView(R.id.tv_current_identity)
    TextView mTvCurrentIdentity;
    @BindView(R.id.rl_identity)
    RelativeLayout mRlIdentity;
    @BindView(R.id.ll_my_bill)
    LinearLayout mLlMyBill;
    private String mParam1;

    public static MineFragment newInstance(String param1, String param2) {
        MineFragment fragment = new MineFragment();
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
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mLlMine.setOnClickListener(this);
        mLlFanList.setOnClickListener(this);
        mLlAboutUs.setOnClickListener(this);
        mIvSetting.setOnClickListener(this);
        mLlStaffManagement.setOnClickListener(this);
        mTvWatch.setOnClickListener(this);
        mLlTodayOrder.setOnClickListener(this);
        mLlMyBill.setOnClickListener(this);
        mLlPromotion.setOnClickListener(this);
        mLlCustomerManagement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_mine:
                startActivity(new Intent(mActivity, PersonalInformationActivity.class));
                break;
            case R.id.ll_fan_list:
                startActivity(new Intent(mActivity, FanListActivity.class));
                break;
            case R.id.ll_about_us:
                startActivity(new Intent(mActivity, AboutUsActivity.class));
                break;
            case R.id.iv_setting:
                startActivity(new Intent(mActivity, SettingsActivity.class));
                break;
            case R.id.ll_staff_management:
                startActivity(new Intent(mActivity, StaffManagementActivity.class));
                break;
            case R.id.tv_watch:
                startActivity(new Intent(mActivity, MoneyManagementActivity.class));
                break;
            case R.id.ll_today_order:
                startActivity(new Intent(mActivity, OrderManagementActivity.class));
                break;
            case R.id.ll_my_bill:
                startActivity(new Intent(mActivity, MyBillActivity.class));
                break;
            case R.id.ll_promotion:
                startActivity(new Intent(mActivity, MemberCodeActivity.class));
                break;
            case R.id.ll_customer_management:
                startActivity(new Intent(mActivity, CustomerManagementActivity.class));
                break;
        }
    }
}
