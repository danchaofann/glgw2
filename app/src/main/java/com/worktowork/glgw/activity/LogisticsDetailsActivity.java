package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.LogisticsAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.LogisticsBean;
import com.worktowork.glgw.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogisticsDetailsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_courier_name)
    TextView mTvCourierName;
    @BindView(R.id.tv_express_phone)
    TextView mTvExpressPhone;
    @BindView(R.id.rv_logistics)
    RecyclerView mRvLogistics;
    private List<LogisticsBean> list=new ArrayList<>();
    private LogisticsAdapter adapter;

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
        return R.layout.activity_logistics_details;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 5; i++) {
            list.add(new LogisticsBean());
        }
        adapter = new LogisticsAdapter(R.layout.item_logistics_recycle,list);
        mRvLogistics.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvLogistics.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("物流详情");
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
