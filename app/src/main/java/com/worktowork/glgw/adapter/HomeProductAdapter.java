package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.HomeProductBean;

import java.util.List;

public class HomeProductAdapter extends BaseQuickAdapter<HomeProductBean, BaseViewHolder> {
    public HomeProductAdapter(int layoutResId, @Nullable List<HomeProductBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeProductBean item) {

    }
}
