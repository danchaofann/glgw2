package com.worktowork.glgw.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.MaterialResultsAdapter;
import com.worktowork.glgw.adapter.MaterialSpecificationsAdapter;
import com.worktowork.glgw.adapter.ProductDetailAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.MaterialResultsBean;
import com.worktowork.glgw.bean.MaterialSpecificationsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
//物料查找结果
public class MaterialResultsActivity extends BaseActivity implements View.OnClickListener {

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
    @BindView(R.id.et_question)
    EditText mEtQuestion;
    @BindView(R.id.iv_close)
    ImageView mIvClose;
    @BindView(R.id.ll_self_built_materials)
    LinearLayout mLlSelfBuiltMaterials;
    @BindView(R.id.tv_default)
    TextView mTvDefault;
    @BindView(R.id.iv_price)
    ImageView mIvPrice;
    @BindView(R.id.ll_price)
    LinearLayout mLlPrice;
    @BindView(R.id.tv_filter)
    TextView mTvFilter;
    @BindView(R.id.iv_arrangement)
    ImageView mIvArrangement;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.rv_material_results)
    RecyclerView mRvMaterialResults;
    private List<MaterialResultsBean> list=new ArrayList<>();
    private MaterialResultsAdapter adapter;
    private AlertDialog dialog;

    private List<MaterialSpecificationsBean> materialSpecificationsList=new ArrayList<>();
    private MaterialSpecificationsAdapter materialSpecificationsAdapter;

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
        return R.layout.activity_material_results;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new MaterialResultsBean());
        }

        adapter = new MaterialResultsAdapter(R.layout.item_material_results,list);
        mRvMaterialResults.setLayoutManager(new LinearLayoutManager(mActivity));
        mRvMaterialResults.setAdapter(adapter);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.iv_add:
                        showSpecifications(position);
                        break;
                }
            }
        });
    }

    private void showSpecifications(int position) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_material_specifications, null);
        ImageView iv_product_view=view.findViewById(R.id.iv_product_view);
        TextView tv_product_name=view.findViewById(R.id.tv_product_name);
        TextView tv_money_start=view.findViewById(R.id.tv_money_start);
        TextView tv_money_end=view.findViewById(R.id.tv_money_end);
        RecyclerView rv_material_specifications=view.findViewById(R.id.rv_material_specifications);
        Button btn_sure=view.findViewById(R.id.btn_sure);
        for (int i = 0; i < 3; i++) {
            materialSpecificationsList.add(new MaterialSpecificationsBean());
        }

        materialSpecificationsAdapter = new MaterialSpecificationsAdapter(R.layout.item_material_specifications,materialSpecificationsList);
        rv_material_specifications.setLayoutManager(new LinearLayoutManager(mActivity));
        rv_material_specifications.setAdapter(materialSpecificationsAdapter);

        dialog = new AlertDialog.Builder(mActivity).setView(view).create();
        dialog.show();
        Window window = dialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
        window.setBackgroundDrawable(new ColorDrawable());
    }

    @Override
    protected void initView() {
        mTvTitle.setText("查找结果");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlSelfBuiltMaterials.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_self_built_materials:
                startActivity(new Intent(mActivity,SelfBuiltMaterialsActivity.class));
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
