package com.saegil.comivo.community;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.setting.SettingActivity;

public class CommunityActivity extends TabActivity implements TabHost.OnTabChangeListener {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
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
                startActivity(new Intent(CommunityActivity.this, SettingActivity.class));
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

        spec = tabHost.newTabSpec("First").setIndicator("TimeLine").setContent(new Intent(this,TimeLineActivity.class));
        tabHost.addTab(spec);


        spec = tabHost.newTabSpec("Second").setIndicator("Post").setContent(new Intent(this,PostActivity.class));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Third").setIndicator("Answer").setContent(new Intent(this,AnswerActivity.class));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Fourth").setIndicator("Question").setContent(new Intent(this,QuestionActivity.class));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Fifth").setIndicator("Chemical").setContent(new Intent(this,ChemicalActivity.class));
        tabHost.addTab(spec);

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
