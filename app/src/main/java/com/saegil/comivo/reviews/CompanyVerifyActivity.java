package com.saegil.comivo.reviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.message.adapter.ReviewsAdapter;
import com.saegil.comivo.setting.SettingActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CompanyVerifyActivity extends AppCompatActivity {

    Toolbar mToolbar;
    static final String KEY_TUMB = "tumb_image";
    static final String KEY_NAME = "name";

    static final String KEY_COMPANY = "company";

    View rootView;
    ListView list;
    ArrayList<HashMap<String, String>> dataList;
    ReviewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_verify);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        LinearLayout verifyLayout=(LinearLayout)findViewById(R.id.verifyLayout);
        verifyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(CompanyVerifyActivity.this, VerifyActivity.class);
//                startActivity(intent);
            }
        });

        TextView writeReviewText=(TextView)findViewById(R.id.writeReviewText);
        writeReviewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyVerifyActivity.this, WriteReviewActivity.class);
                startActivity(intent);
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
            map.put(KEY_NAME, "Nick "+i);
            map.put(KEY_COMPANY, "America Chemical LLC"+i);
            if(r.nextInt(10)<5)
                map.put(KEY_TUMB,Integer.toString(R.drawable.message_man1));
            else
                map.put(KEY_TUMB,Integer.toString(R.drawable.message_man2));
            dataList.add(map);
        }

        list=(ListView)findViewById(R.id.list);
        adapter=new ReviewsAdapter(CompanyVerifyActivity.this, dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(),"Item Click",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(CompanyVerifyActivity.this, CompanyDetailActivity.class);
                startActivity(intent);

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
