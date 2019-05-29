package com.example.xiangmu.fragw;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.Bean.ThreeBean;
import com.example.xiangmu.R;
import com.example.xiangmu.base.BaseFrag;
import com.example.xiangmu.fragw.contract.Contract;
import com.example.xiangmu.fragw.presenter.Presenter;

import java.util.List;

public class FragThree extends BaseFrag implements Contract.View {

    private View view;
    private RecyclerView mRec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_ganhuo, null);

        initView(inflate);
        return inflate;
    }

    @Override
    public void getIfview(ThreeBean threeBean) {
        List<ThreeBean.ResultsBean> results = threeBean.getResults();
        ThreeAdAp threeAdAp = new ThreeAdAp(results);
        mRec.setAdapter(threeAdAp);
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
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        setPresenter(new Presenter());
    }
}
