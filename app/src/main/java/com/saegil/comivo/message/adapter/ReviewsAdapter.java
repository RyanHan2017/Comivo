package com.saegil.comivo.message.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.saegil.comivo.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by a on 9/10/2016.
 */
public class ReviewsAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;


    public ReviewsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
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
            vi = inflater.inflate(R.layout.list_row_reviews, null);

        TextView name = (TextView)vi.findViewById(R.id.name);
        TextView company = (TextView)vi.findViewById(R.id.company);
        ImageView tumbImage=(ImageView)vi.findViewById(R.id.tumb_image);

        HashMap<String, String> map = new HashMap<String, String>();
        map = data.get(position);

        company.setText(map.get("company"));
        name.setText(map.get("name"));
        tumbImage.setImageResource(Integer.parseInt(map.get("tumb_image")));
        return vi;
    }
}