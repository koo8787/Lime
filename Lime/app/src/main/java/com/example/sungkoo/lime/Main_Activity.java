package com.example.sungkoo.lime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;


public class Main_Activity extends ActionBarActivity {
    EditText LoginidEdit;
    EditText LoginPassswordEdit;
    String LoginidString;
    String LoginPassWordString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "dAw3ryusMc2mYss53iJ17bHk8JC8cAB36Jo7Bovk", "l93NE4dRQdbqsJor7WmFlPmpGIdCgZPWWfZoTZri");
    }

    public void OnButtonLoginClicked(View v){
        LoginidEdit = (EditText) findViewById(R.id.usernameEntry);
        LoginidString = LoginidEdit.getText().toString();
        LoginPassswordEdit = (EditText) findViewById(R.id.passwordEntry);
        LoginPassWordString = LoginPassswordEdit.getText().toString();
        Toast.makeText(getApplicationContext(),"Sign in", Toast.LENGTH_LONG).show();
        Intent intent;
        intent = new Intent(getApplicationContext(), Login_Activity.class);
        startActivity(intent);
    }
    public void onButtonExitClicked(View v){
        Toast.makeText(getApplicationContext(),"Sign up", Toast.LENGTH_LONG).show();
            Intent intent;
        intent = new Intent(getApplicationContext(), Signup_Activity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

