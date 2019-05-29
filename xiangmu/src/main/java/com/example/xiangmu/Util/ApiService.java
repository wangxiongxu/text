package com.example.xiangmu.Util;


import com.example.xiangmu.Bean.OneBean;
import com.example.xiangmu.Bean.ThreeBean;
import com.example.xiangmu.Bean.TwoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
//http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
public interface ApiService {
    @GET("api/4/news/latest")
    Observable<OneBean> ribaolist();
    @GET("api/data/%E7%A6%8F%E5%88%A9/10/1")
    Observable<TwoBean> twolist();
    //http://gank.io/api/data/Android/10/1
    @GET("api/data/Android/10/1")
    Observable<ThreeBean> threelist();
}
