package com.example.xiangmu.fragw.presenter;

import com.example.xiangmu.Bean.ThreeBean;
import com.example.xiangmu.base.BasecallBack;
import com.example.xiangmu.fragw.contract.Contract;
import com.example.xiangmu.fragw.model.Model;

public class Presenter implements Contract.Presenter {
    @Override
    public void attachView(final Contract.View view) {
        Model model = new Model();
        model.getModel(new BasecallBack<ThreeBean>() {
            @Override
            public void onSuccess(ThreeBean data) {
                view.getIfview(data);
            }
        });
    }

    @Override
    public void detachView(Contract.View view) {

    }
}
