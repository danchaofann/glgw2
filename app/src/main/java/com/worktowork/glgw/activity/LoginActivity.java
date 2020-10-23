package com.worktowork.glgw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_close)
    ImageView mIvClose;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.iv_clear)
    ImageView mIvClear;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.ll_retrieve_password)
    LinearLayout mLlRetrievePassword;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.btn_code)
    Button mBtnCode;
    @BindView(R.id.tv_service_agreement)
    TextView mTvServiceAgreement;
    @BindView(R.id.tv_privacy_agreement)
    TextView mTvPrivacyAgreement;
    @BindView(R.id.iv_call)
    ImageView mIvCall;
    @BindView(R.id.iv_account)
    ImageView mIvAccount;
    @BindView(R.id.iv_password)
    ImageView mIvPassword;
    @BindView(R.id.ll_password)
    LinearLayout mLlPassword;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.ll_code)
    LinearLayout mLlCode;
    @BindView(R.id.tv_get_code)
    TextView mTvGetCode;
    @BindView(R.id.iv_eye)
    CheckBox mIvEye;
    private String type = "1";

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
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mBtnCode.setOnClickListener(this);
        mLlRetrievePassword.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mIvEye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // 输入一个对用户可见的密码
                    // mPasswordView.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    // 输入一个对用户不可见的密码
                    //mPasswordView.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    mEtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_retrieve_password:
                startActivity(new Intent(mActivity, RetrievePasswordActivity.class));
                break;
            case R.id.btn_code:
                if ("1".equals(type)) {
                    type = "2";
                    mLlPassword.setVisibility(View.GONE);
                    mLlCode.setVisibility(View.VISIBLE);
                    mBtnCode.setText("账号密码登录");
                    mEtPhone.setHint("请输入手机号码");
                    mIvAccount.setImageResource(R.mipmap.person);
                } else {
                    type = "1";
                    mLlPassword.setVisibility(View.VISIBLE);
                    mLlCode.setVisibility(View.GONE);
                    mBtnCode.setText("手机验证码登录");
                    mEtPhone.setHint("请输入登录账号");
                    mIvAccount.setImageResource(R.mipmap.phone);
                }
                break;
            case R.id.btn_login:
//                startActivity(new Intent(mActivity, MainActivity.class));
                startActivity(new Intent(mActivity, ChooseIdentityActivity.class));
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
