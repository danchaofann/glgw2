package com.worktowork.glgw.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WithdrawalActivity extends BaseActivity implements View.OnClickListener{
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
    @BindView(R.id.et_withdraw)
    EditText mEtWithdraw;
    @BindView(R.id.tv_all)
    TextView mTvAll;
    @BindView(R.id.iv_bank)
    ImageView mIvBank;
    @BindView(R.id.tv_bank)
    TextView mTvBank;
    @BindView(R.id.tv_default)
    TextView mTvDefault;
    @BindView(R.id.tv_bank_name)
    TextView mTvBankName;
    @BindView(R.id.ll_bank)
    LinearLayout mLlBank;
    @BindView(R.id.tv_current_identity)
    TextView mTvCurrentIdentity;
    @BindView(R.id.ll_bank_choose)
    LinearLayout mLlBankChoose;
    @BindView(R.id.btn_sure)
    Button mBtnSure;
    @BindView(R.id.btn_withdrawal_details)
    Button mBtnWithdrawalDetails;
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
        return R.layout.activity_withdrawal;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("余额提现");
        mTvSave.setVisibility(View.VISIBLE);
        mTvSave.setText("银行卡包");
        mTvSave.setTextColor(Color.parseColor("#FF295FF6"));
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mBtnWithdrawalDetails.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_withdrawal_details:
                startActivity(new Intent(mActivity,WithdrawalDetailsActivity.class));
                break;
        }
    }
}
