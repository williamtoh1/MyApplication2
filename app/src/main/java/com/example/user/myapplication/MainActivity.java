package com.example.user.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int PROFILE_UPDATE_REQUEST = 123;
    public static final String PROFILE_NAME = "com.example.user.myapplication.name" ;
    public static final String PROFILE_EMAIL = "com.example.user.myapplication.email" ;
    private TextView textViewName, textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName=(TextView)findViewById(R.id.editTextName);
        textViewEmail=(TextView)findViewById(R.id.editTextEmail);
    }

    public void updateProfile(View view){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivityForResult(intent, PROFILE_UPDATE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //requestCode to identify an intent call
        //resultCode is a code of an intent call
        //data = the actual data returned by an intent call
        if(requestCode ==PROFILE_UPDATE_REQUEST && resultCode == RESULT_OK){
            String name,email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.name) + " : " + name);
            textViewEmail.setText(getString(R.string.email) + " : " + email);


        }
    }

    public void visitBAIT20713(View view){
        String uri = "http://bait2073.000webhostapp.com/welcome.html";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void showMain(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    public void showDial(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "0123456789"));
        startActivity(intent);
    }

    public void showSendTo(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:" + "seekt@tarc.edu.my"));

    }
}
