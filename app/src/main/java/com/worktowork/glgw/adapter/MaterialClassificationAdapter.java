package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.MaterialClassificationBean;

import java.util.List;

public class MaterialClassificationAdapter extends BaseQuickAdapter<MaterialClassificationBean, BaseViewHolder> {
    public MaterialClassificationAdapter(int layoutResId, @Nullable List<MaterialClassificationBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MaterialClassificationBean item) {

    }
}
