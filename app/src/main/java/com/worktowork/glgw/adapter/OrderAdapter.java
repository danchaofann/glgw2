package com.worktowork.glgw.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chaychan.viewlib.ExpandableLinearLayout;
import com.worktowork.glgw.R;
import com.worktowork.glgw.bean.OrderBean;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseQuickAdapter<OrderBean, BaseViewHolder> {
    private List<OrderBean> list=new ArrayList<>();
    public OrderAdapter(int layoutResId, @Nullable List<OrderBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderBean item) {
        ExpandableLinearLayout ell_product = helper.getView(R.id.ell_product);
        ell_product.removeAllViews();//清除所有的子View（避免重新刷新数据时重复添加）
        for (int i = 0; i < 2; i++) {
            list.add(new OrderBean());
        }
        for (int i = 0; i < 2; i++) {
            View view = View.inflate(mContext, R.layout.item_order_list, null);

            ViewHolder viewHolder = new ViewHolder(view, list.get(i));
            viewHolder.refreshUI();
            ell_product.addItem(view);//添加子条目
        }
    }

    class ViewHolder {



        public ViewHolder(View view, OrderBean productBean) {


        }

        private void refreshUI() {


        }
    }
}
