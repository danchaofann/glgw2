package com.worktowork.glgw.adapter;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.MaterialSpecificationsBean;

import java.util.List;

public class MaterialSpecificationsAdapter extends BaseQuickAdapter<MaterialSpecificationsBean, BaseViewHolder> {
    public MaterialSpecificationsAdapter(int layoutResId, @Nullable List<MaterialSpecificationsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MaterialSpecificationsBean item) {
        String name="KN95含双层熔喷布【无阀门】【1只】产品详情";
        SpannableStringBuilder style1 = new SpannableStringBuilder(name);
        style1.setSpan(new ForegroundColorSpan(Color.parseColor("#FEA23A")), name.length()-4, name.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        style1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#FEA23A")); //设置颜色
            }
        }, name.length()-4, name.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        helper.setText(R.id.tv_specification_model,style1);
        helper.addOnClickListener(R.id.tv_specification_model);
    }
}
