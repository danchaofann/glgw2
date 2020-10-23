package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.chaychan.viewlib.ExpandableLinearLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AfterSaleOrderActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.iv_state)
    ImageView mIvState;
    @BindView(R.id.tv_state)
    TextView mTvState;
    @BindView(R.id.iv_rights_protection1)
    ImageView mIvRightsProtection1;
    @BindView(R.id.tv_name1)
    TextView mTvName1;
    @BindView(R.id.tv_rights_time)
    TextView mTvRightsTime;
    @BindView(R.id.iv_rights_protection2)
    ImageView mIvRightsProtection2;
    @BindView(R.id.tv_name2)
    TextView mTvName2;
    @BindView(R.id.tv_application)
    TextView mTvApplication;
    @BindView(R.id.iv_rights_protection4)
    ImageView mIvRightsProtection4;
    @BindView(R.id.tv_name3)
    TextView mTvName3;
    @BindView(R.id.tv_returns)
    TextView mTvReturns;
    @BindView(R.id.ll_returns)
    LinearLayout mLlReturns;
    @BindView(R.id.iv_rights_protection3)
    ImageView mIvRightsProtection3;
    @BindView(R.id.tv_name4)
    TextView mTvName4;
    @BindView(R.id.tv_refund)
    TextView mTvRefund;
    @BindView(R.id.tv_courier_company)
    TextView mTvCourierCompany;
    @BindView(R.id.tv_tracking_number)
    TextView mTvTrackingNumber;
    @BindView(R.id.tv_copy)
    TextView mTvCopy;
    @BindView(R.id.iv_pic_one)
    ImageView mIvPicOne;
    @BindView(R.id.iv_pic_two)
    ImageView mIvPicTwo;
    @BindView(R.id.ll_logistics)
    LinearLayout mLlLogistics;
    @BindView(R.id.ell_product)
    ExpandableLinearLayout mEllProduct;
    @BindView(R.id.tv_total)
    TextView mTvTotal;
    @BindView(R.id.tv_total_money)
    TextView mTvTotalMoney;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_refund_amount)
    TextView mTvRefundAmount;
    @BindView(R.id.tv_reason)
    TextView mTvReason;
    @BindView(R.id.tv_explanation)
    TextView mTvExplanation;
    @BindView(R.id.tv_rights_code)
    TextView mTvRightsCode;
    @BindView(R.id.rv_certificate)
    RecyclerView mRvCertificate;
    @BindView(R.id.tv_order_number)
    TextView mTvOrderNumber;
    @BindView(R.id.tv_order_amount)
    TextView mTvOrderAmount;
    @BindView(R.id.tv_buyer)
    TextView mTvBuyer;
    @BindView(R.id.tv_payment_time)
    TextView mTvPaymentTime;
    @BindView(R.id.tv_payment_method)
    TextView mTvPaymentMethod;
    private List<OrderBean> list=new ArrayList<>();
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
        return R.layout.activity_after_sale_order;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new OrderBean());
        }

        for (int i = 0; i < 3; i++) {
            View view = View.inflate(mActivity, R.layout.item_order_list, null);

            ViewHolder viewHolder = new ViewHolder(view, list.get(i));
            viewHolder.refreshUI();
            mEllProduct.addItem(view);//添加子条目
        }
    }

    @Override
    protected void initView() {
        mTvTitle.setText("售后订单");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
        }
    }

    class ViewHolder {

        public ViewHolder(View view, OrderBean productBean) {


        }

        private void refreshUI() {


        }
    }
}
