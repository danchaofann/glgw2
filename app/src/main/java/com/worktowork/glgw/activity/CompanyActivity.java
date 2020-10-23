package com.worktowork.glgw.activity;

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
import com.worktowork.glgw.adapter.CompanyAdapter;
import com.worktowork.glgw.adapter.ProductDetailAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.CompanyBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompanyActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_company)
    TextView mTvCompany;
    @BindView(R.id.iv_change)
    ImageView mIvChange;
    @BindView(R.id.tv_join_time)
    TextView mTvJoinTime;
    @BindView(R.id.tv_account_type)
    TextView mTvAccountType;
    @BindView(R.id.tv_leaving)
    TextView mTvLeaving;
    private AlertDialog dialog;
    private List<CompanyBean> list=new ArrayList<>();
    private CompanyAdapter adapter;

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
        return R.layout.activity_company;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("我的公司");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mTvLeaving.setOnClickListener(this);
        mIvChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_leaving:
                dialogLeaving();
                break;
            case R.id.iv_change:
                showCompany();
                break;
        }
    }

    private void showCompany() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_switch_company, null);
        ImageView iv_close=view.findViewById(R.id.iv_close);
        RecyclerView rv_company=view.findViewById(R.id.rv_company);
        Button btn_sure=view.findViewById(R.id.btn_sure);
        for (int i = 0; i < 3; i++) {
            list.add(new CompanyBean());
        }
        adapter = new CompanyAdapter(R.layout.item_company,list);
        rv_company.setLayoutManager(new LinearLayoutManager(mActivity));
        rv_company.setAdapter(adapter);

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog = new AlertDialog.Builder(mActivity).setView(view).create();
        dialog.show();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }

    private void dialogLeaving() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_prompt, null);
        TextView tv_cancel=view.findViewById(R.id.tv_cancel);
        TextView tv_leaving=view.findViewById(R.id.tv_leaving);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog = new AlertDialog.Builder(mActivity).setView(view).create();
        dialog.show();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
//        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
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
