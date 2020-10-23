package com.worktowork.glgw.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.worktowork.glgw.R;
import com.worktowork.glgw.adapter.HistoryRecordAdapter;
import com.worktowork.glgw.adapter.SearchHistoryAdpater;
import com.worktowork.glgw.base.BaseActivity;
import com.worktowork.glgw.bean.SearchHot;
import com.worktowork.glgw.weight.AutoLineFeedLayoutManager;
import com.worktowork.glgw.weight.RecordSQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.tv_cancel)
    TextView mTvCancel;
    @BindView(R.id.rv_search_hot)
    RecyclerView mRvSearchHot;
    @BindView(R.id.iv_delete)
    ImageView mIvDelete;
    @BindView(R.id.rv_search_history)
    RecyclerView mRvSearchHistory;
    @BindView(R.id.ll_search)
    LinearLayout mLlSearch;
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
    private List<SearchHot> historyList = new ArrayList<>();

    private SearchHistoryAdpater historyAdpater;
    private RecordSQLiteOpenHelper helper = new RecordSQLiteOpenHelper(this);
    ;
    private SQLiteDatabase db;
    private List<String> recordList = new ArrayList<>();
    private HistoryRecordAdapter historyRecordAdapter;

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
        return R.layout.activity_search;
    }


    @Override
    protected void initData() {
        mTvTitle.setText("搜索");

//        mRvSearchHistory.setLayoutManager(new AutoLineFeedLayoutManager());
//        mRvSearchHistory.setAdapter(historyAdpater);
        for (int i = 0; i < 10; i++) {
            historyList.add(new SearchHot());
        }
        historyAdpater = new SearchHistoryAdpater(R.layout.item_search_history, historyList);
        mRvSearchHot.setLayoutManager(new AutoLineFeedLayoutManager());
        mRvSearchHot.setAdapter(historyAdpater);
        historyAdpater.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                boolean hasData = hasData(historyList.get(position).getSearch_key());
//                if (!hasData) {
//                    insertData(historyList.get(position).getSearch_key());
//                    queryData("");
//                }
                Intent intent = new Intent(mActivity, SearchDetailActivity.class);
                intent.putExtra("result", historyList.get(position).getSearch_key());
                startActivity(intent);
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView() {

        // 第一次进入查询所有的历史记录
        queryData("");


        mEtSearch.setOnKeyListener(new View.OnKeyListener() {

            @Override

            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER) {
// 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchActivity.this.getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
                    String name = mEtSearch.getText().toString();
                    if (name.isEmpty()) {
                        ToastUtils.showShort("请输入搜索内容");
                    } else {
                        boolean hasData = hasData(mEtSearch.getText().toString().trim());
                        if (!hasData) {
                            insertData(mEtSearch.getText().toString().trim());
                            queryData("");
                        }
//                        Intent intent = new Intent(mActivity, SearchDetailActivity.class);
//                        intent.putExtra("result", name);
//                        startActivity(intent);
                    }
                }
                return false;
            }
        });

    }

    /**
     * 插入数据
     */
    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    /**
     * 模糊查询数据
     */
    private void queryData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select  id as _id,name from records where name like '%" + tempName + "%' order by id desc limit 0,15 ", null);

//        // 创建adapter适配器对象
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"name"},
//                new int[]{android.R.id.text1}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        recordList.clear();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                recordList.add(name);
            } while (cursor.moveToNext());
        }
//       historyRecordAdapter.setNewData(recordList);
        historyRecordAdapter = new HistoryRecordAdapter(R.layout.item_search_history, recordList);
        mRvSearchHistory.setLayoutManager(new AutoLineFeedLayoutManager());
        mRvSearchHistory.setAdapter(historyRecordAdapter);
        historyRecordAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(mActivity, SearchDetailActivity.class);
//                intent.putExtra("result", recordList.get(position));
//                startActivity(intent);
            }
        });

//        // 设置适配器
//        listView.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    /**
     * 检查数据库中是否已经有该条记录
     */
    private boolean hasData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{tempName});
        //判断是否有下一个
        return cursor.moveToNext();
    }

    /**
     * 清空数据
     */
    private void deleteData() {
        db = helper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
    }


    @Override
    protected void setListener() {
        mTvCancel.setOnClickListener(this);
        mIvDelete.setOnClickListener(this);
        mIvBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
            case R.id.tv_cancel:
                finish();
                break;
            case R.id.iv_delete:
                deleteData();
                queryData("");
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
