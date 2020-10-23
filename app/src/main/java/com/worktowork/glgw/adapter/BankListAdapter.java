package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.BankBean;

import java.util.List;

public class BankListAdapter extends BaseQuickAdapter<BankBean, BaseViewHolder> {
    public BankListAdapter(int layoutResId, @Nullable List<BankBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BankBean item) {

    }
}
