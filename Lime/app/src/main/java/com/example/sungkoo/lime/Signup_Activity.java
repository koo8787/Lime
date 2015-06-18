package com.example.sungkoo.lime;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.parse.ParseObject;

public class Signup_Activity extends ActionBarActivity {
        EditText SignupNameEdit;
        EditText SignupPassswordEdit;
        EditText SignupCPassswordEdit;
        EditText SignupEmailEdit;
        String NameEditString;
        String PassWordEditString;
        String PassWordCEditString;
        String EmailEditString;
        ParseObject Signup = new ParseObject("Signup");


   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activiry_signup);
     }

    public void OnSignupButton(View v) {
        SignupNameEdit = (EditText) findViewById(R.id.SignupNameEdit);
        NameEditString = SignupNameEdit.getText().toString();
        SignupPassswordEdit = (EditText) findViewById(R.id.SignupPassswordEdit);
        PassWordEditString = SignupPassswordEdit.getText().toString();
        SignupCPassswordEdit = (EditText) findViewById(R.id.SignupCPassswordEdit);
        PassWordCEditString = SignupCPassswordEdit.getText().toString();
        SignupEmailEdit = (EditText) findViewById(R.id.SignupEmailEdit);
        EmailEditString = SignupEmailEdit.getText().toString();


        Signup.put("Name", NameEditString);
        Signup.put("Password", PassWordEditString);
        Signup.put("PasswordC", PassWordCEditString);
        Signup.put("Email", EmailEditString);
        Signup.saveInBackground();

        finish();

    }
    }




