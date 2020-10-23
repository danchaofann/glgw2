package com.worktowork.glgw.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.WorkBean;

import java.util.List;

public class WorkAdapter extends BaseQuickAdapter<WorkBean, BaseViewHolder> {
    public WorkAdapter(int layoutResId, @Nullable List<WorkBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WorkBean item) {
        try {
            ImageView iv_icon = helper.getView(R.id.iv_icon);
            Glide.with(mContext)
                    .load(item.getIcon())
                    .into(iv_icon);
            helper.setText(R.id.tv_name, item.getContent());
            TextView tv_number=helper.getView(R.id.tv_number);
            if (item.getNumber()==0){
                tv_number.setVisibility(View.GONE);
            }else {
                tv_number.setVisibility(View.VISIBLE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
