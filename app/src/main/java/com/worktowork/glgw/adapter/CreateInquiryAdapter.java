package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.CreateInquiryBean;

import java.util.List;

public class CreateInquiryAdapter extends BaseQuickAdapter<CreateInquiryBean, BaseViewHolder> {
    public CreateInquiryAdapter(int layoutResId, @Nullable List<CreateInquiryBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CreateInquiryBean item) {

    }
}
