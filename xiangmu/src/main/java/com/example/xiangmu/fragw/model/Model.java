package com.example.xiangmu.fragw.model;
import com.example.xiangmu.Bean.ThreeBean;
import com.example.xiangmu.Util.DataThreeService;
import com.example.xiangmu.base.BaseModel;
import com.example.xiangmu.base.BasecallBack;
import com.example.xiangmu.fragw.contract.Contract;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Model extends BaseModel implements Contract.Model {

    @Override
    public void getModel(BasecallBack<ThreeBean> back) {
        getRXok(back, DataThreeService.getService("http://gank.io/").threelist(), new Function<ThreeBean, ObservableSource<ThreeBean>>() {
            @Override
            public ObservableSource<ThreeBean> apply(ThreeBean threeBean) throws Exception {
                if (threeBean != null) {
                    return Observable.just(threeBean);
                }
                return Observable.error(new NullPointerException("返回数据为空或者异常 : " + (threeBean == null ? "" : threeBean)));

            }
        });
    }
}
