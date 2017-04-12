package com.saegil.comivo.account.adapter;

import android.app.Activity;
import android.content.Context;
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
public class OpportunityAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;

    public OpportunityAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
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
            vi = inflater.inflate(R.layout.list_row_opportunity, null);

        TextView title = (TextView)vi.findViewById(R.id.title); // title
        ImageView arrow_image=(ImageView)vi.findViewById(R.id.image1); // arrow image
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.circle_image4); // thumb image

        HashMap<String, String> map = new HashMap<String, String>();
        map = data.get(position);

        // Setting all values in listview
        title.setText(map.get("title"));
        thumb_image.setImageResource(Integer.parseInt(map.get("photo")));
        arrow_image.setImageResource(Integer.parseInt(map.get("arrow")));
        return vi;
    }
}
