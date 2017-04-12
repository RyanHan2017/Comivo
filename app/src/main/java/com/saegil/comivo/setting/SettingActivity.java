package com.saegil.comivo.setting;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.saegil.comivo.R;
import com.saegil.comivo.util.Border;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity {

    Toolbar mToolbar;
    TextView goProfile, goSocialMedia, goNotification, goPrivacy, goFacebook, goQA, goAbout, goPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        LinearLayout linearLayout1=(LinearLayout)findViewById(R.id.linearlayout1);
        LinearLayout linearLayout2=(LinearLayout)findViewById(R.id.linearlayout2);
        LinearLayout linearLayout3=(LinearLayout)findViewById(R.id.linearlayout3);
        LinearLayout linearLayout4=(LinearLayout)findViewById(R.id.linearlayout4);
        linearLayout1.setBackgroundResource(R.drawable.border_bg);
        linearLayout2.setBackgroundResource(R.drawable.border_bg);
        linearLayout3.setBackgroundResource(R.drawable.border_bg);
        linearLayout4.setBackgroundResource(R.drawable.border_bg);

        goProfile=(TextView)findViewById(R.id.goProfile);
        goSocialMedia=(TextView)findViewById(R.id.goSocialMedia);
        goNotification=(TextView)findViewById(R.id.goNotification);
        goPrivacy=(TextView)findViewById(R.id.goPrivacy);
        goFacebook=(TextView)findViewById(R.id.goFacebook);
        goQA=(TextView)findViewById(R.id.goQA);
        goAbout=(TextView)findViewById(R.id.goAbout);
        goPassword=(TextView)findViewById(R.id.goPassword);
        goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        goSocialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, SocialMediaActivity.class);
                startActivity(intent);
            }
        });
        goNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
        goPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, PrivacyActivity.class);
                startActivity(intent);
            }
        });
        goFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, FacebookActivity.class);
                startActivity(intent);
            }
        });
        goQA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, QaActivity.class);
                startActivity(intent);
            }
        });
        goAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
        goPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });

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
