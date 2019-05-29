package com.example.xiangmu.fragq.contract;

import com.example.xiangmu.Bean.TwoBean;
import com.example.xiangmu.base.BasePresenter;
import com.example.xiangmu.base.BaseView;
import com.example.xiangmu.base.BasecallBack;

public interface Contract {
    interface Model {
        void getModel(BasecallBack<TwoBean> back);
    }

    interface View extends BaseView<Presenter> {
        void getIfview(TwoBean twoBean);
    }

    interface Presenter extends BasePresenter<View> {
    }
}
