package com.worktowork.glgw.activity;

import android.media.MediaRouter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.StatisticsAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.StatisticsBean;
import com.worktowork.glgw.weight.CustomPartShadowPopupView;
import com.worktowork.glgw.weight.FilterPopupView;
import com.worktowork.glgw.weight.TotalOrderValuePopupView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.rv_statistics)
    RecyclerView mRvStatistics;
    @BindView(R.id.tv_total_order)
    TextView mTvTotalOrder;
    @BindView(R.id.ll_time)
    LinearLayout mLlTime;
    @BindView(R.id.ll_filter)
    LinearLayout mLlFilter;
    private List<StatisticsBean> list = new ArrayList<>();
    private StatisticsAdapter adapter;
    private CustomPartShadowPopupView popupView;
    private FilterPopupView filterPopupView;
    private TotalOrderValuePopupView totalOrderValuePopupView;
    private BasePopupView xPopup;
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
        return R.layout.activity_statistics;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            list.add(new StatisticsBean());
        }
        adapter = new StatisticsAdapter(R.layout.item_statistics, list);
        mRvStatistics.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvStatistics.setAdapter(adapter);

        totalOrderValuePopupView=new TotalOrderValuePopupView(mActivity);
        xPopup= new XPopup.Builder(mActivity)
                .popupPosition(PopupPosition.Right)//右边
                .hasStatusBarShadow(true) //启用状态栏阴影
                .asCustom(totalOrderValuePopupView);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("数据统计");

        mTvAll.setSelected(true);
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlTime.setOnClickListener(this);
        mLlFilter.setOnClickListener(this);
        mTvTotalOrder.setOnClickListener(this);
        mTvAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_all:
                mTvAll.setSelected(true);
                mLlTime.setSelected(false);
                mLlFilter.setSelected(false);
                break;
            case R.id.ll_time:
                mTvAll.setSelected(false);
                mLlTime.setSelected(true);
                mLlFilter.setSelected(false);
                showPartShadow(v);
                break;
            case R.id.ll_filter:
                mTvAll.setSelected(false);
                mLlTime.setSelected(false);
                mLlFilter.setSelected(true);
                showFilter(v);
                break;
            case R.id.tv_total_order:
                xPopup.show();
                break;


        }
    }

    private void showFilter(final View v) {
        if (filterPopupView==null){
            filterPopupView = (FilterPopupView) new XPopup.Builder(mActivity)
                    .atView(v)
//                    .isClickThrough(true)
//                    .dismissOnTouchOutside(false)
//                    .isCenterHorizontal(true)
                    .autoOpenSoftInput(true)
//                    .offsetY(100)
//                    .offsetX(100)
//                .dismissOnTouchOutside(false)
                    .asCustom(new FilterPopupView(mActivity));
            EditText et_gross_start=filterPopupView.findViewById(R.id.et_gross_start);
            EditText et_gross_end=filterPopupView.findViewById(R.id.et_gross_end);
            EditText et_order_start=filterPopupView.findViewById(R.id.et_order_start);
            EditText et_order_end=filterPopupView.findViewById(R.id.et_order_end);
            TextView tv_reset=filterPopupView.findViewById(R.id.tv_reset);
            TextView tv_determine=filterPopupView.findViewById(R.id.tv_determine);
            tv_reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    filterPopupView.dismiss();
                }
            });

        }

        filterPopupView.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void showPartShadow(final View v) {
        if (popupView == null) {
            popupView = (CustomPartShadowPopupView) new XPopup.Builder(mActivity)
                    .atView(v)
//                    .isClickThrough(true)
//                    .dismissOnTouchOutside(false)
//                    .isCenterHorizontal(true)
//                    .autoOpenSoftInput(true)
//                    .offsetY(100)
//                    .offsetX(100)
//                .dismissOnTouchOutside(false)
                    .asCustom(new CustomPartShadowPopupView(mActivity));

            TextView tv_order_time = popupView.findViewById(R.id.tv_order_time);
            TextView tv_manual_filter = popupView.findViewById(R.id.tv_manual_filter);
            LinearLayout ll_time = popupView.findViewById(R.id.ll_time);
            LinearLayout ll_filter = popupView.findViewById(R.id.ll_filter);
            TextView tv_seven = popupView.findViewById(R.id.tv_seven);
            TextView tv_thirty = popupView.findViewById(R.id.tv_thirty);
            TextView tv_year = popupView.findViewById(R.id.tv_year);
            TextView tv_reset = popupView.findViewById(R.id.tv_reset);
            TextView tv_sure = popupView.findViewById(R.id.tv_sure);
            tv_order_time.setSelected(true);
            tv_order_time.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_order_time.setSelected(true);
                    tv_manual_filter.setSelected(false);
                    ll_time.setVisibility(View.VISIBLE);
                    ll_filter.setVisibility(View.GONE);
                }
            });
            tv_manual_filter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv_order_time.setSelected(false);
                    tv_manual_filter.setSelected(true);
                    ll_time.setVisibility(View.GONE);
                    ll_filter.setVisibility(View.VISIBLE);
                }
            });

            tv_reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupView.dismiss();
                }
            });

        }

        popupView.show();
    }
}
