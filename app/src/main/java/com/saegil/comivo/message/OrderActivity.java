package com.saegil.comivo.message;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.message.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class OrderActivity extends AppCompatActivity {

    static final String KEY_DATA = "data"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_JOB="job";
    static final String KEY_DESC = "desc";
    static final String KEY_TIME = "time";
    static final String KEY_PHOTO="photo";
    static final String KEY_MARK="mark";
    static final String KEY_ARROW="arrow";

    int buttonFlag=0;
    Toolbar mToolbar;
    View rootView;
    ListView list;
    LinearLayout linear1,makeLayout;
    GridLayout buttongroup;
    TextView left_title4_2,right_title4_2;
    Button makeButton1,makeButton2,makeButton3,makeButton4;
    ImageView circleImage1,circleImage2,circleImage3;
    MessageAdapter adapter;
    ArrayList<HashMap<String, String>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        makeButton1=(Button)findViewById(R.id.make_button1);
        makeButton2=(Button)findViewById(R.id.make_button2);
        makeButton3=(Button)findViewById(R.id.make_button3);
        makeButton4=(Button)findViewById(R.id.make_button4);

        circleImage1=(ImageView)findViewById(R.id.circle_image1);
        circleImage2=(ImageView)findViewById(R.id.circle_image2);
        circleImage3=(ImageView)findViewById(R.id.circle_image3);

        ImageView downArrowImage=(ImageView)findViewById(R.id.image1);
        downArrowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonFlag==3){
                    //Toast.makeText(getBaseContext(),"DownImageClick",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(OrderActivity.this,OrderdoneActivity.class);
                    startActivity(intent);
                }
            }
        });

        circleImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        circleImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        circleImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        makeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonFlag==0) {
                    makeButton2.setBackgroundColor(0xFF00cd00);
                    makeButton2.setTextColor(0xFFFFFFFF);
                    buttonFlag++;
                }
            }
        });
        makeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonFlag==1) {
                    makeButton3.setBackgroundColor(0xFF00cd00);
                    makeButton3.setTextColor(0xFFFFFFFF);
                    buttonFlag++;
                }
            }
        });
        makeButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buttonFlag==2) {
                    makeButton4.setBackgroundColor(0xFF00cd00);
                    makeButton4.setTextColor(0xFFFFFFFF);
                    buttonFlag++;
                }
            }
        });

        loadListDat();

    }

    public void loadListDat(){
        dataList= new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        Random r=new Random();
        dataList.clear();
        for(int i=0;i<=20;i++){
            map=new HashMap<String, String>();
            map.put(KEY_ID, Integer.toString(i+1));
            map.put(KEY_NAME, "Jim Kim"+i);
            map.put(KEY_JOB, "ABC Chemical LLC"+i);
            map.put(KEY_DESC,"Learm ipsum dolor sit amet, consectetur ...");
            if(r.nextInt(10)>5)
                map.put(KEY_MARK,Integer.toString(R.drawable.message_ico1));
            else
                map.put(KEY_MARK,Integer.toString(R.drawable.message_ico2));
            if(i % 2 ==0){
                map.put(KEY_TIME, "4:47 AM");
                map.put(KEY_PHOTO,Integer.toString(R.drawable.message_man1));
            }else{
                map.put(KEY_TIME, "8:47 PM");
                map.put(KEY_PHOTO,Integer.toString(R.drawable.message_man2));
            }
            map.put(KEY_ARROW,"0");
            dataList.add(map);
        }

        list=(ListView)findViewById(R.id.list);
        adapter=new MessageAdapter(OrderActivity.this, dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(OrderActivity.this,"Item Click",Toast.LENGTH_LONG).show();
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
