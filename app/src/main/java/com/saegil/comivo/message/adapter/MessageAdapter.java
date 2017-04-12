package com.saegil.comivo.message.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.saegil.comivo.MainActivity;
import com.saegil.comivo.R;
import com.saegil.comivo.message.MessageActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by a on 9/7/2016.
 */
public class MessageAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    private int selectedIndex=-1;

    public MessageAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
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

    public void setSelectedIndex(int index){
        this.selectedIndex=index;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView name = (TextView)vi.findViewById(R.id.name); // title
        TextView job = (TextView)vi.findViewById(R.id.job); // title
        TextView desc = (TextView)vi.findViewById(R.id.desc); // artist name
        TextView time = (TextView)vi.findViewById(R.id.time); // duration
        ImageView mark_image=(ImageView)vi.findViewById(R.id.list_image0);
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
        ImageView arrow_image=(ImageView)vi.findViewById(R.id.arrow); // arrow image

        HashMap<String, String> map = new HashMap<String, String>();
        map = data.get(position);

        // Setting all values in listview
        name.setText(map.get("name"));
        job.setText("("+map.get("job")+")");
        desc.setText(map.get("desc"));
        time.setText(map.get("time"));
        mark_image.setImageResource(Integer.parseInt(map.get("mark")));
        thumb_image.setImageResource(Integer.parseInt(map.get("photo")));
        if(Integer.parseInt(map.get("arrow"))!=0)
            arrow_image.setImageResource(Integer.parseInt(map.get("arrow")));
        RelativeLayout rl=(RelativeLayout)vi.findViewById(R.id.rl);
        if(position==selectedIndex)
            rl.setBackground(activity.getResources().getDrawable(R.drawable.gradient_bg_hover));
        else
            rl.setBackground(activity.getResources().getDrawable(R.drawable.gradient_bg));
        return vi;
    }
}