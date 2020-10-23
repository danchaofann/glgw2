package com.worktowork.glgw.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.lljjcoder.citypickerview.widget.CityPicker;
import com.worktowork.glgw.R;
import com.worktowork.glgw.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddCustomerInformationActivity extends BaseActivity implements View.OnClickListener {
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
    @BindView(R.id.et_customer_name)
    EditText mEtCustomerName;
    @BindView(R.id.et_contact_number)
    EditText mEtContactNumber;
    @BindView(R.id.et_company_name)
    EditText mEtCompanyName;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.tv_area)
    TextView mTvArea;
    @BindView(R.id.ll_area)
    LinearLayout mLlArea;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    private CityPicker mCP;
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
        return R.layout.activity_add_customer_information;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTvTitle.setText("客户信息");
    }

    @Override
    protected void setListener() {
        mIvBack.setOnClickListener(this);
        mLlArea.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_area:
                mYunCityPicher();
                mCP.show();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void mYunCityPicher() {
        mCP = new CityPicker.Builder(AddCustomerInformationActivity.this)
                .textSize(20)
                //地址选择
                .title("地址选择")
                .backgroundPop(0xa0000000)
                //文字的颜色
                .titleBackgroundColor("#FAFAFA")
                .titleTextColor("#333333")
                .backgroundPop(0xa0000000)
                .confirTextColor("#333333")
                .cancelTextColor("#333333")
                .province("北京省")
                .city("北京市")
                .district("昌平区")
                //滑轮文字的颜色
                .textColor(Color.parseColor("#000000"))
                //省滑轮是否循环显示
                .provinceCyclic(false)
                //市滑轮是否循环显示
                .cityCyclic(false)
                //地区（县）滑轮是否循环显示
//                .districtCyclic(false)
                //滑轮显示的item个数
                .visibleItemsCount(7)
                //滑轮item间距
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();

        //监听
        mCP.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                //省
                String province = citySelected[0];
                //市
                String city = citySelected[1];
                //区。县。（两级联动，必须返回空）
                String district = citySelected[2];
                //邮证编码
                String code = citySelected[3];
                mTvArea.setText(province + city + district);
//                mTvAddress.setText(province + city + district);
//                mPresenter.updateAddress(token, store_type, province + city + district);
            }

            @Override
            public void onCancel() {


            }
        });
    }
}
