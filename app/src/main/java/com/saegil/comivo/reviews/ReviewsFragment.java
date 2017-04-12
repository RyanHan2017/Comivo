package com.saegil.comivo.reviews;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.message.adapter.CompanyAdapter;
import com.saegil.comivo.message.adapter.ReviewsAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by a on 9/9/2016.
 */
public class ReviewsFragment extends  Fragment {
    static final String KEY_TUMB = "tumb_image";
    static final String KEY_NAME = "name";

    static final String KEY_COMPANY = "company";

    View rootView;
    ListView list;
    ArrayList<HashMap<String, String>> dataList;
    ReviewsAdapter adapter;

    public ReviewsFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_reviews, container, false);
        loadListDat();
        return  rootView;
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

        list=(ListView)rootView.findViewById(R.id.list);
        adapter=new ReviewsAdapter(getActivity(), dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity().getBaseContext(),CompanyDetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
