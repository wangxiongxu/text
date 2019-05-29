package com.example.xiangmu.fragq;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.Bean.TwoBean;
import com.example.xiangmu.R;
import com.example.xiangmu.base.BaseFrag;
import com.example.xiangmu.fragq.contract.Contract;
import com.example.xiangmu.fragq.presenter.Presenter;

import java.util.List;

public class FragTwo extends BaseFrag implements Contract.View {

    private View view;
    private RecyclerView mRec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_two, null);
        initView(inflate);
        return inflate;
    }

    @Override
    public void getIfview(TwoBean twoBean) {
        List<TwoBean.ResultsBean> results = twoBean.getResults();
        TwoAdAp twoAdAp = new TwoAdAp(results);
        mRec.setAdapter(twoAdAp);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        presenter.attachView(this);
    }

    @Override
    public Context getContextObject() {
        return getContext();
    }

    private void initView(View inflate) {
        mRec = (RecyclerView) inflate.findViewById(R.id.rec);
        mRec.setLayoutManager(new GridLayoutManager(getContext(),2));
        setPresenter(new Presenter());
    }
}
