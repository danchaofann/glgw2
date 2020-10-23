package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.IdentityBean;

import java.util.List;

public class IdentityAdapter extends BaseQuickAdapter<IdentityBean, BaseViewHolder> {
    public IdentityAdapter(int layoutResId, @Nullable List<IdentityBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, IdentityBean item) {

    }
}
