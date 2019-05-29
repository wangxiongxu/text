package com.example.xiangmu.fragq.presenter;

import com.example.xiangmu.Bean.TwoBean;
import com.example.xiangmu.base.BasecallBack;
import com.example.xiangmu.fragq.contract.Contract;
import com.example.xiangmu.fragq.model.Model;

public class Presenter implements Contract.Presenter {
    @Override
    public void attachView(final Contract.View view) {
        Model model = new Model();
        model.getModel(new BasecallBack<TwoBean>() {
            @Override
            public void onSuccess(TwoBean data) {
                view.getIfview(data);
            }
        });
    }

    @Override
    public void detachView(Contract.View view) {

    }
}
