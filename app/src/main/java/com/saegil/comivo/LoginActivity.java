package com.saegil.comivo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.saegil.comivo.Landing.ForgotActivity;
import com.saegil.comivo.Landing.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    Button signupbutton, loginbuttton;
    TextView forgotText;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotText=(TextView)findViewById(R.id.forgot_text);
        signupbutton=(Button)findViewById(R.id.signinBtn);
        loginbuttton=(Button)findViewById(R.id.loginBtn);

        forgotText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(intent);
            }
        });
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        loginbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
