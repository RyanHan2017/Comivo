package com.saegil.comivo.community;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;

public class WhitePostActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_post);
        setupLayout();
    }

    void setupLayout(){
        customizeToolBar();
    }

    void customizeToolBar(){
        ImageButton leftImageButton=(ImageButton)findViewById(R.id.leftImageButton);
        leftImageButton.setImageResource(R.drawable.icon_left_arror_32);
        leftImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView textView=(TextView)findViewById(R.id.titleTextView);
        textView.setText("WHITE POST");

        ImageButton rightImageButton=(ImageButton)findViewById(R.id.rightImageButton);
        rightImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"searchImage clicked",Toast.LENGTH_LONG).show();
            }
        });
    }
}
