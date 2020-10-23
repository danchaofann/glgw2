package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.InquiryManagementBean;

import java.util.List;

public class InquiryManagementAdapter extends BaseQuickAdapter<InquiryManagementBean, BaseViewHolder> {
    public InquiryManagementAdapter(int layoutResId, @Nullable List<InquiryManagementBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, InquiryManagementBean item) {

    }
}
