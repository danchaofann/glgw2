package com.worktowork.glgw.bean;

import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;

import java.util.List;

public class DownloadAttachmentsAdapter extends BaseQuickAdapter<AnnexBean, BaseViewHolder> {
    public DownloadAttachmentsAdapter(int layoutResId, @Nullable List<AnnexBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnnexBean item) {
        helper.addOnClickListener(R.id.rb_choose);
        ImageView rb_choose=helper.getView(R.id.rb_choose);
        if (item.isSelect()){
            rb_choose.setSelected(true);
        }else {
            rb_choose.setSelected(false);
        }
    }
}
