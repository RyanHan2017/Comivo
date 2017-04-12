package com.saegil.comivo.account;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.account.adapter.ProductsAddActivity;

public class ProductsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        Button productsAddButtom=(Button)findViewById(R.id.products_add_buttom);
        productsAddButtom.setBackgroundResource(R.drawable.round_rectangle_blue);
        productsAddButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(),"asdf",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(ProductsActivity.this, ProductsAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
