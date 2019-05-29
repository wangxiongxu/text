package com.example.xiangmu.fragw;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiangmu.Bean.ThreeBean;
import com.example.xiangmu.R;

import java.util.List;

public class ThreeAdAp extends RecyclerView.Adapter<ThreeAdAp.ViewH> {
    List<ThreeBean.ResultsBean> results;

    public ThreeAdAp(List<ThreeBean.ResultsBean> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public ViewH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutop, null);
        ViewH viewH = new ViewH(inflate);
        return viewH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewH viewH, int i) {
        viewH.tv1.setText(results.get(i).getDesc());
        viewH.tv2.setText(results.get(i).getWho());
        viewH.tv3.setText(results.get(i).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewH extends RecyclerView.ViewHolder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public ViewH(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.andtitle);
            tv2=itemView.findViewById(R.id.andname);
            tv3=itemView.findViewById(R.id.andtitle);
        }
    }
}
