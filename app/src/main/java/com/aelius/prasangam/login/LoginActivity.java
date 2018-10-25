package com.aelius.prasangam.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.aelius.prasangam.MainActivity;
import com.aelius.prasangam.R;
import com.aelius.prasangam.utils.ConstMethod;

public class LoginActivity extends AppCompatActivity {

    private String TAG = "LoginActivity";
    private EditText identity, password;
    private Button login,signup;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        init();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,RegisterActivity.class));
            }
        });
    }

    private void validation() {
        if (ConstMethod.isInternetOn(LoginActivity.this)) {
            if (TextUtils.isEmpty(identity.getText())) {
                identity.requestFocus();
                identity.setError("Enter Email ID");
            } else if (!ConstMethod.isValidMail(identity.getText().toString())) {
                identity.requestFocus();
                identity.setError("Enter Valid Email");

            } else if (TextUtils.isEmpty(password.getText())) {
                password.requestFocus();
                password.setError("Enter Password");
            } else if (ConstMethod.isValidPassword(password.getText().toString())) {

               //service call get with server
                ServiceCall();
            } else {
                password.requestFocus();
                password.setError("Enter Valid Password");
            }
        } else {
            ConstMethod.NetworkAlert(LoginActivity.this);

        }

    }

    private void ServiceCall() {
        startActivity(new Intent(context,MainActivity.class));
    }

    private void init() {

        context=this;
        identity=findViewById(R.id.email_login);
        password=findViewById(R.id.password_login);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
    }
}
