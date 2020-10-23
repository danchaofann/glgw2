package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.interfaces.OnSelectListener;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DocumentDetailsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_customer_name)
    TextView mTvCustomerName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_company)
    TextView mTvCompany;
    @BindView(R.id.tv_shipping_address)
    TextView mTvShippingAddress;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
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
    private AttachPopupView attachPopupView;

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
        return R.layout.activity_document_details;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("单据明细");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlShipping.setOnClickListener(this);
        mLlInstallation.setOnClickListener(this);
        mLlTax.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                break;
            case R.id.ll_shipping:
                showChoose(v);
                break;
            case R.id.ll_installation:
                showChoose(v);
                break;
            case R.id.ll_tax:
                showChoose(v);
                break;
        }
    }

    private void showChoose(View v) {
        attachPopupView = new XPopup.Builder(mActivity)
                .hasShadowBg(false)
//                            .isDestroyOnDismiss(true) //对于只使用一次的弹窗，推荐设置这个
//                        .isDarkTheme(true)
//                        .popupAnimation(PopupAnimation.NoAnimation) //NoAnimation表示禁用动画
                .isCenterHorizontal(true) //是否与目标水平居中对齐
//                        .offsetY(-60)
//                        .offsetX(80)
//                        .popupPosition(PopupPosition.Top) //手动指定弹窗的位置
                .atView(v)  // 依附于所点击的View，内部会自动判断在上方或者下方显示\
                .asAttachList(new String[]{"                         是                         ", "                         否                         "},
                        null,0,0 ,new OnSelectListener() {
                    @Override
                    public void onSelect(int position, String text) {
                        ToastUtils.showShort("click " + text);
                    }
                });
        attachPopupView.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
