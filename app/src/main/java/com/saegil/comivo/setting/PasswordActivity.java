package com.saegil.comivo.setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;

import com.saegil.comivo.R;

public class PasswordActivity extends AppCompatActivity {

    Toolbar mToolbar;
    EditText currentPassword, newPassword, confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        currentPassword=(EditText)findViewById(R.id.currentPassword);
        newPassword=(EditText)findViewById(R.id.newPassword);
        confirmPassword=(EditText)findViewById(R.id.confirmPassword);

        currentPassword.setBackgroundResource(R.drawable.border_bg);
        newPassword.setBackgroundResource(R.drawable.border_bg);
        confirmPassword.setBackgroundResource(R.drawable.border_bg);
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
