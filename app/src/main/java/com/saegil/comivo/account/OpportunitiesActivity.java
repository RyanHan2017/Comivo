package com.saegil.comivo.account;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.saegil.comivo.R;
import com.saegil.comivo.account.adapter.OpportunityAdapter;
import com.saegil.comivo.message.QuoteActivity;
import com.saegil.comivo.message.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class OpportunitiesActivity extends Activity {

    static final String KEY_TITLE = "title";
    static final String KEY_JOB="job";
    static final String KEY_DESC = "desc";
    static final String KEY_PHOTO="photo";
    static final String KEY_ARROW="arrow";
    ListView list;
    OpportunityAdapter adapter;
    ArrayList<HashMap<String, String>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunities);

        init();
    }
    public void init(){
        dataList= new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        Random r=new Random();
        for(int i=0;i<=20;i++){
            map=new HashMap<String, String>();
            map.put(KEY_TITLE, "Jim Kim"+i);
            map.put(KEY_JOB, "ABC Chemical LLC"+i);
            if(r.nextInt(10)>5) {
                map.put(KEY_ARROW, Integer.toString(R.drawable.tmp_icon3));
                map.put(KEY_PHOTO, Integer.toString(R.drawable.tmp_icon1));
            }else {
                map.put(KEY_ARROW, Integer.toString(R.drawable.tmp_icon4));
                map.put(KEY_PHOTO, Integer.toString(R.drawable.tmp_icon2));
            }
            if(i==0) map.put(KEY_PHOTO, Integer.toString(R.drawable.tmp_icon1));
            dataList.add(map);
        }

        list=(ListView)findViewById(R.id.list);
        adapter=new OpportunityAdapter(this, dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent=new Intent(OpportunitiesActivity.this,QuoteActivity.class);
//                intent.putExtra("No",1);
//                startActivity(intent);
            }
        });
    }
}
