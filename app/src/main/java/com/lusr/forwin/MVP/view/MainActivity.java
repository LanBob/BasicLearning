package com.lusr.forwin.MVP.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.lusr.forwin.MVP.presenter.MainPresenter;

public class MainActivity extends Activity implements IMainView {

    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        mainPresenter = new MainPresenter();
        mainPresenter.attachView(this);
    }


    /**
     * 双向绑定，体现在Activity进行实现的方法，给Presenter调用
     */
    @Override
    public void activityImplAndPresenterUse() {

    }

    @Override
    public Context getContext() {
        return this;
    }
}
