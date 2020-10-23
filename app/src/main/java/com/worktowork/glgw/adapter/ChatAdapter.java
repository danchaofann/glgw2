package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.bean.ChatBean;

import java.util.List;

public class ChatAdapter extends BaseQuickAdapter<ChatBean, BaseViewHolder> {
    public ChatAdapter(int layoutResId, @Nullable List<ChatBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatBean item) {

    }
}
