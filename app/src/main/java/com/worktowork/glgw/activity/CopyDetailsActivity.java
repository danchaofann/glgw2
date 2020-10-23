package com.worktowork.glgw.activity;

import android.content.Intent;
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
import com.worktowork.glgw.adapter.ChatAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.ChatBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//跟单详情
public class CopyDetailsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.iv_rights_protection1)
    ImageView mIvRightsProtection1;
    @BindView(R.id.tv_name1)
    TextView mTvName1;
    @BindView(R.id.tv_upload_files)
    TextView mTvUploadFiles;
    @BindView(R.id.iv_rights_protection2)
    ImageView mIvRightsProtection2;
    @BindView(R.id.view_line2)
    View mViewLine2;
    @BindView(R.id.tv_name2)
    TextView mTvName2;
    @BindView(R.id.tv_pending_order)
    TextView mTvPendingOrder;
    @BindView(R.id.view_line3)
    View mViewLine3;
    @BindView(R.id.iv_rights_protection3)
    ImageView mIvRightsProtection3;
    @BindView(R.id.tv_name3)
    TextView mTvName3;
    @BindView(R.id.tv_pending_declaration)
    TextView mTvPendingDeclaration;
    @BindView(R.id.iv_rights_protection4)
    ImageView mIvRightsProtection4;
    @BindView(R.id.tv_name4)
    TextView mTvName4;
    @BindView(R.id.tv_signed)
    TextView mTvSigned;
    @BindView(R.id.iv_rights_protection5)
    ImageView mIvRightsProtection5;
    @BindView(R.id.tv_name5)
    TextView mTvName5;
    @BindView(R.id.tv_completed)
    TextView mTvCompleted;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_description)
    TextView mTvDescription;
    @BindView(R.id.tv_customer_name)
    TextView mTvCustomerName;
    @BindView(R.id.tv_customer_phone)
    TextView mTvCustomerPhone;
    @BindView(R.id.tv_submission_time)
    TextView mTvSubmissionTime;
    @BindView(R.id.ll_annex)
    LinearLayout mLlAnnex;
    @BindView(R.id.ll_call)
    LinearLayout mLlCall;
    @BindView(R.id.ll_wechat)
    LinearLayout mLlWechat;
    @BindView(R.id.tv_confirm_order)
    TextView mTvConfirmOrder;
    @BindView(R.id.rv_copy_detail)
    RecyclerView mRvCopyDetail;
    private List<ChatBean> list=new ArrayList<>();
    private ChatAdapter adapter;

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
        return R.layout.activity_copy_details;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 1; i++) {
            list.add(new ChatBean());
        }

        adapter = new ChatAdapter(R.layout.item_copy_detail,list);
        mRvCopyDetail.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvCopyDetail.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("跟单详情");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlAnnex.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_annex:
                startActivity(new Intent(mActivity,ClientNeedsActivity.class));
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
