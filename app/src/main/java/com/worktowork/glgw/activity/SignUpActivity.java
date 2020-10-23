package com.worktowork.glgw.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.weight.paint.SignatureView;

import butterknife.BindView;
import butterknife.ButterKnife;
//签约
public class SignUpActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_demand_side)
    TextView mTvDemandSide;
    @BindView(R.id.tv_supplier)
    TextView mTvSupplier;
    @BindView(R.id.tv_payment)
    TextView mTvPayment;
    @BindView(R.id.tv_delivery_dates)
    TextView mTvDeliveryDates;
    @BindView(R.id.tv_delivery_and_acceptance)
    TextView mTvDeliveryAndAcceptance;
    @BindView(R.id.tv_freight)
    TextView mTvFreight;
    @BindView(R.id.tv_install)
    TextView mTvInstall;
    @BindView(R.id.signature_pad)
    SignatureView mSignaturePad;
    @BindView(R.id.ll_signature)
    LinearLayout mLlSignature;
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
        return R.layout.activity_sign_up;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("签约");

        gainPermission();
    }

    private void gainPermission() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(SignUpActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 4);
            } else {
//                Toast.makeText(this, "已开启权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlSignature.setOnClickListener(this);
        mBtnSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_signature:
                mLlSignature.setVisibility(View.GONE);
                break;
            case R.id.btn_sure:
                startActivity(new Intent(mActivity,SigningCompletedActivity.class));
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
