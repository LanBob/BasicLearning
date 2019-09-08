package com.lusr.forwin.MVP.presenter;

import com.lusr.forwin.MVP.view.IBaseView;

/**
 * Presenter关联上View,并且使用Model提供的一切操作
 * @param <V>
 */
public interface IPresenter<V extends IBaseView> {

    void attachView(V view);

    void detachView();

}