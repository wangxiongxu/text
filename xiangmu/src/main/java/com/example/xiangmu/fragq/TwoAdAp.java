package com.example.xiangmu.fragq;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xiangmu.Bean.TwoBean;
import com.example.xiangmu.R;

import java.util.List;

public class TwoAdAp extends RecyclerView.Adapter<TwoAdAp.ViewH> {
    List<TwoBean.ResultsBean> results;

    public TwoAdAp(List<TwoBean.ResultsBean> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_fuli, null);
        ViewH viewH = new ViewH(inflate);
        return viewH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewH viewH, int i) {
        Glide.with(viewH.iv.getContext()).load(results.get(i).getUrl()).into(viewH.iv);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewH extends RecyclerView.ViewHolder {
        ImageView iv;
        public ViewH(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
        }
    }
}
