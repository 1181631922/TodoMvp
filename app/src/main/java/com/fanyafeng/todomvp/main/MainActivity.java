package com.fanyafeng.todomvp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.fanyafeng.todomvp.R;
import com.fanyafeng.todomvp.BaseActivity;
import com.fanyafeng.todomvp.putao.PutaoActivity;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class MainActivity extends BaseActivity implements MainContract.View {
    private Button btnPuTao;
    private Button btnHome;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_main);
        isSetNavigationIcon = false;
        mainPresenter = new MainPresenter(this, this);

        initView();
        mainPresenter.start();
        initData();
    }


    //初始化UI空间
    private void initView() {
        btnPuTao = (Button) findViewById(R.id.btnPuTao);
        btnHome = (Button) findViewById(R.id.btnHome);
    }

    //初始化数据
    private void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btnPuTao:
                mainPresenter.startPutaoActivity();
                break;
            case R.id.btnHome:
                mainPresenter.startHomeActivity();
                break;
        }
    }

    @Override
    public void setPutaoText() {
        btnPuTao.setText("我的首页");
    }

    @Override
    public void startPutaoActivity(Intent intent) {
        intent.putExtra("name", "name");
        startActivity(intent);
    }

    @Override
    public void startHomeActivity(Intent intent) {
        startActivity(intent);
    }
}
