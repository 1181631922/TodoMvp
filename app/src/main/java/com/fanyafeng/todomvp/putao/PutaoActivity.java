package com.fanyafeng.todomvp.putao;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.fanyafeng.todomvp.R;
import com.fanyafeng.todomvp.BaseActivity;
import com.fanyafeng.todomvp.network.Urls;

import java.net.URL;
import java.util.List;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class PutaoActivity extends BaseActivity implements PutaoContract.View {
    private PutaoPresenter putaoPresenter;
    private XRefreshView refreshPutao;
    private RecyclerView rvPutao;
    private PutaoAdapter putaoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_putao);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_putao);

        putaoPresenter = new PutaoPresenter(this, this);
        initView();
        putaoPresenter.start();
        initData();
    }


    //初始化UI空间
    private void initView() {
        refreshPutao = (XRefreshView) findViewById(R.id.refreshPutao);
        refreshPutao.setPullLoadEnable(true);
        refreshPutao.setAutoLoadMore(true);
        rvPutao = (RecyclerView) findViewById(R.id.rvPutao);
        rvPutao.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
    }


    //初始化数据
    private void initData() {
        refreshPutao.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh() {
                super.onRefresh();
                putaoPresenter.refreshView(Urls.PUTAO_MAIN_URL);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                super.onLoadMore(isSilence);
                putaoPresenter.loadMore(Urls.GOOD_LIST_URL);
            }
        });
        putaoPresenter.refreshView(Urls.PUTAO_MAIN_URL);
    }

    @Override
    public void start(List<PutaoBean> putaoBeanList) {
        putaoAdapter = new PutaoAdapter(this, putaoBeanList);
        putaoAdapter.setCustomLoadMoreView(new XRefreshViewFooter(this));
        rvPutao.setAdapter(putaoAdapter);
    }

    @Override
    public Intent initIntent() {
        return getIntent();
    }

    @Override
    public void refreshSuccess() {
        putaoAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshFailed() {
        Toast.makeText(this, "刷新失败", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void loadMoreSuccess() {
        putaoAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadMoreFailed() {
        Toast.makeText(this, "加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void stopRefresh() {
        refreshPutao.stopRefresh();
    }

    @Override
    public void stopLoadMore() {
        refreshPutao.stopLoadMore();
    }


}
