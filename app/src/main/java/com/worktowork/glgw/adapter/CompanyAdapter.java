package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.CompanyBean;

import java.util.List;

public class CompanyAdapter extends BaseQuickAdapter<CompanyBean, BaseViewHolder> {
    public CompanyAdapter(int layoutResId, @Nullable List<CompanyBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CompanyBean item) {

    }
}
