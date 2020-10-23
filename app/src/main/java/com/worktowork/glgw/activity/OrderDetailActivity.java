package com.worktowork.glgw.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.chaychan.viewlib.ExpandableLinearLayout;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_express_delivery)
    TextView mTvExpressDelivery;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_address)
    TextView mTvAddress;
    @BindView(R.id.ell_product)
    ExpandableLinearLayout mEllProduct;
    @BindView(R.id.tv_product_goods)
    TextView mTvProductGoods;
    @BindView(R.id.tv_logistics_costs)
    TextView mTvLogisticsCosts;
    @BindView(R.id.tv_settlement_amount)
    TextView mTvSettlementAmount;
    @BindView(R.id.tv_order_number)
    TextView mTvOrderNumber;
    @BindView(R.id.tv_copy)
    TextView mTvCopy;
    @BindView(R.id.tv_order_time)
    TextView mTvOrderTime;
    @BindView(R.id.tv_payment_method)
    TextView mTvPaymentMethod;
    @BindView(R.id.tv_order_notes)
    TextView mTvOrderNotes;
    @BindView(R.id.tv_income)
    TextView mTvIncome;
    @BindView(R.id.tv_shipment_number)
    TextView mTvShipmentNumber;
    @BindView(R.id.tv_logistics_copy)
    TextView mTvLogisticsCopy;
    @BindView(R.id.ll_logistics)
    LinearLayout mLlLogistics;
    private List<OrderBean> list = new ArrayList<>();

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
        return R.layout.activity_order_detail;
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
        mTvTitle.setText("订单详情");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlLogistics.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_logistics:
                startActivity(new Intent(mActivity,LogisticsDetailsActivity.class));
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class ViewHolder {

        public ViewHolder(View view, OrderBean productBean) {


        }

        private void refreshUI() {


        }
    }
}
