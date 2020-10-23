package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.ProductModelBean;

import java.util.List;

public class ProductDetailAdapter extends BaseQuickAdapter<ProductModelBean, BaseViewHolder> {
    public ProductDetailAdapter(int layoutResId, @Nullable List<ProductModelBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductModelBean item) {

    }
}
