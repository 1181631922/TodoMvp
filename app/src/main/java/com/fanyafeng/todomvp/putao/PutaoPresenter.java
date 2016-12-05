package com.fanyafeng.todomvp.putao;

/**
 * Author： fanyafeng
 * Data： 16/12/5 18:10
 * Email: fanyafeng@live.cn
 */
public class PutaoPresenter implements PutaoContract.Presenter {
    private PutaoContract.View putaoView;

    public PutaoPresenter(PutaoContract.View putaoView) {
        this.putaoView = putaoView;
    }

    @Override
    public void start() {

    }
}
