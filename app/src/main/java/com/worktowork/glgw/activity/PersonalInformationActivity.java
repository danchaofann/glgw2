package com.worktowork.glgw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.iv_avator)
    ImageView mIvAvator;
    @BindView(R.id.fl_avator)
    FrameLayout mFlAvator;
    @BindView(R.id.tv_nickname)
    TextView mTvNickname;
    @BindView(R.id.tv_company_name)
    TextView mTvCompanyName;
    @BindView(R.id.tv_tied_number)
    TextView mTvTiedNumber;
    @BindView(R.id.tv_true_name)
    TextView mTvTrueName;
    @BindView(R.id.tv_area)
    TextView mTvArea;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.iv_certification)
    ImageView mIvCertification;
    @BindView(R.id.tv_enterprise_certification)
    TextView mTvEnterpriseCertification;
    @BindView(R.id.btn_sign_out)
    Button mBtnSignOut;
    @BindView(R.id.ll_certification)
    LinearLayout mLlCertification;
    @BindView(R.id.ll_company_name)
    LinearLayout mLlCompanyName;

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
        return R.layout.activity_personal_information;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("个人信息");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlCertification.setOnClickListener(this);
        mLlCompanyName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_certification:
                startActivity(new Intent(mActivity, EnterpriseCertificationActivity.class));
                break;
            case R.id.ll_company_name:
                startActivity(new Intent(mActivity,CompanyActivity.class));
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
