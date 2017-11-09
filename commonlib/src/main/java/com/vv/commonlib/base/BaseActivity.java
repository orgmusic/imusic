package com.vv.commonlib.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;

import com.vv.commonlib.R;

/**
 * Created by Administrator on 2017/10/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private ViewStub bodyStub;
    private View bodyView;

    public abstract void initView();

    public abstract void initListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去除title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
//        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
//                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.setContentView(R.layout.activity_base);
        bodyStub = (ViewStub) findViewById(R.id.body_stub);
    }

    @Override
    public void setContentView(int layoutResID) {
        bodyStub.setLayoutResource(layoutResID);
        bodyView = bodyStub.inflate();
        init();
    }

    private void init() {
        initView();
        initListener();
    }


    public void pushActivity(Class clz) {
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), clz);
        startActivity(intent);
    }
}
