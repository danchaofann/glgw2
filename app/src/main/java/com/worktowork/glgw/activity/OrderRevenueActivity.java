package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.lxj.xpopup.XPopup;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.OrderRevenueAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.OrderRevenueBean;
import com.worktowork.glgw.weight.FilterPopupView;
import com.worktowork.glgw.weight.OrderRevenuePopupView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderRevenueActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_all)
    TextView mTvAll;
    @BindView(R.id.tv_today)
    TextView mTvToday;
    @BindView(R.id.ll_filter)
    LinearLayout mLlFilter;
    @BindView(R.id.tv_income)
    TextView mTvIncome;
    @BindView(R.id.rv_order_revenue)
    RecyclerView mRvOrderRevenue;
    private List<OrderRevenueBean> list=new ArrayList<>();
    private OrderRevenueAdapter adapter;
    private OrderRevenuePopupView orderRevenuePopupView;

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
        return R.layout.activity_order_revenue;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new OrderRevenueBean());
        }
        adapter = new OrderRevenueAdapter(R.layout.item_order_revenue,list);
        mRvOrderRevenue.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvOrderRevenue.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("标品订单收益");

        mTvAll.setSelected(true);
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mTvAll.setOnClickListener(this);
        mTvToday.setOnClickListener(this);
        mLlFilter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_all:
                mTvAll.setSelected(true);
                mTvToday.setSelected(false);
                mLlFilter.setSelected(false);
                break;
            case R.id.tv_today:
                mTvAll.setSelected(false);
                mTvToday.setSelected(true);
                mLlFilter.setSelected(false);
                break;
            case R.id.ll_filter:
                mTvAll.setSelected(false);
                mTvToday.setSelected(false);
                mLlFilter.setSelected(true);
                showFilter(v);
                break;

        }
    }

    private void showFilter(View v) {
        if (orderRevenuePopupView==null){
            orderRevenuePopupView = (OrderRevenuePopupView) new XPopup.Builder(mActivity)
                    .atView(v)
//                    .isClickThrough(true)
//                    .dismissOnTouchOutside(false)
//                    .isCenterHorizontal(true)
//                    .autoOpenSoftInput(true)
//                    .offsetY(100)
//                    .offsetX(100)
//                .dismissOnTouchOutside(false)
                    .asCustom(new OrderRevenuePopupView(mActivity));
            TextView tv_start_time=orderRevenuePopupView.findViewById(R.id.tv_start_time);
            TextView tv_end_time=orderRevenuePopupView.findViewById(R.id.tv_end_time);
            DatePicker date_picker=orderRevenuePopupView.findViewById(R.id.date_picker);
            TextView tv_reset=orderRevenuePopupView.findViewById(R.id.tv_reset);
            TextView tv_sure=orderRevenuePopupView.findViewById(R.id.tv_sure);
            tv_start_time.setSelected(true);
            tv_start_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_start_time.setSelected(true);
                    tv_end_time.setSelected(false);
                }
            });

            tv_end_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_start_time.setSelected(false);
                    tv_end_time.setSelected(true);
                }
            });
            tv_reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_start_time.setText("开始时间");
                    tv_end_time.setText("结束时间");
                }
            });

            date_picker.init(date_picker.getYear(), date_picker.getMonth(), date_picker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    if (tv_start_time.isSelected()){
                        tv_start_time.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
                    }else {
                        tv_end_time.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
                    }
                }
            });

            tv_sure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        orderRevenuePopupView.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
