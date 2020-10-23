package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.CategoriesBean;

import java.util.List;

public class CategoriesAdapter extends BaseQuickAdapter<CategoriesBean, BaseViewHolder> {
    public CategoriesAdapter(int layoutResId, @Nullable List<CategoriesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoriesBean item) {

    }
}
