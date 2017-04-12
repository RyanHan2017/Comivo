package com.saegil.comivo.community;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.saegil.comivo.R;
import com.saegil.comivo.community.adapter.TimeLineAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PostActivity extends Activity {

    static final String KEY_ID="id";
    static final String KEY_TITLE="title";
    static final String KEY_PHOTO="photo";
    static final String KEY_NAME="name";
    static final String KEY_LOCALE="locale";
    static final String KEY_ANSWERS="answers";
    static final String KEY_QUESTIONS="questions";
    static final String KEY_POSTS="posts";
    static final String KEY_REVIEW="reviews";
    static final String KEY_DETAILS="details";
    static final String KEY_IMAGE="image";
    static final String KEY_LIKEANDCOMMENTS="likesAndComments";

    ListView listView;
    TimeLineAdapter adapter;
    ArrayList<HashMap<String, String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        setupLayout();
    }

    void setupLayout(){
        init();
        TextView postTextView=(TextView)findViewById(R.id.postTextView);
        postTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostActivity.this,WhitePostActivity.class));
            }
        });
    }

    public void init(){
        data=new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hashMap;
        Random random=new Random();
        for(int i=0;i<10;i++){
            hashMap=new HashMap<String, String>();
            hashMap.put(KEY_ID, Integer.toString(i+1));
            hashMap.put(KEY_TITLE,"The chemical market still growing up");
            hashMap.put(KEY_NAME,"Kim"+(i+1));
            hashMap.put(KEY_LOCALE,getRandomLocaleDateTime());
            hashMap.put(KEY_ANSWERS,Integer.toString(random.nextInt(5)));
            hashMap.put(KEY_QUESTIONS,Integer.toString(random.nextInt(5)));
            hashMap.put(KEY_POSTS,Integer.toString(random.nextInt(5)));
            hashMap.put(KEY_REVIEW,Integer.toString(random.nextInt(5)));
            hashMap.put(KEY_DETAILS,"Lorem ipsum dolor sit amet, sapeim etiam, nunc amet dolor ac odio mauris justo. Lorem ipsum dolor sit amet, sapeim etiam, nunc amet dolor ac odio mauris justo. Lorem ipsum dolor sit amet, sapeim etiam, nunc amet dolor ac odio mauris justo.");
            hashMap.put(KEY_LIKEANDCOMMENTS,getRandomLikesAndComments());
            switch(random.nextInt(5)){
                case 0:
                    hashMap.put(KEY_PHOTO,Integer.toString(R.drawable.message_man1));
                    hashMap.put(KEY_IMAGE,Integer.toString(R.drawable.bg1));
                    break;
                case 1:
                    hashMap.put(KEY_PHOTO,Integer.toString(R.drawable.message_man2));
                    hashMap.put(KEY_IMAGE,Integer.toString(R.drawable.bg2));
                    break;
                default:
                    hashMap.put(KEY_PHOTO,Integer.toString(R.drawable.message_man2));
                    hashMap.put(KEY_IMAGE,"0");
            }
            data.add(hashMap);
        }

        listView=(ListView)findViewById(R.id.list);
        adapter=new TimeLineAdapter(this, data);
        adapter.setTitle("POST DETAILS");
        listView.setAdapter(adapter);
    }

    String getRandomLocaleDateTime(){
        Random random=new Random();
        String hour=Integer.toString(random.nextInt(12));
        String minute=Integer.toString(random.nextInt(60));
        String AM_PM=(random.nextBoolean()?"AM":"PM");
        String day=Integer.toString(random.nextInt(30));
        String month=Integer.toString(random.nextInt(12)+1);
        String year=Integer.toString(random.nextInt(5)+2010);
        return "USA-"+hour+":"+minute+AM_PM+" "+month+"/"+day+"/"+year;
    }

    String getRandomLikesAndComments(){
        Random random=new Random();
        String likes=Integer.toString(random.nextInt(20));
        String comments=Integer.toString(random.nextInt(10));
        return likes+" likes"+(comments=="0"?"":" . "+comments+" comments");
    }
}
