package com.saegil.comivo.community;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.community.adapter.ChemicalAdapter;
import com.saegil.comivo.message.QuoteActivity;
import com.saegil.comivo.message.adapter.MessageAdapter;
import com.saegil.comivo.setting.SettingActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ChemicalActivity extends Activity {
    static final String KEY_DATA = "data"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_TITLE = "title";
    static final String KEY_JOB="job";
    static final String KEY_DESC = "desc";
    static final String KEY_TIME = "time";
    static final String KEY_PHOTO="photo";
    static final String KEY_MARK="mark";
    static final String KEY_ARROW="arrow";
    ListView list;
    ChemicalAdapter adapter;
    ArrayList<HashMap<String, String>> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical);

        init();
    }
    public void init(){
        dataList= new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        Random r=new Random();
        for(int i=0;i<=20;i++){
            map=new HashMap<String, String>();
            map.put(KEY_TITLE, "Benzoic Acid"+i);
            dataList.add(map);
        }

        list=(ListView)findViewById(R.id.list);
        adapter=new ChemicalAdapter(this, dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//                Intent intent=new Intent(ChemicalActivity.this,QuoteActivity.class);
//                intent.putExtra("No",1);
//                startActivity(intent);
            }
        });
    }
}
