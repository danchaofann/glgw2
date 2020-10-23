package com.worktowork.glgw.adapter;

import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.OrderManagementBean;

import java.util.List;

public class OrderManagementAdapter extends BaseQuickAdapter<OrderManagementBean, BaseViewHolder> {
    public OrderManagementAdapter(int layoutResId, @Nullable List<OrderManagementBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderManagementBean item) {
        helper.setText(R.id.tv_content,item.getContent());
        TextView tv_content=helper.getView(R.id.tv_content);
        if (item.isSelect()){
            tv_content.setSelected(true);
        }else {
            tv_content.setSelected(false);
        }
    }
}
