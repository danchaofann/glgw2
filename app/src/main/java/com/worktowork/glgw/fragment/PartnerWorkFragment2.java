package com.worktowork.glgw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.activity.SalesContractActivity;
import com.worktowork.glgw.activity.StatisticsActivity;
import com.worktowork.glgw.adapter.WorkAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.WorkBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PartnerWorkFragment2 extends BaseLazyFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.tv_total_order)
    TextView mTvTotalOrder;
    @BindView(R.id.tv_total_money)
    TextView mTvTotalMoney;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_type1)
    TextView mTvType1;
    @BindView(R.id.ll_inquiry)
    LinearLayout mLlInquiry;
    @BindView(R.id.rv_inquiry_management)
    RecyclerView mRvInquiryManagement;
    @BindView(R.id.ll_inquiry_management)
    LinearLayout mLlInquiryManagement;
    @BindView(R.id.tv_type2)
    TextView mTvType2;
    @BindView(R.id.ll_sales)
    LinearLayout mLlSales;
    @BindView(R.id.rv_sales_management)
    RecyclerView mRvSalesManagement;
    @BindView(R.id.ll_sales_management)
    LinearLayout mLlSalesManagement;
    @BindView(R.id.ll_statistics)
    LinearLayout mLlStatistics;
    @BindView(R.id.tv_pending)
    TextView mTvPending;
    @BindView(R.id.ll_approve)
    LinearLayout mLlApprove;
    @BindView(R.id.rl_approve)
    RelativeLayout mRlApprove;

    private String mParam1;
    private String[] saleTitle = new String[]{"待接单", "待报单", "待报价", "待调价", "待发送", "待签单", "业务完成", "已下推"};
    private Integer[] saleIcon = new Integer[]{R.mipmap.sale_one, R.mipmap.sale_two, R.mipmap.sale_three, R.mipmap.sale_four,
            R.mipmap.sale_five, R.mipmap.sale_six, R.mipmap.sale_seven, R.mipmap.sale_eight};
    private List<WorkBean> saleList1 = new ArrayList<>();
    private List<WorkBean> saleList2 = new ArrayList<>();

    private WorkAdapter saleAdapter1;
    private WorkAdapter saleAdapter2;


    private String[] buyTitle = new String[]{"待接单", "待询价", "待报价", "已报价", "待发送", "待签单", "待付款", "业务完成"};
    private Integer[] buyIcon = new Integer[]{R.mipmap.buy_one, R.mipmap.buy_two, R.mipmap.buy_three, R.mipmap.buy_four,
            R.mipmap.buy_five, R.mipmap.buy_six, R.mipmap.buy_seven, R.mipmap.buy_eight};


    public static PartnerWorkFragment2 newInstance(String param1, String param2) {
        PartnerWorkFragment2 fragment = new PartnerWorkFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 初始化沉浸式
     */
    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
//        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_partner_work2;
    }

    @Override
    protected void initData() {
        if ("销售".equals(mParam1)) {
            mTvType1.setText("询价管理");
            mTvType2.setText("销售管理");
            for (int i = 0; i < 4; i++) {
                saleList1.add(new WorkBean(saleIcon[i], saleTitle[i], 0));
//                saleList1.add(new WorkBean(buyIcon[i],buyTitle[i],0));
            }

            for (int i = 4; i < 8; i++) {
                saleList2.add(new WorkBean(saleIcon[i], saleTitle[i], 0));
//                saleList2.add(new WorkBean(buyIcon[i],buyTitle[i],0));
            }
            mRlApprove.setBackgroundResource(R.mipmap.sale_bg);
            mLlApprove.setBackgroundResource(R.drawable.btn_partner_shape);
        } else {
            mTvType1.setText("采购询价单");
            mTvType2.setText("采购订单");
            for (int i = 0; i < 4; i++) {
//            saleList1.add(new WorkBean(saleIcon[i],saleTitle[i],0));
                saleList1.add(new WorkBean(buyIcon[i], buyTitle[i], 0));
            }

            for (int i = 4; i < 8; i++) {
//            saleList2.add(new WorkBean(saleIcon[i],saleTitle[i],0));
                saleList2.add(new WorkBean(buyIcon[i], buyTitle[i], 0));
            }

            mRlApprove.setBackgroundResource(R.mipmap.buyer_bg);
            mLlApprove.setBackgroundResource(R.drawable.blue_shape);
        }
        saleAdapter1 = new WorkAdapter(R.layout.item_work, saleList1);
        mRvInquiryManagement.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mRvInquiryManagement.setAdapter(saleAdapter1);

        saleAdapter2 = new WorkAdapter(R.layout.item_work, saleList2);
        mRvSalesManagement.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mRvSalesManagement.setAdapter(saleAdapter2);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mLlStatistics.setOnClickListener(this);
        mLlInquiryManagement.setOnClickListener(this);
        mLlSalesManagement.setOnClickListener(this);
        mRlApprove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_statistics:
                startActivity(new Intent(mActivity, StatisticsActivity.class));
                break;
            case R.id.rl_approve:
                if ("销售".equals(mParam1)){
                    startActivity(new Intent(mActivity, SalesContractActivity.class));
                }else {
                    startActivity(new Intent(mActivity, SalesContractActivity.class));
                }
                break;
        }
    }
}
