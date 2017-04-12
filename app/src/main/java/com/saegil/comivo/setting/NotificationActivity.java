package com.saegil.comivo.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.saegil.comivo.R;

public class NotificationActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        LinearLayout linearLayout1=(LinearLayout)findViewById(R.id.linearlayout1);
        linearLayout1.setBackgroundResource(R.drawable.border_bg);
        LinearLayout linearLayout2=(LinearLayout)findViewById(R.id.linearlayout2);
        linearLayout2.setBackgroundResource(R.drawable.border_bg);
        LinearLayout linearLayout3=(LinearLayout)findViewById(R.id.linearlayout3);
        linearLayout3.setBackgroundResource(R.drawable.border_bg);
        LinearLayout linearLayout4=(LinearLayout)findViewById(R.id.linearlayout4);
        linearLayout4.setBackgroundResource(R.drawable.border_bg);
        LinearLayout linearLayout5=(LinearLayout)findViewById(R.id.linearlayout5);
        linearLayout5.setBackgroundResource(R.drawable.border_bg);
        LinearLayout linearLayout6=(LinearLayout)findViewById(R.id.linearlayout6);
        linearLayout6.setBackgroundResource(R.drawable.border_bg);
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
