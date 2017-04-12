package com.saegil.comivo.account.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.saegil.comivo.R;

public class ProductsAddActivity extends AppCompatActivity {

    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_add);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        EditText edit1=(EditText)findViewById(R.id.prodcuts_add_edit1);
        EditText edit2=(EditText)findViewById(R.id.prodcuts_add_edit2);
        EditText edit3=(EditText)findViewById(R.id.prodcuts_add_edit3);
        EditText edit4=(EditText)findViewById(R.id.prodcuts_add_edit4);
        edit1.setBackgroundResource(R.drawable.border_bg_blue);
        edit2.setBackgroundResource(R.drawable.border_bg_blue);
        edit3.setBackgroundResource(R.drawable.border_bg_blue);
        edit4.setBackgroundResource(R.drawable.border_bg_blue);

        Button addButton=(Button)findViewById(R.id.productsadd_add_button);
        Button submitButton=(Button)findViewById(R.id.productsadd_submit_button);
        addButton.setBackgroundResource(R.drawable.round_rectangle_blue);
        submitButton.setBackgroundResource(R.drawable.round_rectangle_blue);


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
