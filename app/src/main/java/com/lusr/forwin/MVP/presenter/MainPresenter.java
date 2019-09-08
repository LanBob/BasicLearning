package com.lusr.forwin.MVP.presenter;

import com.lusr.forwin.MVP.view.IMainView;

public class MainPresenter implements IPresenter<IMainView> {

    IMainView mainView;

    @Override
    public void attachView(IMainView view) {
        this.mainView = view;
    }

    @Override
    public void detachView() {
        this.mainView = null;
    }
}
