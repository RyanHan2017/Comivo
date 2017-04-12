package com.saegil.comivo.reviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.saegil.comivo.R;

public class WriteReviewActivity extends AppCompatActivity {

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        EditText writeReviewEdit1=(EditText)findViewById(R.id.writeReviewEdit1);
        writeReviewEdit1.setBackgroundResource(R.drawable.border_bg);
        EditText writeReviewEdit2=(EditText)findViewById(R.id.writeReviewEdit2);
        writeReviewEdit2.setBackgroundResource(R.drawable.border_bg);
        EditText writeReviewEdit3=(EditText)findViewById(R.id.writeReviewEdit3);
        writeReviewEdit3.setBackgroundResource(R.drawable.border_bg);
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
