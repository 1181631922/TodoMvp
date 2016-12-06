package com.fanyafeng.todomvp.putao;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.fanyafeng.todomvp.network.NetUtil;
import com.fanyafeng.todomvp.network.StringUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/12/5 18:10
 * Email: fanyafeng@live.cn
 */
public class PutaoPresenter implements PutaoContract.Presenter {
    private Context context;
    private PutaoContract.View putaoView;

    private Intent intent;

    private List<PutaoBean> putaoBeanList = new ArrayList<>();

    private int page = 1;

    public PutaoPresenter(Context context, PutaoContract.View putaoView) {
        this.context = context;
        this.putaoView = putaoView;
    }

    @Override
    public void start() {
        intent = putaoView.initIntent();
        Log.d("name", intent.getStringExtra("name"));
        putaoView.start(putaoBeanList);

    }

    @Override
    public void refreshView(final String url) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshPutaoView(url);
            }
        }, 1000);
    }

    private void refreshPutaoView(final String url) {
        page = 1;
        new AsyncTask<String, String, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                try {
                    if (!StringUtil.isNullOrEmpty(response)) {
                        putaoBeanList.clear();
                        JSONObject jsonObject = new JSONObject(response);
                        String state = jsonObject.optString("state");
                        if (!StringUtil.isNullOrEmpty(state) && state.equals(NetUtil.STATE_OK)) {

                            JSONObject jsonData = jsonObject.optJSONObject("data");
                            if (jsonData != null) {
                                JSONArray products = jsonData.optJSONArray("products");
                                for (int i = 0; i < products.length(); i++) {
                                    PutaoBean putaoBean = new PutaoBean(products.optJSONObject(i));
                                    putaoBeanList.add(putaoBean);
                                }
                                putaoView.stopRefresh();
                                putaoView.refreshSuccess();

                                return;
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                putaoView.stopRefresh();
                putaoView.refreshFailed();
            }


            @Override
            protected String doInBackground(String... params) {
                return NetUtil.httpGetUtil(context, url);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void loadMore(final String url) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadMorePutaoView(url);
            }
        }, 1000);
    }

    private void loadMorePutaoView(final String url) {
        new AsyncTask<String, String, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                try {
                    if (!StringUtil.isNullOrEmpty(response)) {
                        JSONObject jsonObject = new JSONObject(response);

                        if (jsonObject.getString("state").equals(NetUtil.STATE_OK)) {
                            JSONObject data = jsonObject.optJSONObject("data");
                            JSONArray list = data.optJSONArray("list");
                            for (int i = 0; i < list.length(); i++) {
                                PutaoBean putaoBean = new PutaoBean(list.optJSONObject(i));
                                putaoBeanList.add(putaoBean);
                            }
                            putaoView.stopLoadMore();
                            putaoView.loadMoreSuccess();

                            return;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                putaoView.stopLoadMore();
                putaoView.loadMoreFailed();
            }

            @Override
            protected String doInBackground(String... params) {
                return NetUtil.httpGetUtil(context, url + page);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        page++;
    }
}
