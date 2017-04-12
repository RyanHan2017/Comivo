package com.saegil.comivo.community;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.saegil.comivo.R;

public class TimeLinePostDetailsActivity extends AppCompatActivity {

    final String KEY_TITLE="Title";
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line_post_details);
        setupLayout();
    }

    void setupLayout(){
        customizeToolBar();
        setupPostDetails();
    }

    void customizeToolBar(){
        Intent intent=getIntent();
        title=intent.getExtras().getString(KEY_TITLE);

        ImageButton leftImageButton=(ImageButton)findViewById(R.id.leftImageButton);
        leftImageButton.setImageResource(R.drawable.icon_left_arror_32);
        leftImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView textView=(TextView)findViewById(R.id.titleTextView);
        textView.setText(title);

        ImageButton rightImageButton=(ImageButton)findViewById(R.id.rightImageButton);
        rightImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"searchImage clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    void setupPostDetails(){
        TextView postDetailsTextView=(TextView)findViewById(R.id.moreDetails);
        postDetailsTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        postDetailsTextView.setText("Lorem ipsum dolor sit amet, sapeim etiam, nunc amet dolor ac odio mauris justo." +
                " Lorem ipsum dolor sit amet, sapeim etiam, nunc amet dolor ac odio mauris justo." +
                " Lorem ipsum dolor sit amet, sapeim etiam, nunc amet dolor ac odio mauris justo.");
    }
}
