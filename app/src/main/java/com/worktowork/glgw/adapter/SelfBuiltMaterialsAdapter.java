package com.worktowork.glgw.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.SelfBuiltMaterialsBean;

import java.util.List;

public class SelfBuiltMaterialsAdapter extends BaseQuickAdapter<SelfBuiltMaterialsBean, BaseViewHolder> {
    public SelfBuiltMaterialsAdapter(int layoutResId, @Nullable List<SelfBuiltMaterialsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelfBuiltMaterialsBean item) {
        if (item.getType()==0){
            helper.setVisible(R.id.et_content,true);
            helper.setGone(R.id.ll_choose,false);
        }else {
            helper.setVisible(R.id.ll_choose,true);
            helper.setGone(R.id.et_content,false);
        }
        helper.setText(R.id.tv_name,item.getName());
    }
}
