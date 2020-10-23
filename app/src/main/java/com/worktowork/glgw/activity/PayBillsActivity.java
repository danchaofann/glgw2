package com.worktowork.glgw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.PayBillAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.PayBillBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayBillsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_order_total)
    TextView mTvOrderTotal;
    @BindView(R.id.tv_total_amount)
    TextView mTvTotalAmount;
    @BindView(R.id.rl_total_amoun)
    RelativeLayout mRlTotalAmoun;
    @BindView(R.id.et_pay)
    EditText mEtPay;
    @BindView(R.id.tv_all)
    TextView mTvAll;
    @BindView(R.id.tv_percentage)
    TextView mTvPercentage;
    @BindView(R.id.et_description)
    EditText mEtDescription;
    @BindView(R.id.ll_record)
    LinearLayout mLlRecord;
    @BindView(R.id.tv_amounts_payable)
    TextView mTvAmountsPayable;
    @BindView(R.id.tv_sure)
    TextView mTvSure;
    @BindView(R.id.rv_pay_bills)
    RecyclerView mRvPayBills;
    private List<PayBillBean> list = new ArrayList<>();
    private PayBillAdapter adapter;
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
        return R.layout.activity_pay_bills;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new PayBillBean());
        }

        adapter = new PayBillAdapter(R.layout.item_pay_bills, list);
        mRvPayBills.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvPayBills.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("支付账单");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mTvSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_sure:
                startActivity(new Intent(mActivity,PayOrderActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
