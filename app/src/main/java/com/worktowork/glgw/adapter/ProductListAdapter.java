package com.worktowork.glgw.adapter;

import android.graphics.Color;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.ProductListBean;

import java.util.List;

public class ProductListAdapter extends BaseQuickAdapter<ProductListBean, BaseViewHolder> {
    public ProductListAdapter(int layoutResId, @Nullable List<ProductListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductListBean item) {
        if (helper.getLayoutPosition()%2==0){
            helper.setBackgroundRes(R.id.ll_content, R.color.white);
        }
    }
}
