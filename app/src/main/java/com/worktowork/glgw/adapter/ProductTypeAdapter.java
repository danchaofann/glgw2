package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.ProductTypeBean;

import java.util.List;

public class ProductTypeAdapter extends BaseQuickAdapter<ProductTypeBean, BaseViewHolder> {
    public ProductTypeAdapter(int layoutResId, @Nullable List<ProductTypeBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductTypeBean item) {

    }
}
