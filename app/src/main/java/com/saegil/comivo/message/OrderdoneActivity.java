package com.saegil.comivo.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.saegil.comivo.R;
import com.saegil.comivo.util.Border;

public class OrderdoneActivity extends AppCompatActivity {

    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdone);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        LinearLayout layout1=(LinearLayout)findViewById(R.id.layout1);
        layout1.setBackgroundDrawable(new Border(0xff00ff00, 5));

        LinearLayout layout2=(LinearLayout)findViewById(R.id.layout2);
        layout2.setBackgroundDrawable(new Border(0xff00ff00, 5));

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
