package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.SearchHot;

import java.util.List;

public class SearchHistoryAdpater extends BaseQuickAdapter<SearchHot, BaseViewHolder> {
    public SearchHistoryAdpater(int layoutResId, @Nullable List<SearchHot> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchHot item) {

    }
}
