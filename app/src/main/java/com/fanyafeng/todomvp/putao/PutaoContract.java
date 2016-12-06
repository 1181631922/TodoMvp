package com.fanyafeng.todomvp.putao;

import android.content.Intent;

import com.fanyafeng.todomvp.BasePresenter;
import com.fanyafeng.todomvp.BaseView;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/12/5 17:59
 * Email: fanyafeng@live.cn
 */
public interface PutaoContract {
    interface View {
        Intent initIntent();

        void start(List<PutaoBean> putaoBeanList);

        void refreshSuccess();

        void refreshFailed();

        void loadMoreSuccess();

        void loadMoreFailed();

        void stopRefresh();

        void stopLoadMore();
    }

    interface Presenter extends BasePresenter {
        void refreshView(String url);

        void loadMore(String url);
    }
}
