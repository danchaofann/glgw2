package com.worktowork.glgw.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.SelfBuiltMaterialsAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.SelfBuiltMaterialsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelfBuiltMaterialsActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_save)
    TextView mTvSave;
    @BindView(R.id.icon_search)
    ImageView mIconSearch;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.ll_toolbar)
    LinearLayout mLlToolbar;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.rv_self_built_materials)
    RecyclerView mRvSelfBuiltMaterials;
    private String[] mTitleDataList = new String[]{
            "物料编码", "物料名称", "实际规格型号", "表面处理工艺", "材质", "销售单位","单价","含税单价","是否赠品","税率%","金额","价税合计",
            "要货日期","库存组织","结算组织","货主类型"};
    private List<SelfBuiltMaterialsBean> list=new ArrayList<>();
    private SelfBuiltMaterialsAdapter adapter;

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
        return R.layout.activity_self_built_materials;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < mTitleDataList.length; i++) {
            if (i!=8&&i!=12){
                list.add(new SelfBuiltMaterialsBean(mTitleDataList[i],0));
            }else {
                list.add(new SelfBuiltMaterialsBean(mTitleDataList[i],1));
            }
        }

        adapter = new SelfBuiltMaterialsAdapter(R.layout.item_self_built_materials,list);
        mRvSelfBuiltMaterials.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvSelfBuiltMaterials.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("自建物料");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
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
