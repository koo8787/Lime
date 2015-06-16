package com.example.sungkoo.lime;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onBackButtonClicked(View v){
        Toast.makeText(getApplicationContext(),"Clicked BackButton!", Toast.LENGTH_LONG).show();
        finish();
    }

}