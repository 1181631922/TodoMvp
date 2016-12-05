package com.fanyafeng.todomvp.main;

import android.content.Context;
import android.content.Intent;

import com.fanyafeng.todomvp.BasePresenter;
import com.fanyafeng.todomvp.BaseView;

/**
 * Author： fanyafeng
 * Data： 16/12/5 17:12
 * Email: fanyafeng@live.cn
 */
public interface MainContract {
    interface View extends BaseView<Presenter> {

        void startPutaoActivity(Intent intent);

        void setPutaoText();
    }

    interface Presenter extends BasePresenter {
        void startPutaoActivity();
    }
}
