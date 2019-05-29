package com.example.xiangmu.frag;

import com.example.xiangmu.Bean.OneBean;
import com.example.xiangmu.base.BasePresenter;
import com.example.xiangmu.base.BasecallBack;

public class Presenter implements BasePresenter<View> {
    @Override
    public void attachView(final View view) {
        Model model = new Model();
        model.getModel(new BasecallBack<OneBean>() {
            @Override
            public void onSuccess(OneBean data) {
                view.getIfVIew(data);
            }
        });
    }

    @Override
    public void detachView(View view) {

    }
}
