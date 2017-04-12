package com.saegil.comivo.message;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.message.adapter.MessageAdapter;
import com.saegil.comivo.setting.SettingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MessageActivity extends AppCompatActivity {
    static final String KEY_DATA = "data"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_JOB="job";
    static final String KEY_DESC = "desc";
    static final String KEY_TIME = "time";
    static final String KEY_PHOTO="photo";
    static final String KEY_MARK="mark";
    static final String KEY_ARROW="arrow";
    ListView list;
    MessageAdapter adapter;
    ArrayList<HashMap<String, String>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);

        View view=getSupportActionBar().getCustomView();
        TextView textView=(TextView)view.findViewById(R.id.title);
        textView.setText("MESSAGE");

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);
        imageButton.setImageResource(R.drawable.icon_list_32);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MessageActivity.this, SettingActivity.class);
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

        init();
    }
    public void init(){
        dataList= new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        Random r=new Random();
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
            map.put(KEY_ARROW,Integer.toString(R.drawable.message_arrow));
            dataList.add(map);
        }

        list=(ListView)findViewById(R.id.list);
        adapter=new MessageAdapter(this, dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Log.d("DDDDD", view.toString());
                adapter.setSelectedIndex(position);
                adapter.notifyDataSetChanged();
//                for(int i=0;i<parent.getChildCount();i++){
//                    RelativeLayout rl=(RelativeLayout)parent.getChildAt(i);
//                    rl.setBackground(getResources().getDrawable(R.drawable.gradient_bg));
//                }
//                ((RelativeLayout)view).setBackground(getResources().getDrawable(R.drawable.gradient_bg_hover));

                //Intent intent=new Intent(MessageActivity.this,QuoteActivity.class);
                //intent.putExtra("No",1);
                //startActivity(intent);
            }
        });
    }
}
