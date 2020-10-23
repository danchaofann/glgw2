package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.WithdrawalDetailsBean;

import java.util.List;

public class WithdrawalDetailsAdapter extends BaseQuickAdapter<WithdrawalDetailsBean, BaseViewHolder> {
    public WithdrawalDetailsAdapter(int layoutResId, @Nullable List<WithdrawalDetailsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WithdrawalDetailsBean item) {

    }
}
