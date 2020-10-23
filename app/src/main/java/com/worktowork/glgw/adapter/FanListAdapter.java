package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.FanList;

import java.util.List;

public class FanListAdapter extends BaseQuickAdapter<FanList, BaseViewHolder> {
    public FanListAdapter(int layoutResId, @Nullable List<FanList> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FanList item) {

    }
}
