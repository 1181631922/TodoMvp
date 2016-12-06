package com.fanyafeng.todomvp.home.main;

import android.content.Context;

/**
 * Author： fanyafeng
 * Data： 16/12/6 12:13
 * Email: fanyafeng@live.cn
 */
public class HomePresenter implements HomeContract.Presenter {

    private Context context;
    private HomeContract.View homeView;


    public HomePresenter(Context context, HomeContract.View homeView) {
        this.context = context;
        this.homeView = homeView;
        homeView.setPresenter(this);
    }


    @Override
    public void start() {
        homeView.changeHomeDesc("P中更改首页描述");
    }
}
