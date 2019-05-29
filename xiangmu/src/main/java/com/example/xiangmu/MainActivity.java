package com.example.xiangmu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.xiangmu.base.BaseActivity;
import com.example.xiangmu.frag.FragOne;
import com.example.xiangmu.fragq.FragTwo;
import com.example.xiangmu.fragr.FragFour;
import com.example.xiangmu.fragw.FragThree;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar mTool;
    /**
     * C
     */
    private Button mBt1;
    /**
     * D
     */
    private Button mBt2;
    private NavigationView mCehua;

    private DrawerLayout mDl;

    //王旭 1810A
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt1.setOnClickListener(this);
        mBt2 = (Button) findViewById(R.id.bt2);
        mBt2.setOnClickListener(this);
        mCehua = (NavigationView) findViewById(R.id.cehua);
        mTool.setTitle("");
        setSupportActionBar(mTool);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        addFragment(getSupportFragmentManager(), FragOne.class, R.id.fl, null);
        mCehua.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.zhihu:
                        addFragment(getSupportFragmentManager(), FragOne.class, R.id.fl, null);
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.weChat:
                        addFragment(getSupportFragmentManager(), FragTwo.class, R.id.fl, null);
                        mDl.closeDrawer(Gravity.LEFT);
                        break;
                }
                return false;
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt1:
                addFragment(getSupportFragmentManager(), FragThree.class, R.id.fl, null);

                break;
            case R.id.bt2:
                addFragment(getSupportFragmentManager(), FragFour.class, R.id.fl, null);
                break;
        }
    }
}
