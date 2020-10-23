package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.EditQuoteAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.CreateInquiryBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditQuoteActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_document_type)
    TextView mTvDocumentType;
    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.tv_sales_organization)
    TextView mTvSalesOrganization;
    @BindView(R.id.tv_account_manager)
    TextView mTvAccountManager;
    @BindView(R.id.tv_message_number)
    TextView mTvMessageNumber;
    @BindView(R.id.tv_document_number)
    TextView mTvDocumentNumber;
    @BindView(R.id.et_customer_name)
    EditText mEtCustomerName;
    @BindView(R.id.tv_phone)
    EditText mTvPhone;
    @BindView(R.id.tv_company)
    EditText mTvCompany;
    @BindView(R.id.tv_shipping_address)
    TextView mTvShippingAddress;
    @BindView(R.id.tv_address)
    EditText mTvAddress;
    @BindView(R.id.rv_edit_quote)
    RecyclerView mRvEditQuote;
    @BindView(R.id.ll_add_product)
    LinearLayout mLlAddProduct;
    @BindView(R.id.et_payment_terms)
    EditText mEtPaymentTerms;
    @BindView(R.id.tv_shipping)
    TextView mTvShipping;
    @BindView(R.id.ll_shipping)
    LinearLayout mLlShipping;
    @BindView(R.id.tv_installation)
    TextView mTvInstallation;
    @BindView(R.id.ll_installation)
    LinearLayout mLlInstallation;
    @BindView(R.id.tv_tax)
    TextView mTvTax;
    @BindView(R.id.ll_tax)
    LinearLayout mLlTax;
    @BindView(R.id.tv_arrival_time)
    TextView mTvArrivalTime;
    @BindView(R.id.ll_arrival_time)
    LinearLayout mLlArrivalTime;
    @BindView(R.id.tv_copy_details)
    TextView mTvCopyDetails;
    @BindView(R.id.tv_submit)
    TextView mTvSubmit;
    private List<CreateInquiryBean> list=new ArrayList<>();
    private EditQuoteAdapter adapter;
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
        return R.layout.activity_edit_quote;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new CreateInquiryBean());
        }
        adapter = new EditQuoteAdapter(R.layout.item_edit_quote,list);
        mRvEditQuote.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvEditQuote.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("编辑报价单");
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
