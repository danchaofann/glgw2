package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.SearchDeatilProduct;

import java.util.List;

public class SearchDeatilAdapter extends BaseQuickAdapter<SearchDeatilProduct, BaseViewHolder> {
    public SearchDeatilAdapter(int layoutResId, @Nullable List<SearchDeatilProduct> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchDeatilProduct item) {

    }
}
