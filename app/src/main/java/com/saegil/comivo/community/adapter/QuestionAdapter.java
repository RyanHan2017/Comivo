package com.saegil.comivo.community.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.saegil.comivo.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by a on 9/10/2016.
 */
public class QuestionAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;

    public QuestionAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row_question, null);

        TextView company = (TextView)vi.findViewById(R.id.company); // title
        HashMap<String, String> map = new HashMap<String, String>();
        map = data.get(position);

        company.setText(map.get("company"));
        return vi;
    }
}
