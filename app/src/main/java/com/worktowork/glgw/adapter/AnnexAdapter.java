package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.AnnexBean;

import java.util.List;

public class AnnexAdapter extends BaseQuickAdapter<AnnexBean, BaseViewHolder> {
    public AnnexAdapter(int layoutResId, @Nullable List<AnnexBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnnexBean item) {

    }
}
