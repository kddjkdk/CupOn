package com.example.CupOn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener( new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent01 = new Intent(getApplicationContext(), MainActivity.class);
                finish();
                startActivity(intent01);
            }
        });

    }
}
