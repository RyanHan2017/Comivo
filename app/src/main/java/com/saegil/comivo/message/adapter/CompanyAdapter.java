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
 * Created by a on 9/9/2016.
 */
public class CompanyAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;


    public CompanyAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
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
            vi = inflater.inflate(R.layout.list_row_company, null);

        TextView company = (TextView)vi.findViewById(R.id.company);
        TextView desc = (TextView)vi.findViewById(R.id.desc);
        TextView verify = (TextView)vi.findViewById(R.id.verify); // duration

        HashMap<String, String> map = new HashMap<String, String>();
        map = data.get(position);

        // Setting all values in listview
        company.setText(map.get("company"));
        desc.setText(map.get("desc"));
        verify.setText(map.get("verify"));
        if(verify.getText().equals("VERIFY"))
            verify.setTextColor(Color.GREEN);
        else
            verify.setTextColor(Color.BLUE);
        return vi;
    }
}