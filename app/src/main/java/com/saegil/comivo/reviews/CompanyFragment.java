package com.saegil.comivo.reviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.saegil.comivo.R;
import com.saegil.comivo.message.adapter.CompanyAdapter;
import com.saegil.comivo.message.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by a on 9/9/2016.
 */
public class CompanyFragment extends Fragment {
    static final String KEY_COMPANY = "company";
    static final String KEY_DESC = "desc";
    static final String KEY_VERIFY = "verify";
    static final String KEY_REVIEWS="reviews";

    View rootView;
    ListView list;
    ArrayList<HashMap<String, String>> dataList;
    CompanyAdapter adapter;

    public CompanyFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_company, container, false);
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
            map.put(KEY_COMPANY, "America Chemical LLC"+i);
            map.put(KEY_DESC, "255 Post Cale BlutPost Cale Blut Suite "+i);
            if(r.nextInt(20)<16)
                map.put(KEY_VERIFY,"VERIFY");
            else
                map.put(KEY_VERIFY,"WORK HERE?");
            dataList.add(map);
        }

        list=(ListView)rootView.findViewById(R.id.list);
        adapter=new CompanyAdapter(getActivity(), dataList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(getContext(),"Item Click",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getActivity().getBaseContext(),CompanyVerifyActivity.class);
                intent.putExtra("title","");
                startActivity(intent);
            }
        });
    }
}
