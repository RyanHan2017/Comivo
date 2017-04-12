package com.saegil.comivo;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TabHost;

import com.saegil.comivo.account.AccountActivity;
import com.saegil.comivo.community.CommunityActivity;
import com.saegil.comivo.message.MessageActivity;
import com.saegil.comivo.reviews.ReviewsActivity;

public class DashboardActivity extends TabActivity  implements TabHost.OnTabChangeListener {

    Toolbar mToolbar;
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tabHost = getTabHost();
        tabHost.setOnTabChangedListener(this);
        TabHost.TabSpec spec;
        Intent intent;

        intent = new Intent().setClass(this, MessageActivity.class);
        //spec = tabHost.newTabSpec("First").setIndicator("Message").setContent(intent);
        spec = tabHost.newTabSpec("First").setIndicator("",getResources().getDrawable(R.drawable.tab_icon_message)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, ReviewsActivity.class);
        spec = tabHost.newTabSpec("Second").setIndicator("",getResources().getDrawable(R.drawable.tab_icon_review)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this,CommunityActivity.class);
        spec = tabHost.newTabSpec("Third").setIndicator("",getResources().getDrawable(R.drawable.tab_icon_community)).setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this,AccountActivity.class);
        spec = tabHost.newTabSpec("Fourth").setIndicator("",getResources().getDrawable(R.drawable.tab_icon_account)).setContent(intent);
        tabHost.addTab(spec);

//        tabHost.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.tab_ico4);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {

        /************ Called when tab changed *************/

        //********* Check current selected tab and change according images *******/

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
 /*           if(i==0)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab1);
            else if(i==1)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab2);
            else if(i==2)
                tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.tab3);
*/        }


        Log.i("tabs", "CurrentTab: "+tabHost.getCurrentTab());

/*        if(tabHost.getCurrentTab()==0)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab1_over);
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab2_over);
        else if(tabHost.getCurrentTab()==2)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.tab3_over);
*/
    }

}
