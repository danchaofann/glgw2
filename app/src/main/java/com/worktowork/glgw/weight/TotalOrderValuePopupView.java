package com.worktowork.glgw.weight;

import android.content.Context;

import androidx.annotation.NonNull;

import com.lxj.xpopup.core.DrawerPopupView;
import com.worktowork.glgw.R;

public class TotalOrderValuePopupView extends DrawerPopupView {

    public TotalOrderValuePopupView(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.popupview_total_order_value;
    }


}
