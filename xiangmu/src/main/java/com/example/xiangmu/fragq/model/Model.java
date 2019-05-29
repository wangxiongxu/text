package com.example.xiangmu.fragq.model;

import com.example.xiangmu.Bean.TwoBean;
import com.example.xiangmu.Util.DataTwoService;
import com.example.xiangmu.base.BaseModel;
import com.example.xiangmu.base.BasecallBack;
import com.example.xiangmu.fragq.contract.Contract;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Model extends BaseModel implements Contract.Model {
    @Override
    public void getModel(BasecallBack<TwoBean> back) {
        getRXok(back, DataTwoService.getService("http://gank.io/").twolist(), new Function<TwoBean, ObservableSource<TwoBean>>() {
            @Override
            public ObservableSource<TwoBean> apply(TwoBean twoBean) throws Exception {
                if (twoBean != null) {
                    return Observable.just(twoBean);
                }
                return Observable.error(new NullPointerException("返回数据为空或者异常 : " + (twoBean == null ? "" : twoBean)));

            }
        });
    }
}
