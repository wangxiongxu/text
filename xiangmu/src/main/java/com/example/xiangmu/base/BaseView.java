package com.example.xiangmu.base;

import android.content.Context;

public interface BaseView <P extends BasePresenter>  {
        void setPresenter(P presenter);
        Context getContextObject();
        }
