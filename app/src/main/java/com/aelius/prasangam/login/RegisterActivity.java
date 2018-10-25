package com.aelius.prasangam.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aelius.prasangam.MainActivity;
import com.aelius.prasangam.R;
import com.aelius.prasangam.utils.ConstMethod;

public class RegisterActivity extends AppCompatActivity {

    Context context;
    EditText name_signup, mno_signup, email_signup, password_signup, conf_password_signup;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

    }

    private void validation() {

        if (ConstMethod.isInternetOn(RegisterActivity.this)) {
            if (TextUtils.isEmpty(name_signup.getText())) {
                name_signup.requestFocus();
                name_signup.setError("Enter Name");
            } else if (TextUtils.isEmpty(mno_signup.getText())) {
                mno_signup.requestFocus();
                mno_signup.setError("Enter Mobile No.");
            } else if (TextUtils.isEmpty(email_signup.getText())) {
                email_signup.requestFocus();
                email_signup.setError("Enter Email ID");
            } else if (!ConstMethod.isValidMail(email_signup.getText().toString())) {
                email_signup.requestFocus();
                email_signup.setError("Enter Valid Email");

            } else if (TextUtils.isEmpty(password_signup.getText())) {
                password_signup.requestFocus();
                password_signup.setError("Enter Password");
            } else if (ConstMethod.isValidPassword(password_signup.getText().toString())) {
                if (password_signup.getText().toString().trim().equals(conf_password_signup.getText().toString())) {

                    ServiceCall();

                } else {
                    conf_password_signup.requestFocus();
                    conf_password_signup.setError("Password Not Match");
                }
            } else {
                password_signup.requestFocus();
                password_signup.setError("Enter Valid Password");
            }
        } else {
            ConstMethod.NetworkAlert(RegisterActivity.this);

        }

    }

    private void ServiceCall() {

        startActivity(new Intent(context,MainActivity.class));
    }

    private void init() {

        context=this;

        name_signup = findViewById(R.id.name_signup);
        mno_signup = findViewById(R.id.mno_signup);
        email_signup = findViewById(R.id.email_signup);
        password_signup = findViewById(R.id.password_signup);
        conf_password_signup = findViewById(R.id.conf_password_signup);
        register = findViewById(R.id.register);
    }
}
