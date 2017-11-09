package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText editTExtName, editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTExtName = (EditText)findViewById(R.id.editTextName);
        editTextEmail =(EditText)findViewById(R.id.editTextEmail);
    }
    protected void onStart(){
        super.onStart();
        Log.d("Main Activity", "onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.d("Main Activity", "onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d("Main Activity", "onPause");
    }

    public void saveProfile(View view){
        String name, email;
        name = editTExtName.getText().toString();
        email = editTextEmail.getText().toString();
        Intent intent = getIntent();
        intent.putExtra(MainActivity.PROFILE_NAME, name);
        intent.putExtra(MainActivity.PROFILE_EMAIL, email);
        setResult(RESULT_OK, intent);
        finish();
    }
}
