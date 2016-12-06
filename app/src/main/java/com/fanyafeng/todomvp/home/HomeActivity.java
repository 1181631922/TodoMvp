package com.fanyafeng.todomvp.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanyafeng.todomvp.R;
import com.fanyafeng.todomvp.BaseActivity;
import com.fanyafeng.todomvp.home.main.HomeFragment;
import com.fanyafeng.todomvp.home.main.HomePresenter;
import com.fanyafeng.todomvp.home.personal.PersonalFragment;
import com.fanyafeng.todomvp.home.recommend.RecommendFragment;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class HomeActivity extends BaseActivity {
    private static String[] FRAGMENT_TAGS = new String[]{"1", "2", "3"};
    private View[] tabs = new View[3];

    private HomeFragment homeFragment;
    private RecommendFragment recommendFragment;
    private PersonalFragment personalFragment;

    private FragmentManager fragmentManager;

    private ImageView tab_img1;
    private TextView tab_text1;

    private ImageView tab_img2;
    private TextView tab_text2;

    private ImageView tab_img3;
    private TextView tab_text3;

    private int current = 0;
    private int currentTab = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            current = savedInstanceState.getInt("tab");
        } else {
            current = 0;
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        title = getString(R.string.title_activity_home);

        fragmentManager = getSupportFragmentManager();

        initView();
        initData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (current != -1) {
            outState.putInt("tab", current);
        }
        super.onSaveInstanceState(outState);
    }

    //初始化UI控件
    private void initView() {
        tabs[0] = findViewById(R.id.tab_one);
        tab_img1 = (ImageView) findViewById(R.id.tab_img1);
        tab_text1 = (TextView) findViewById(R.id.tab_text1);

        tabs[1] = findViewById(R.id.tab_two);
        tab_img2 = (ImageView) findViewById(R.id.tab_img2);
        tab_text2 = (TextView) findViewById(R.id.tab_text2);

        tabs[2] = findViewById(R.id.tab_three);
        tab_img3 = (ImageView) findViewById(R.id.tab_img3);
        tab_text3 = (TextView) findViewById(R.id.tab_text3);

        for (int i = 0; i < tabs.length; i++) {
            final int j = i;
            tabs[i].setTag(i);
            tabs[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectTab(j);
                }
            });
        }
        selectTab(current);
    }

    private void selectTab(int tab) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (tab) {
            case 0:
                if (currentTab != 0) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text1.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_00);
                    tab_img2.setImageResource(R.drawable.simle_logo_02);
                    tab_img3.setImageResource(R.drawable.simle_logo_03);
                    if (homeFragment == null) {
                        homeFragment = new HomeFragment();
                        new HomePresenter(this, homeFragment);
                        fragmentTransaction.add(R.id.container, homeFragment, FRAGMENT_TAGS[0]);
                    } else {
                        fragmentTransaction.show(homeFragment);
                    }
                    current = 0;
                    currentTab = 0;
                }
                break;
            case 1:
                if (currentTab != 1) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text2.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_01);
                    tab_img2.setImageResource(R.drawable.simle_logo_00);
                    tab_img3.setImageResource(R.drawable.simle_logo_03);
                    if (recommendFragment == null) {
                        recommendFragment = new RecommendFragment();
                        fragmentTransaction.add(R.id.container, recommendFragment, FRAGMENT_TAGS[1]);
                    } else {
                        fragmentTransaction.show(recommendFragment);
                    }
                    current = 1;
                    currentTab = 1;
                }
                break;
            case 2:
                if (currentTab != 2) {
                    clearTabSelection();
                    hideFragement(fragmentTransaction);
                    tab_text3.setTextColor(Color.parseColor("#78e0ff"));
                    tab_img1.setImageResource(R.drawable.simle_logo_01);
                    tab_img2.setImageResource(R.drawable.simle_logo_02);
                    tab_img3.setImageResource(R.drawable.simle_logo_00);
                    if (personalFragment == null) {
                        personalFragment = new PersonalFragment();
                        fragmentTransaction.add(R.id.container, personalFragment, FRAGMENT_TAGS[2]);
                    } else {
                        fragmentTransaction.show(personalFragment);
                    }
                    current = 2;
                    currentTab = 2;
                }
                break;
        }
        fragmentTransaction.commit();
    }

    //初始化数据
    private void initData() {

    }

    /**
     * 设置为默认颜色
     */
    private void clearTabSelection() {
        tab_text1.setTextColor(Color.RED);
        tab_text2.setTextColor(Color.RED);
        tab_text3.setTextColor(Color.RED);
    }

    private void hideFragement(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null) {
            fragmentTransaction.hide(homeFragment);
        }
        if (recommendFragment != null) {
            fragmentTransaction.hide(recommendFragment);
        }
        if (personalFragment != null) {
            fragmentTransaction.hide(personalFragment);
        }
    }

}
