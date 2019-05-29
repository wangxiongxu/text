package com.example.xiangmu.frag;

import com.example.xiangmu.Bean.OneBean;
import com.example.xiangmu.Util.DataService;
import com.example.xiangmu.base.BaseModel;
import com.example.xiangmu.base.BasecallBack;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class Model extends BaseModel {
    public void getModel(BasecallBack<OneBean> basecallBack) {
        getRXok(basecallBack, DataService.getService("http://news-at.zhihu.com/").ribaolist(), new Function<OneBean, ObservableSource<OneBean>>() {
            @Override
            public ObservableSource<OneBean> apply(OneBean oneBean) throws Exception {
                if (oneBean != null) {
                    return Observable.just(oneBean);
                }
                return Observable.error(new NullPointerException("返回数据为空或者异常 : " + (oneBean == null ? "" : oneBean)));

            }
        });
    }
}
