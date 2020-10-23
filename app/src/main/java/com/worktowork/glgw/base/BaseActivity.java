package com.worktowork.glgw.base;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.MyApplication;
import com.worktowork.glgw.R;
import com.worktowork.glgw.util.Constants;
import com.worktowork.glgw.util.HandleBackUtil;
import com.worktowork.glgw.util.SpUtils;
import com.worktowork.glgw.util.TUtil;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity基类
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements BaseView {

    private InputMethodManager imm;
    protected ImmersionBar mImmersionBar;
    private Unbinder unbinder;
    public Context mActivity;
    public P mPresenter;
    public M mModel;
    private RxManager mRxManage;
    public SpUtils spUtils=new SpUtils();
    public String accountId;
    public boolean isLogin;
    public String password;
    public String token="";
    public Gson gson = new Gson();
    private ZLoadingDialog dialog;
    private AlertDialog dialog1;
//    public Login storeInfoBean=new Login();
    public String phone;
    public String store_type="0";
    public String b_nums;
    public String m_nums;
    public String p_nums;
    public String txinfo_nick;
    public String txinfo_identifier;
    public String txinfo_faceUrl;
    public String txinfo_userSign;
    //    Intent intent;
//    MyServiceConnection myServiceConnection;

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }

    public static void logout(Context context, boolean autoLogin) {
//        DemoLog.i(TAG, "logout");
        SharedPreferences shareInfo = context.getSharedPreferences(Constants.USERINFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shareInfo.edit();
        editor.putBoolean(Constants.AUTO_LOGIN, autoLogin);
        editor.commit();

//        Intent intent = new Intent(context, MainActivity.class);
//        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra(Constants.LOGOUT, true);
//        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); //竖屏
        setContentView(setLayoutId());
//        spUtils = SpUtils.getInstance("token");
        getLoginMsg();

        this.mActivity = this;
        try {
            EventBus.getDefault().register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mPresenter = obtainPresenter();
        mModel = obtainModel();
        if (mPresenter != null) {
            mPresenter.mContext = mActivity;
            if (this instanceof BaseView) {
                mPresenter.setVM(this, mModel);
            }
            mPresenter.onCreate(savedInstanceState);
        }

        mRxManage = new RxManager();
        //绑定控件
        unbinder = ButterKnife.bind(this);
        //初始化沉浸式
        if (isImmersionBarEnabled())
            initImmersionBar();
        //初始化数据
        initData();
        //view与数据绑定
        initView();
        //设置监听
        setListener();


//        String[] PERMISSIONS = {
//                "android.permission.PACKAGE_USAGE_STATS",};
////检测是否有写的权限
//        int permission = ContextCompat.checkSelfPermission(this,
//                "android.permission.PACKAGE_USAGE_STATS");
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//            // 没有写的权限，去申请写的权限，会弹出对话框
//            ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
//        }
//        mUseTimeDataManager = UseTimeDataManager.getInstance(mActivity);
//        mUseTimeDataManager.refreshData(0);
//
//        getJsonObjectStr();
    }

    protected P obtainPresenter() {
        return TUtil.getT(this, 0);
    }

    protected M obtainModel() {
        return TUtil.getT(this, 1);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        this.imm = null;
        if (mImmersionBar != null) {
            mImmersionBar.destroy(); //在BaseActivity里销毁
        }
        EventBus.getDefault().unregister(this);
    }

    protected abstract int setLayoutId();

    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
//        mImmersionBar.statusBarDarkFont(true, 0.2f); //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
        mImmersionBar.statusBarColor(R.color.white);
        mImmersionBar.fitsSystemWindows(true);
        mImmersionBar.keyboardEnable(true);
        mImmersionBar.init();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void setListener();

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    public void finish() {
        super.finish();
        hideSoftKeyBoard();
    }

//    public View getEmptyView() {
//        return  LayoutInflater.from(mActivity).inflate(R.layout.layout_no_data4,null);
//    }


    public void hideSoftKeyBoard() {
        View localView = getCurrentFocus();
        if (this.imm == null) {
            this.imm = ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE));
        }
        if ((localView != null) && (this.imm != null)) {
            this.imm.hideSoftInputFromWindow(localView.getWindowToken(), 2);
        }
    }

    public void getLoginMsg() {
        token=SpUtils.getString(this,"token");
        phone = SpUtils.getString(this,"phone");
        password=SpUtils.getString(this,"password");
        isLogin=SpUtils.getBoolean(this,"isLogin",false);
//        storeInfoBean=SpUtils.getObject(this,"info");
        store_type = SpUtils.getString(this,"store_type");
        b_nums = SpUtils.getString(this,"b_nums");//商家
        m_nums = SpUtils.getString(this,"m_nums");//供应商
        p_nums = SpUtils.getString(this,"p_nums");//合作
        txinfo_nick = SpUtils.getString(mActivity, "txinfo_nick");
        txinfo_identifier = SpUtils.getString(mActivity, "txinfo_identifier");
        txinfo_faceUrl = SpUtils.getString(mActivity, "txinfo_faceUrl");
        txinfo_userSign = SpUtils.getString(mActivity, "txinfo_userSign");
//        token = spUtils.getString("AuthenticationRefreshToken");
//        accountId = spUtils.getString("accountId");
//        password = spUtils.getString("password");
//        isLogin = spUtils.getBoolean("isLogin", false);
////        storeInfoBean = (Login.StoreInfoBean) spUtils.getStringSet("info");
//        storeInfoBean= (Login.StoreInfoBean) spUtils.getAll();
    }


    @Override
    public void onBackPressed() {
        if (!HandleBackUtil.handleBackPress(this)) {
            super.onBackPressed();
        }
    }

    /*电话*/
    public static final int REQUEST_CALL_PERMISSION = 10111; //拨号请求码

    /**
     * 判断是否有某项权限
     *
     * @param string_permission 权限
     * @param request_code      请求码
     * @return
     */
    public boolean checkReadPermission(String string_permission, int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, string_permission) == PackageManager.PERMISSION_GRANTED) {//已有权限
            flag = true;
        } else {//申请权限
            ActivityCompat.requestPermissions(this, new String[]{string_permission}, request_code);
        }
        return flag;
    }

//    /**
//     * 拨打电话（直接拨打）
//     *
//     * @param telPhone 电话
//     */
//    public void call(String telPhone) {
//        if (checkReadPermission(Manifest.permission.CALL_PHONE, REQUEST_CALL_PERMISSION)) {
//            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(telPhone));
//            startActivity(intent);
//        }
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        // mActivity.bindService(intent, myServiceConnection, Context.BIND_AUTO_CREATE);
//    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // mActivity.unbindService(myServiceConnection);
    }

    @Override
    public void contentLoading() {

    }

    @Override
    public void contentLoadingComplete() {

    }

    @Override
    public void contentLoadingError() {

    }

    @Override
    public void contentLoadingEmpty() {

    }

    @Override
    public void showProgress() {
        dialog = new ZLoadingDialog(mActivity);
        dialog.setLoadingBuilder(Z_TYPE.SINGLE_CIRCLE)//设置类型
                .setLoadingColor(Color.BLACK)//颜色
//                .setHintText("登录中请稍后...")
                .setHintTextSize(14) // 设置字体大小 dp
                .setHintTextColor(Color.BLACK)  // 设置字体颜色
                .setDurationTime(0.5) // 设置动画时间百分比 - 0.5倍
                .setCanceledOnTouchOutside(false)//点击外部无法取消
                .show();
    }

    @Override
    public void hideProgress() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Handler myhander = new Handler();
//        myhander.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                copydata(mActivity);
//            }
//        },500);
    }
//    private void copydata(final Context context) {
//        //获取系统剪贴板服务
//        ClipboardManager clipboardManager = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
//        if (null != clipboardManager) {
//            // 获取剪贴板的剪贴数据集
//            ClipData clipData = clipboardManager.getPrimaryClip();
//            if (null != clipData && clipData.getItemCount() > 0) {
//                // 从数据集中获取（粘贴）第一条文本数据
//                ClipData.Item item = clipData.getItemAt(0);
//                if (null != item) {
//                    String content = item.getText().toString();
////                    ToastUtils.showShort(content);
//                    try {
//                        if ("复制这条信息，打".equals(content.substring(0, 8))) {
//
//                            String assemble_id = content.substring(content.indexOf("$") + 1, content.lastIndexOf("$"));
////                        Log.d("Main",assemble_id);
//                            Intent intent = new Intent(mActivity, UserGroupActivity.class);
//                            intent.putExtra("Assemble_id", assemble_id + "");
//                            startActivity(intent);
//                            try {
//                                clipboardManager.setPrimaryClip(clipboardManager.getPrimaryClip());
//                                clipboardManager.setPrimaryClip(ClipData.newPlainText("",""));
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            return;
//                        }
//                    } catch (Exception e) {
//                        return;
//                    }
//                }
//            }
//        }
//    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void BaseActivityEvent(String name) {
        // do nothing, just avoid Exception like: org.greenrobot.eventbus.EventBusException:
        // Subscriber class *** and its super classes have no public methods with the @Subscribe annotation
    }

}
