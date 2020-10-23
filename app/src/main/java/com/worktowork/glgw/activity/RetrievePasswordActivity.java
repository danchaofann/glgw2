package com.worktowork.glgw.activity;

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

public class RetrievePasswordActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_captcha)
    EditText mEtCaptcha;
    @BindView(R.id.tv_captcha)
    TextView mTvCaptcha;
    @BindView(R.id.ll_captcha)
    LinearLayout mLlCaptcha;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.ll_password)
    LinearLayout mLlPassword;
    @BindView(R.id.btn_sure)
    Button mBtnSure;
    @BindView(R.id.iv_clear)
    ImageView mIvClear;
    @BindView(R.id.iv_eye)
    CheckBox mIvEye;

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
        return R.layout.activity_retrieve_password;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
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
