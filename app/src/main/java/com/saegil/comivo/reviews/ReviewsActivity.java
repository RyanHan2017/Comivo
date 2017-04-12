package com.saegil.comivo.reviews;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.message.QuoteFragment;
import com.saegil.comivo.message.QuotedownFragment;
import com.saegil.comivo.setting.SettingActivity;

public class ReviewsActivity extends AppCompatActivity {

    Fragment fragment;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout_1);

        View view=getSupportActionBar().getCustomView();
        textView1=(TextView)view.findViewById(R.id.title1);
        textView2=(TextView)view.findViewById(R.id.title2);
        textView2.setTextColor(Color.DKGRAY);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setTextColor(Color.DKGRAY);
                textView1.setTextColor(Color.WHITE);
                showCompanyFragement();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setTextColor(Color.DKGRAY);
                textView2.setTextColor(Color.WHITE);
                showReviewsFragement();
            }
        });

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);
        imageButton.setImageResource(R.drawable.icon_list_32);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ReviewsActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        ImageButton searchImage= (ImageButton)view.findViewById(R.id.action_bar_forward);
        searchImage.setImageResource(R.drawable.ic_search);
        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"searchImage clicked",Toast.LENGTH_LONG).show();
            }
        });

        showCompanyFragement();

    }

    public void showCompanyFragement(){
        fragment = new CompanyFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
    }

    public void showReviewsFragement(){
        fragment = new ReviewsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
    }

}
