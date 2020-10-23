package com.worktowork.glgw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.MaterialDetailsAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.MaterialDetailsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//询单详情
public class InquiryDetailsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_status)
    TextView mTvStatus;
    @BindView(R.id.tv_sale_name)
    TextView mTvSaleName;
    @BindView(R.id.tv_sale_phone)
    TextView mTvSalePhone;
    @BindView(R.id.tv_submission_time)
    TextView mTvSubmissionTime;
    @BindView(R.id.tv_copy_details)
    TextView mTvCopyDetails;
    @BindView(R.id.iv_rights_protection1)
    ImageView mIvRightsProtection1;
    @BindView(R.id.tv_name1)
    TextView mTvName1;
    @BindView(R.id.tv_pending_order)
    TextView mTvPendingOrder;
    @BindView(R.id.iv_rights_protection2)
    ImageView mIvRightsProtection2;
    @BindView(R.id.view_line2)
    View mViewLine2;
    @BindView(R.id.tv_name2)
    TextView mTvName2;
    @BindView(R.id.tv_pending_declaration)
    TextView mTvPendingDeclaration;
    @BindView(R.id.view_line3)
    View mViewLine3;
    @BindView(R.id.iv_rights_protection3)
    ImageView mIvRightsProtection3;
    @BindView(R.id.view_line_right3)
    View mViewLineRight3;
    @BindView(R.id.tv_name3)
    TextView mTvName3;
    @BindView(R.id.tv_quoted)
    TextView mTvQuoted;
    @BindView(R.id.view_line4)
    View mViewLine4;
    @BindView(R.id.iv_rights_protection4)
    ImageView mIvRightsProtection4;
    @BindView(R.id.tv_name4)
    TextView mTvName4;
    @BindView(R.id.tv_adjusted)
    TextView mTvAdjusted;
    @BindView(R.id.ll_document_details)
    LinearLayout mLlDocumentDetails;
    @BindView(R.id.ll_material_details)
    LinearLayout mLlMaterialDetails;
    @BindView(R.id.rv_material_details)
    RecyclerView mRvMaterialDetails;
    @BindView(R.id.tv_cancel_inquiry)
    TextView mTvCancelInquiry;
    @BindView(R.id.tv_contact)
    TextView mTvContact;
    @BindView(R.id.btn_sales_order)
    Button mBtnSalesOrder;
    private List<MaterialDetailsBean> list = new ArrayList<>();
    private MaterialDetailsAdapter adapter;

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
        return R.layout.activity_inquiry_details;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new MaterialDetailsBean());
        }

        adapter = new MaterialDetailsAdapter(R.layout.item_material_details, list);
        mRvMaterialDetails.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvMaterialDetails.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("询单详情");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlDocumentDetails.setOnClickListener(this);
        mLlMaterialDetails.setOnClickListener(this);
        mBtnSalesOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_document_details:
                startActivity(new Intent(mActivity, DocumentDetailsActivity.class));
                break;
            case R.id.ll_material_details:
                startActivity(new Intent(mActivity, ProductListActivity.class));
                break;
            case R.id.btn_sales_order:
                startActivity(new Intent(mActivity,CreateInquiryActivity.class));
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
