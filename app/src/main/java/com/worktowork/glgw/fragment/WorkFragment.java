package com.worktowork.glgw.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.activity.CreateInquiryNewActivity;
import com.worktowork.glgw.activity.CreateSalesOrderActivity;
import com.worktowork.glgw.activity.InquiryManagementActivity;
import com.worktowork.glgw.activity.SalesContractActivity;
import com.worktowork.glgw.activity.SalesManagementActivity;
import com.worktowork.glgw.activity.StatisticsActivity;
import com.worktowork.glgw.adapter.WorkAdapter;
import com.worktowork.glgw.base.BaseLazyFragment;
import com.worktowork.glgw.bean.WorkBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WorkFragment extends BaseLazyFragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.tv_total_order)
    TextView mTvTotalOrder;
    @BindView(R.id.tv_total_money)
    TextView mTvTotalMoney;
    @BindView(R.id.ll_statistics)
    LinearLayout mLlStatistics;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.ll_inquiry)
    LinearLayout mLlInquiry;
    @BindView(R.id.rv_inquiry_management)
    RecyclerView mRvInquiryManagement;
    @BindView(R.id.ll_inquiry_management)
    LinearLayout mLlInquiryManagement;
    @BindView(R.id.ll_sales)
    LinearLayout mLlSales;
    @BindView(R.id.rv_sales_management)
    RecyclerView mRvSalesManagement;
    @BindView(R.id.ll_sales_management)
    LinearLayout mLlSalesManagement;
    @BindView(R.id.rv_create)
    RecyclerView mRvCreate;
    @BindView(R.id.ll_create)
    LinearLayout mLlCreate;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.iv_bg)
    ImageView mIvBg;
    @BindView(R.id.tv_pending)
    TextView mTvPending;
    @BindView(R.id.ll_pending)
    LinearLayout mLlPending;
    @BindView(R.id.view_pending)
    View mViewPending;
    @BindView(R.id.tv_approval_rejected)
    TextView mTvApprovalRejected;
    @BindView(R.id.ll_approval_rejected)
    LinearLayout mLlApprovalRejected;
    @BindView(R.id.ll_approve)
    LinearLayout mLlApprove;
    @BindView(R.id.rl_approve)
    RelativeLayout mRlApprove;
    @BindView(R.id.tv_type)
    TextView mTvType;
    @BindView(R.id.tv_type1)
    TextView mTvType1;
    @BindView(R.id.tv_type2)
    TextView mTvType2;
    @BindView(R.id.tv_type3)
    TextView mTvType3;
    private String mParam1;
    private String[] saleTitle = new String[]{"待接单", "待报单", "待报价", "待调价", "待发送", "待签单", "业务完成", "已下推", "创建询单", "创建销售单"};
    private Integer[] saleIcon = new Integer[]{R.mipmap.sale_one, R.mipmap.sale_two, R.mipmap.sale_three, R.mipmap.sale_four,
            R.mipmap.sale_five, R.mipmap.sale_six, R.mipmap.sale_seven, R.mipmap.sale_eight, R.mipmap.sale_nine, R.mipmap.sale_ten};
    private List<WorkBean> saleList1 = new ArrayList<>();
    private List<WorkBean> saleList2 = new ArrayList<>();
    private List<WorkBean> saleList3 = new ArrayList<>();
    private WorkAdapter saleAdapter1;
    private WorkAdapter saleAdapter2;
    private WorkAdapter saleAdapter3;


    private String[] buyTitle = new String[]{"待接单", "待询价", "待报价", "已报价", "待发送", "待签单", "待付款", "业务完成", "创建采购单", "创建询价单"};
    private Integer[] buyIcon = new Integer[]{R.mipmap.buy_one, R.mipmap.buy_two, R.mipmap.buy_three, R.mipmap.buy_four,
            R.mipmap.buy_five, R.mipmap.buy_six, R.mipmap.buy_seven, R.mipmap.buy_eight, R.mipmap.buy_nine, R.mipmap.buy_ten};

    public static WorkFragment newInstance(String param1, String param2) {
        WorkFragment fragment = new WorkFragment();
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
        mImmersionBar.statusBarView(mView);
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
        return R.layout.fragment_work;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 4; i++) {
//            saleList1.add(new WorkBean(saleIcon[i],saleTitle[i],0));
            saleList1.add(new WorkBean(buyIcon[i], buyTitle[i], 0));
        }

        for (int i = 4; i < 8; i++) {
//            saleList2.add(new WorkBean(saleIcon[i],saleTitle[i],0));
            saleList2.add(new WorkBean(buyIcon[i], buyTitle[i], 0));
        }

        for (int i = 8; i < 10; i++) {
//            saleList3.add(new WorkBean(saleIcon[i],saleTitle[i],0));
            saleList3.add(new WorkBean(buyIcon[i], buyTitle[i], 0));
        }

        saleAdapter1 = new WorkAdapter(R.layout.item_work, saleList1);
        mRvInquiryManagement.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mRvInquiryManagement.setAdapter(saleAdapter1);

        saleAdapter2 = new WorkAdapter(R.layout.item_work, saleList2);
        mRvSalesManagement.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mRvSalesManagement.setAdapter(saleAdapter2);

        saleAdapter3 = new WorkAdapter(R.layout.item_work, saleList3);
        mRvCreate.setLayoutManager(new GridLayoutManager(mActivity, 4));
        mRvCreate.setAdapter(saleAdapter3);
        saleAdapter3.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(mActivity, CreateInquiryNewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(mActivity, CreateSalesOrderActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mLlStatistics.setOnClickListener(this);
        mLlInquiry.setOnClickListener(this);
        mLlSales.setOnClickListener(this);
        mRlApprove.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_statistics:
                startActivity(new Intent(mActivity, StatisticsActivity.class));
                break;
            case R.id.ll_inquiry:
                startActivity(new Intent(mActivity, InquiryManagementActivity.class));
                break;
            case R.id.ll_sales:
                startActivity(new Intent(mActivity, SalesManagementActivity.class));
                break;
            case R.id.rl_approve:
                startActivity(new Intent(mActivity, SalesContractActivity.class));
                break;
        }
    }
}
