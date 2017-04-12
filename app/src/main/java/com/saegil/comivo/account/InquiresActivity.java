package com.saegil.comivo.account;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.saegil.comivo.R;

public class InquiresActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquires);

        Button sendOfferButton=(Button)findViewById(R.id.inquires_send_offer_button);
        sendOfferButton.setBackgroundResource(R.drawable.round_rectangle_blue);
        Button updateQuoteButton=(Button)findViewById(R.id.inquires_update_quote_button);
        updateQuoteButton.setBackgroundResource(R.drawable.round_rectangle_orange);

    }
}
