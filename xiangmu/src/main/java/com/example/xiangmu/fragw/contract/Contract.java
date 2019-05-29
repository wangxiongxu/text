package com.example.xiangmu.fragw.contract;

import com.example.xiangmu.Bean.ThreeBean;
import com.example.xiangmu.base.BasePresenter;
import com.example.xiangmu.base.BaseView;
import com.example.xiangmu.base.BasecallBack;

public interface Contract {
    interface Model {
      void getModel(BasecallBack<ThreeBean> back);
    }

    interface View extends BaseView<Presenter> {
        void getIfview(ThreeBean threeBean);
    }

    interface Presenter extends BasePresenter<View> {
    }
}
