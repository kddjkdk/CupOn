package com.example.CupOn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView Mypage;
    Button btn_save, btn_use, btn_aff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_aff = (Button)findViewById(R.id.btn_aff);
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_use = (Button)findViewById(R.id.btn_use);

        Mypage = (ImageView) findViewById(R.id.mypage);

        btn_aff.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), AffiliateActivity.class);
                startActivity(intent);
            }
        });
        btn_save.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), SaveActivity.class);
                startActivity(intent);
            }
        });
        btn_use.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Use_1Activity.class);
                startActivity(intent);
            }
        });

        Mypage.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Use_1Activity.class);
                startActivity(intent);
            }
        });

    }
}
