package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.MaterialDetailsBean;

import java.util.List;

public class SaleOrderDatailAdapter extends BaseQuickAdapter<MaterialDetailsBean, BaseViewHolder> {
    public SaleOrderDatailAdapter(int layoutResId, @Nullable List<MaterialDetailsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MaterialDetailsBean item) {

    }
}
