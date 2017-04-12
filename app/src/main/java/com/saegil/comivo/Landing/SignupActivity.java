package com.saegil.comivo.Landing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;
import com.saegil.comivo.R;

import org.w3c.dom.Text;

public class SignupActivity extends AppCompatActivity {

    Toolbar mToolbar;
    Spinner businessType;
    EditText passwordText;
    TextView membershipAgreement, privacyPolicy;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        businessType= (Spinner)findViewById(R.id.signup_businesstype);
        String[] plants = new String[]{"One","Two","Three"};
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,plants
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        businessType.setAdapter(spinnerArrayAdapter);

        final BubbleLayout bubbleLayout = (BubbleLayout) LayoutInflater.from(this).inflate(R.layout.tooltip_popup, null);
        final PopupWindow popupWindow = BubblePopupHelper.create(this, bubbleLayout);

        passwordText=(EditText)findViewById(R.id.signup_password);
        passwordText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    bubbleLayout.setArrowDirection(ArrowDirection.TOP);
                    popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                }
            }
        });

        membershipAgreement=(TextView)findViewById(R.id.signup_membership_agreement);
        membershipAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignupActivity.this,MembershipAgreementActivity.class);
                startActivity(intent);
            }
        });

        privacyPolicy=(TextView) findViewById(R.id.signup_privacy_policy);
        privacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignupActivity.this,PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });

        signupButton=(Button)findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignupActivity.this, SignupDoneActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked(View view){
        //Toast.makeText(SignupActivity.this,"asd",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }
}
