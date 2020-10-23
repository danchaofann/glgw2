package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.enums.PopupPosition;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.CategoriesAdapter;
import com.worktowork.glgw.adapter.SearchDeatilAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.CategoriesBean;
import com.worktowork.glgw.bean.SearchDeatilProduct;
import com.worktowork.glgw.weight.AutoLineFeedLayoutManager;
import com.worktowork.glgw.weight.CustomFilterDrawerPopupView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchDetailActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_search)
    TextView mTvSearch;
    @BindView(R.id.ll_search)
    LinearLayout mLlSearch;
    @BindView(R.id.tv_default)
    TextView mTvDefault;
    @BindView(R.id.iv_price)
    ImageView mIvPrice;
    @BindView(R.id.ll_price)
    LinearLayout mLlPrice;
    @BindView(R.id.iv_arrangement)
    ImageView mIvArrangement;
    @BindView(R.id.tv_filter)
    TextView mTvFilter;
    @BindView(R.id.rv_search_product)
    RecyclerView mRvSearchProduct;
    private List<SearchDeatilProduct> list=new ArrayList<>();
    private SearchDeatilAdapter adapter;
    private String type="1";
    private BasePopupView xPopup;
    private CustomFilterDrawerPopupView customFilterDrawerPopupView;
    private List<CategoriesBean> categoriesBeanList=new ArrayList<>();
    private CategoriesAdapter categoriesAdapter;

    /**
     * 初始化沉浸式
     */
    @Override
    protected void initImmersionBar() {
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarView(mView);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }
    @Override
    protected int setLayoutId() {
        return R.layout.activity_search_detail;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 6; i++) {
            list.add(new SearchDeatilProduct());
        }

        initAdapter();
        for (int i = 0; i < 10; i++) {
            categoriesBeanList.add(new CategoriesBean());
        }
        customFilterDrawerPopupView=new CustomFilterDrawerPopupView(mActivity);
        RecyclerView rv_categories=customFilterDrawerPopupView.findViewById(R.id.rv_categories);
        RecyclerView rv_brand=customFilterDrawerPopupView.findViewById(R.id.rv_brand);
        EditText et_lowest_price=customFilterDrawerPopupView.findViewById(R.id.et_lowest_price);
        EditText et_highest_price=customFilterDrawerPopupView.findViewById(R.id.et_highest_price);
        TextView tv_reset=customFilterDrawerPopupView.findViewById(R.id.tv_reset);
        TextView tv_carry_out=customFilterDrawerPopupView.findViewById(R.id.tv_carry_out);
        categoriesAdapter = new CategoriesAdapter(R.layout.item_fitter,categoriesBeanList);
        rv_categories.setLayoutManager(new AutoLineFeedLayoutManager());
        rv_categories.setAdapter(categoriesAdapter);
        rv_brand.setLayoutManager(new AutoLineFeedLayoutManager());
        rv_brand.setAdapter(categoriesAdapter);
        xPopup= new XPopup.Builder(mActivity)
                .popupPosition(PopupPosition.Right)//右边
                .hasStatusBarShadow(true) //启用状态栏阴影
                .asCustom(customFilterDrawerPopupView);
    }

    private void initAdapter() {
        if ("1".equals(type)){
            adapter = new SearchDeatilAdapter(R.layout.item_search_product,list );
            mRvSearchProduct.setLayoutManager(new GridLayoutManager(mActivity,2));
            mRvSearchProduct.setAdapter(adapter);
        }else {
            adapter = new SearchDeatilAdapter(R.layout.item_search_product2,list );
            mRvSearchProduct.setLayoutManager(new LinearLayoutManager(mActivity));
            mRvSearchProduct.setAdapter(adapter);
        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListener() {
        mIvArrangement.setOnClickListener(this);
        mTvFilter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_arrangement:
                if ("1".equals(type)){
                    type="2";
                    mIvArrangement.setImageResource(R.mipmap.icon_chui);
                    initAdapter();
                }else {
                    type="1";
                    mIvArrangement.setImageResource(R.mipmap.icon_shui);
                    initAdapter();
                }
                break;
            case R.id.tv_filter:
                xPopup.show();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
