package com.saegil.comivo.account;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.community.AnswerActivity;
import com.saegil.comivo.community.ChemicalActivity;
import com.saegil.comivo.community.PostActivity;
import com.saegil.comivo.community.QuestionActivity;
import com.saegil.comivo.community.TimeLineActivity;
import com.saegil.comivo.message.OrderActivity;
import com.saegil.comivo.setting.SettingActivity;

public class AccountActivity extends TabActivity implements TabHost.OnTabChangeListener {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        setupLayout();
    }

    @Override
    public void onTabChanged(String tabId) {
        setTabColor();
    }

    void setupLayout(){
        customizeToolBar();
        customizeTabBar();
    }

    void customizeToolBar(){
        ImageButton leftImageButton=(ImageButton)findViewById(R.id.leftImageButton);
        leftImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, SettingActivity.class));
            }
        });

        ImageButton rightImageButton= (ImageButton)findViewById(R.id.rightImageButton);
        rightImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"searchImage clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    void customizeTabBar(){
        tabHost = getTabHost();
        tabHost.setOnTabChangedListener(this);
        TabHost.TabSpec spec;

        spec = tabHost.newTabSpec("First").setIndicator("INQUIRES").setContent(new Intent(this,InquiresActivity.class));
        tabHost.addTab(spec);
//        tabHost.getTabWidget().getChildAt(0).getLayoutParams().width = 70;

        spec = tabHost.newTabSpec("Second").setIndicator("OPPORTUNITIES").setContent(new Intent(this,OpportunitiesActivity.class));
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(1).getLayoutParams().width = 100;

        spec = tabHost.newTabSpec("Third").setIndicator("ORDERS").setContent(new Intent(this, OrdersActivity.class));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Fourth").setIndicator("PRODUCT FOR SALE").setContent(new Intent(this,ProductsActivity.class));
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(3).getLayoutParams().width = 150;


        setTabColor();
    }

    void setTabColor(){
        final TabWidget tabWidget=(TabWidget)tabHost.findViewById(android.R.id.tabs);
        for(int i=0;i<tabWidget.getChildCount();i++){
            final View tabView=tabWidget.getChildTabViewAt(i);
            final TextView textView=(TextView)tabView.findViewById(android.R.id.title);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(10);
        }
        final View currentTabView=tabHost.getCurrentTabView();
        final TextView textView=(TextView)currentTabView.findViewById(android.R.id.title);
        textView.setTextColor(Color.GREEN);
    }
}
