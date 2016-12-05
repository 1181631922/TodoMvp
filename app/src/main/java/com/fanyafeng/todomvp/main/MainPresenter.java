package com.fanyafeng.todomvp.main;

import android.content.Context;
import android.content.Intent;

import com.fanyafeng.todomvp.putao.PutaoActivity;

/**
 * Author： fanyafeng
 * Data： 16/12/5 17:19
 * Email: fanyafeng@live.cn
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.setPutaoText();
    }


    @Override
    public void startPutaoActivity(Context context) {
        Intent intent = new Intent(context, PutaoActivity.class);
        mView.startPutaoActivity(intent);
    }
}
