package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.StatisticsBean;

import java.util.List;

public class StatisticsAdapter extends BaseQuickAdapter<StatisticsBean, BaseViewHolder> {
    public StatisticsAdapter(int layoutResId, @Nullable List<StatisticsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StatisticsBean item) {

    }
}
