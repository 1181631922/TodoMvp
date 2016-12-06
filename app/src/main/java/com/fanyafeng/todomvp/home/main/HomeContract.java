package com.fanyafeng.todomvp.home.main;

import com.fanyafeng.todomvp.BasePresenter;
import com.fanyafeng.todomvp.BaseView;

/**
 * Author： fanyafeng
 * Data： 16/12/6 12:12
 * Email: fanyafeng@live.cn
 */
public interface HomeContract {
    interface View extends BaseView<Presenter> {
        void changeHomeDesc(String desc);
    }

    interface Presenter extends BasePresenter {

    }
}
