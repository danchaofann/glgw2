package com.worktowork.glgw.activity;

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

public class EnterpriseCertificationActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.et_company_name)
    EditText mEtCompanyName;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.et_legal_name)
    EditText mEtLegalName;
    @BindView(R.id.et_legal_phone)
    EditText mEtLegalPhone;
    @BindView(R.id.et_corporate_contact)
    EditText mEtCorporateContact;
    @BindView(R.id.et_contact_number)
    EditText mEtContactNumber;
    @BindView(R.id.et_enterprise_landline)
    EditText mEtEnterpriseLandline;
    @BindView(R.id.et_bank_name)
    EditText mEtBankName;
    @BindView(R.id.et_bank_account)
    EditText mEtBankAccount;
    @BindView(R.id.et_bank)
    EditText mEtBank;
    @BindView(R.id.et_opening_branch)
    EditText mEtOpeningBranch;
    @BindView(R.id.iv_license)
    ImageView mIvLicense;
    @BindView(R.id.iv_organization)
    ImageView mIvOrganization;
    @BindView(R.id.iv_account)
    ImageView mIvAccount;
    @BindView(R.id.iv_avatar_face)
    ImageView mIvAvatarFace;
    @BindView(R.id.iv_national_emblem)
    ImageView mIvNationalEmblem;
    @BindView(R.id.iv_handheld)
    ImageView mIvHandheld;
    @BindView(R.id.btn_sure)
    Button mBtnSure;
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
        return R.layout.activity_enterprise_certification;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("企业认证");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
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
