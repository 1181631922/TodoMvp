package com.fanyafeng.todomvp.main;

import android.content.Context;
import android.content.Intent;

import com.fanyafeng.todomvp.home.HomeActivity;
import com.fanyafeng.todomvp.putao.PutaoActivity;

/**
 * Author： fanyafeng
 * Data： 16/12/5 17:19
 * Email: fanyafeng@live.cn
 */
public class MainPresenter implements MainContract.Presenter {
    private Context context;
    private MainContract.View mView;

    public MainPresenter(Context context, MainContract.View mView) {
        this.context = context;
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.setPutaoText();
    }

    @Override
    public void startPutaoActivity() {
        Intent intent = new Intent(context, PutaoActivity.class);
        mView.startPutaoActivity(intent);
    }

    @Override
    public void startHomeActivity() {
        Intent intent = new Intent(context, HomeActivity.class);
        mView.startPutaoActivity(intent);
    }
}
