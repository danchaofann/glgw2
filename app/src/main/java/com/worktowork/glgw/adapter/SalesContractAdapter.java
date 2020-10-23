package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.SalesContractBean;

import java.util.List;

public class SalesContractAdapter extends BaseQuickAdapter<SalesContractBean, BaseViewHolder> {
    public SalesContractAdapter(int layoutResId, @Nullable List<SalesContractBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SalesContractBean item) {

    }
}
