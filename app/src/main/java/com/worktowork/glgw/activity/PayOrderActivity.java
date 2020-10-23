package com.worktowork.glgw.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.ChooseBankAdapter;
import com.worktowork.glgw.adapter.ProductDetailAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.BankBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayOrderActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_pay_money)
    TextView mTvPayMoney;
    @BindView(R.id.tv_order_type)
    TextView mTvOrderType;
    @BindView(R.id.tv_order_number)
    TextView mTvOrderNumber;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    @BindView(R.id.tv_bank)
    TextView mTvBank;
    @BindView(R.id.tv_payable)
    TextView mTvPayable;
    @BindView(R.id.tv_pay)
    TextView mTvPay;
    @BindView(R.id.ll_bank)
    LinearLayout mLlBank;
    private AlertDialog dialog;
    private List<BankBean> list=new ArrayList<>();
    private ChooseBankAdapter adapter;

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
        return R.layout.activity_pay_order;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("支付订单");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlBank.setOnClickListener(this);
        mTvPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_bank:
                showBank();
                break;
            case R.id.tv_pay:
                startActivity(new Intent(mActivity,PaymentSuccessfulActivity.class));
                break;
        }
    }

    private void showBank() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_choose_bank, null);
        ImageView iv_close=view.findViewById(R.id.iv_close);
        RecyclerView rv_bank=view.findViewById(R.id.rv_bank);
        TextView tv_sure=view.findViewById(R.id.tv_sure);
        for (int i = 0; i < 3; i++) {
            list.add(new BankBean());
        }
        adapter = new ChooseBankAdapter(R.layout.item_bank,list);
        rv_bank.setLayoutManager(new LinearLayoutManager(mActivity));
        rv_bank.setAdapter(adapter);
        dialog = new AlertDialog.Builder(mActivity).setView(view).create();
        dialog.show();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
//        lp.gravity = Gravity.BOTTOM;
//        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
