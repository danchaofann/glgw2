package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.StaffManagementBean;

import java.util.List;

public class StaffManagementAdapter extends BaseQuickAdapter<StaffManagementBean, BaseViewHolder> {
    public StaffManagementAdapter(int layoutResId, @Nullable List<StaffManagementBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StaffManagementBean item) {
        helper.addOnClickListener(R.id.ll_standard)
                .addOnClickListener(R.id.ll_no_standard);
    }
}
