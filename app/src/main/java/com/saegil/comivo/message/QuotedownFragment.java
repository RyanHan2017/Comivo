package com.saegil.comivo.message;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saegil.comivo.R;

/**
 * Created by a on 9/8/2016.
 */
public class QuotedownFragment extends Fragment {
    public QuotedownFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quotedown, container, false);
        return rootView;
    }
}
