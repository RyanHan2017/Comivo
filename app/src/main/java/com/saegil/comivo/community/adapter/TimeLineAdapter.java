package com.saegil.comivo.community.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.saegil.comivo.R;
import com.saegil.comivo.community.TimeLinePostDetailsActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeLineAdapter extends BaseAdapter {

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

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;

    String title="TIMELINE";

    public TimeLineAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTitle(String title){
        this.title=title;
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
        View view=convertView;
        if(convertView==null)view=inflater.inflate(R.layout.list_row_community_time_line,null);
        TextView titleView=(TextView)view.findViewById(R.id.title);
        ImageView photoImageView=(ImageView)view.findViewById(R.id.photo);
        TextView nameView=(TextView)view.findViewById(R.id.name);
        TextView localeView=(TextView)view.findViewById(R.id.locale);
        TextView answersView=(TextView)view.findViewById(R.id.answers);
        TextView questionsView=(TextView)view.findViewById(R.id.questions);
        TextView postsView=(TextView)view.findViewById(R.id.posts);
        TextView reviewsView=(TextView)view.findViewById(R.id.reviews);
        TextView detailsView=(TextView)view.findViewById(R.id.details);
        ImageView imageImageView=(ImageView)view.findViewById(R.id.image);
        TextView likesAndCommentsView=(TextView)view.findViewById(R.id.likesAndComments);

        HashMap<String, String> hashMap=new HashMap<String, String>();
        hashMap=data.get(position);

        titleView.setText(hashMap.get(KEY_TITLE));
        photoImageView.setImageResource(Integer.parseInt(hashMap.get(KEY_PHOTO)));
        nameView.setText(hashMap.get(KEY_NAME));
        localeView.setText(hashMap.get(KEY_LOCALE));
        answersView.setText(hashMap.get(KEY_ANSWERS));
        questionsView.setText(hashMap.get(KEY_QUESTIONS));
        postsView.setText(hashMap.get(KEY_POSTS));
        reviewsView.setText(hashMap.get(KEY_REVIEW));
        detailsView.setText(hashMap.get(KEY_DETAILS));
        if(hashMap.get(KEY_IMAGE)!="0"){
            imageImageView.setImageResource(Integer.parseInt(hashMap.get(KEY_IMAGE)));
        }
        likesAndCommentsView.setText(hashMap.get(KEY_LIKEANDCOMMENTS));

        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,TimeLinePostDetailsActivity.class);
                intent.putExtra("Title",title);
                activity.startActivity(intent);
            }
        });

        detailsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity,TimeLinePostDetailsActivity.class);
                intent.putExtra("Title",title);
                activity.startActivity(intent);
            }
        });
        return view;
    }
}
