package com.saegil.comivo.message;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by a on 9/8/2016.
 */
public class QuoteFragment extends Fragment {
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

    View rootView;
    ListView list;
    LinearLayout linear1,makeLayout;
    GridLayout buttongroup;
    TextView left_title4_2,right_title4_2;
    Button button1,button2,button3;
    ImageView circleImage1,circleImage2,circleImage3;
    MessageAdapter adapter;
    ArrayList<HashMap<String, String>> dataList;

    public QuoteFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_quote, container, false);

        linear1=(LinearLayout)rootView.findViewById(R.id.linear1);
        makeLayout=(LinearLayout)rootView.findViewById(R.id.makeLayout);
        buttongroup=(GridLayout)rootView.findViewById(R.id.buttongroup);


        circleImage1=(ImageView)rootView.findViewById(R.id.circle_image1);
        circleImage2=(ImageView)rootView.findViewById(R.id.circle_image2);
        circleImage3=(ImageView)rootView.findViewById(R.id.circle_image3);

        button1=(Button)rootView.findViewById(R.id.button1);
        button2=(Button)rootView.findViewById(R.id.button2);
        button3=(Button)rootView.findViewById(R.id.button3);

        left_title4_2=(TextView)rootView.findViewById(R.id.left_title4_2);
        right_title4_2=(TextView)rootView.findViewById(R.id.right_title4_2);

        circleImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left_title4_2.setText("↑10.00");
                left_title4_2.setTextColor(0xFFFF0000);
                right_title4_2.setText("↑10.00");
                right_title4_2.setTextColor(0xFFFF0000);
                circleImageChange();
                circleImage1.setImageResource(R.drawable.message_ico1);
            }
        });
        circleImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left_title4_2.setText("↓10.00");
                left_title4_2.setTextColor(0xFF0000FF);
                right_title4_2.setText("↓10.00");
                right_title4_2.setTextColor(0xFF0000FF);
                circleImageChange();
                circleImage2.setImageResource(R.drawable.message_ico1);
            }
        });
        circleImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left_title4_2.setText("↑10.00");
                left_title4_2.setTextColor(0xFFFF0000);
                right_title4_2.setText("↑10.00");
                right_title4_2.setTextColor(0xFFFF0000);
                circleImageChange();
                circleImage3.setImageResource(R.drawable.message_ico1);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDisable();
                left_title4_2.setText("");
                right_title4_2.setText("");
                loadListDat();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListDat();
                buttonDisable();
                button2.setEnabled(true);
                button2.setBackgroundColor(0xFFF39c11);
                button2.setText("@ 71 : 45 : 08");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getActivity().getBaseContext(),OrderActivity.class);
                startActivity(intent);
            }
        });


        loadListDat();
        return rootView;
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

        list=(ListView)rootView.findViewById(R.id.list);
        adapter=new MessageAdapter(getActivity(), dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(),"Item Click",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void buttonDisable(){
        button1.setEnabled(false);
        button1.setBackgroundColor(0xFFd2d2d2);
        button2.setEnabled(false);
        button2.setBackgroundColor(0xFFd2d2d2);
        button3.setEnabled(false);
        button3.setBackgroundColor(0xFFd2d2d2);
    }

    public void buttonEnable(){
        button1.setEnabled(true);
        button1.setBackgroundColor(0xFF1280c4);
        button2.setEnabled(true);
        button2.setBackgroundColor(0xFF1280c4);
        button3.setEnabled(true);
        button3.setBackgroundColor(0xFF1280c4);
    }

    public void circleImageChange(){
        buttonEnable();
        loadListDat();
        circleImage1.setImageResource(R.drawable.message_ico2);
        circleImage2.setImageResource(R.drawable.message_ico2);
        circleImage3.setImageResource(R.drawable.message_ico2);
    }
}
