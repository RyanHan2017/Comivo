package com.saegil.comivo.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.saegil.comivo.R;

public class SocialMediaActivity extends AppCompatActivity {

    Toolbar mToolbar;
    LinearLayout facebookLayout;
    LinearLayout linkedinLayout;
    LinearLayout twitterLayout;
    LinearLayout googleplusLayout;
    LinearLayout instagramLayout;
    LinearLayout pinterestLayout;
    LinearLayout tumbrlLayout;
    LinearLayout wechatLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        facebookLayout=(LinearLayout)findViewById(R.id.linearFacebook);
        linkedinLayout=(LinearLayout)findViewById(R.id.linkedinLayout);
        twitterLayout=(LinearLayout)findViewById(R.id.twitterLyout);
        googleplusLayout=(LinearLayout)findViewById(R.id.googleplusLyout);
        instagramLayout=(LinearLayout)findViewById(R.id.instagramLyout);
        pinterestLayout=(LinearLayout)findViewById(R.id.pinterestLyout);
        tumbrlLayout=(LinearLayout)findViewById(R.id.tubmrlLyout);
        wechatLayout=(LinearLayout)findViewById(R.id.wechatLyout);

        facebookLayout.setBackgroundResource(R.drawable.border_bg);
        linkedinLayout.setBackgroundResource(R.drawable.border_bg);
        twitterLayout.setBackgroundResource(R.drawable.border_bg);
        googleplusLayout.setBackgroundResource(R.drawable.border_bg);
        instagramLayout.setBackgroundResource(R.drawable.border_bg);
        pinterestLayout.setBackgroundResource(R.drawable.border_bg);
        tumbrlLayout.setBackgroundResource(R.drawable.border_bg);
        wechatLayout.setBackgroundResource(R.drawable.border_bg);
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
}
