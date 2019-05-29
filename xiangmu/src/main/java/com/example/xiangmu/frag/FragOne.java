package com.example.xiangmu.frag;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmu.Bean.OneBean;
import com.example.xiangmu.R;
import com.example.xiangmu.base.BaseFrag;

public class FragOne extends BaseFrag implements com.example.xiangmu.frag.View {

    private View view;
    private RecyclerView mRec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.layout_one, null);
        initView(inflate);
        return inflate;
    }

    @Override
    public void getIfVIew(OneBean data) {
        OneAdAp oneAdAp = new OneAdAp(data.getTop_stories(), data.getStories(), data.getDate(), getContext());
        mRec.setAdapter(oneAdAp);
    }

    @Override
    public void setPresenter(Presenter presenter) {
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
