package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.MaterialResultsBean;

import java.util.List;

public class MaterialResultsAdapter extends BaseQuickAdapter<MaterialResultsBean, BaseViewHolder> {
    public MaterialResultsAdapter(int layoutResId, @Nullable List<MaterialResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MaterialResultsBean item) {
        helper.addOnClickListener(R.id.iv_add);
    }
}
