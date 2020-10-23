package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.OrderRevenueBean;

import java.util.List;

public class OrderRevenueAdapter extends BaseQuickAdapter<OrderRevenueBean, BaseViewHolder> {
    public OrderRevenueAdapter(int layoutResId, @Nullable List<OrderRevenueBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderRevenueBean item) {

    }
}
