package com.example.CupOn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Use_1Activity extends AppCompatActivity {

    ImageView Back;
    ImageView Mypage;
    Intent intent;
    Button Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_1);
        Back = (ImageView) findViewById(R.id.back);
        Mypage = (ImageView) findViewById(R.id.mypage);
        Btn = (Button) findViewById(R.id.button);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), MainActivity.class));
            }
        });
        Mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplication(), MypageActivity.class));
            }
        });
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), Use_2Activity.class));
            }
        });
    }
}
