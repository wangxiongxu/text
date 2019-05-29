package com.example.xiangmu.fragr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.xiangmu.R;
import com.example.xiangmu.base.BaseFrag;

public class FragFour extends BaseFrag {

    private View view;
    private WebView mWbc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.wb, null);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mWbc = (WebView) inflate.findViewById(R.id.wbc);
        mWbc.loadUrl("https://www.baidu.com/");
        mWbc.setWebViewClient(new WebViewClient());
    }
}
