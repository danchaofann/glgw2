package com.worktowork.glgw.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.AnnexAdapter;
import com.worktowork.glgw.adapter.ProductDetailAdapter;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.AnnexBean;
import com.worktowork.glgw.bean.DownloadAttachmentsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//客户需求
public class ClientNeedsActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.iv_call)
    ImageView mIvCall;
    @BindView(R.id.tv_company)
    TextView mTvCompany;
    @BindView(R.id.tv_product_name)
    TextView mTvProductName;
    @BindView(R.id.tv_demand)
    TextView mTvDemand;
    @BindView(R.id.tv_annex)
    TextView mTvAnnex;
    @BindView(R.id.tv_download)
    TextView mTvDownload;
    @BindView(R.id.rv_annex)
    RecyclerView mRvAnnex;
    @BindView(R.id.tv_processing_methods)
    TextView mTvProcessingMethods;
    @BindView(R.id.tv_scope_of_application)
    TextView mTvScopeOfApplication;
    private List<AnnexBean> list = new ArrayList<>();
    private List<AnnexBean> downlist = new ArrayList<>();
    private AnnexAdapter annexAdapter;
    private AlertDialog dialog;
    private DownloadAttachmentsAdapter downloadAttachmentsAdapter;
    private int chooseNumber = 0;

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
        return R.layout.activity_client_needs;
    }

    @Override
    protected void initData() {
        for (int i = 0; i < 10; i++) {
            list.add(new AnnexBean());
        }
        annexAdapter = new AnnexAdapter(R.layout.item_annex, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRvAnnex.setLayoutManager(linearLayoutManager);
        mRvAnnex.setAdapter(annexAdapter);
    }

    @Override
    protected void initView() {
        mTvTitle.setText("客户需求");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mTvDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_download:
                downlist.clear();
                chooseNumber = 0;
                showDown();
                break;
        }
    }

    private void showDown() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_download_attachments, null);
        ImageView rb_all = view.findViewById(R.id.rb_all);
        TextView tv_number = view.findViewById(R.id.tv_number);
        ImageView iv_close = view.findViewById(R.id.iv_close);
        RecyclerView rv_download_attachments = view.findViewById(R.id.rv_download_attachments);
        TextView tv_download = view.findViewById(R.id.tv_download);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        for (int i = 0; i < 10; i++) {
            downlist.add(new AnnexBean());
        }

        downloadAttachmentsAdapter = new DownloadAttachmentsAdapter(R.layout.item_download_attachments, downlist);
        rv_download_attachments.setLayoutManager(new LinearLayoutManager(mActivity));
        rv_download_attachments.setAdapter(downloadAttachmentsAdapter);
        downloadAttachmentsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.rb_choose:
                        chooseNumber = 0;
                        if (downlist.get(position).isSelect()) {
                            downlist.get(position).setSelect(false);
                        } else {
                            downlist.get(position).setSelect(true);
                        }

                        for (int i = 0; i < downlist.size(); i++) {
                            if (downlist.get(i).isSelect()) {
                                chooseNumber = chooseNumber + 1;
                            }
                        }
                        tv_number.setText("全选(" + chooseNumber + ")");
                        if (chooseNumber == downlist.size()) {
                            rb_all.setSelected(true);
                        } else {
                            rb_all.setSelected(false);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        rb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb_all.isSelected()) {
                    for (int i = 0; i < downlist.size(); i++) {
                        downlist.get(i).setSelect(false);
                }
                    chooseNumber = 0;
                    rb_all.setSelected(false);

                } else {
                    for (int i = 0; i < downlist.size(); i++) {
                        downlist.get(i).setSelect(true);
                    }
                    chooseNumber = downlist.size();
                    rb_all.setSelected(true);

                }
                tv_number.setText("全选(" + chooseNumber + ")");
                downloadAttachmentsAdapter.notifyDataSetChanged();
            }
        });

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
