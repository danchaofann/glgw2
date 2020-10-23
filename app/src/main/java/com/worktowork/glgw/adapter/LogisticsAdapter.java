package com.worktowork.glgw.adapter;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.LogisticsBean;
import com.worktowork.glgw.util.DensityUtil;
import com.worktowork.glgw.weight.LayoutParamsViewHolder;

import java.util.List;

public class LogisticsAdapter extends BaseQuickAdapter<LogisticsBean, LayoutParamsViewHolder> {
    public LogisticsAdapter(int layoutResId, @Nullable List<LogisticsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(LayoutParamsViewHolder helper, LogisticsBean item) {
        int position = helper.getAdapterPosition();
        if (position == 0) {
            helper.setImageResource(R.id.iv_status, R.mipmap.view_choose);
            RelativeLayout.LayoutParams pointParams = new RelativeLayout.LayoutParams(DensityUtil.dp2px(mContext, 15), DensityUtil.dp2px(mContext, 15));
            pointParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            helper.setLayoutParams(R.id.iv_status, pointParams);
            //灰色的竖线
            RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(DensityUtil.dp2px(mContext, 1), ViewGroup.LayoutParams.MATCH_PARENT);
            lineParams.addRule(RelativeLayout.BELOW, R.id.iv_status);//让直线置于圆点下面
            lineParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            helper.setLayoutParams(R.id.iv_line, lineParams);
        } else if (position == getItemCount() - 1) {
            helper.setImageResource(R.id.iv_status, R.mipmap.view_unchoose);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(DensityUtil.dp2px(mContext, 15), DensityUtil.dp2px(mContext, 15));
            lp.addRule(RelativeLayout.CENTER_IN_PARENT);
            helper.setLayoutParams(R.id.iv_status, lp);
            //灰色的竖线
            RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(DensityUtil.dp2px(mContext, 1), ViewGroup.LayoutParams.MATCH_PARENT);
            lineParams.addRule(RelativeLayout.ABOVE, R.id.iv_status);//让直线置于圆点上面
            lineParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            helper.setLayoutParams(R.id.iv_line, lineParams);

        } else {
            helper.setImageResource(R.id.iv_status, R.mipmap.view_unchoose);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(DensityUtil.dp2px(mContext, 15), DensityUtil.dp2px(mContext, 15));
            lp.addRule(RelativeLayout.CENTER_IN_PARENT);
            helper.setLayoutParams(R.id.iv_status, lp);
            //灰色的竖线
            RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(DensityUtil.dp2px(mContext, 1), ViewGroup.LayoutParams.MATCH_PARENT);
            lineParams.addRule(RelativeLayout.CENTER_IN_PARENT);
            helper.setLayoutParams(R.id.iv_line, lineParams);
        }
    }
}
