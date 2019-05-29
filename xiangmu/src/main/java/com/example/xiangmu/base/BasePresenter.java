package com.example.xiangmu.base;

public interface BasePresenter  <P extends BaseView> {
    void attachView(P view);
    void detachView(P view);
}
