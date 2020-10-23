package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.PayBillBean;

import java.util.List;

public class PayBillAdapter extends BaseQuickAdapter<PayBillBean, BaseViewHolder> {
    public PayBillAdapter(int layoutResId, @Nullable List<PayBillBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PayBillBean item) {

    }
}
