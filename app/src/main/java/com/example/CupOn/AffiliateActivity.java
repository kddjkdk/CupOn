package com.example.CupOn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.CupOn.MainActivity;
import com.example.CupOn.R;

public class AffiliateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiliate);
        ImageView Back;
        ImageView Mypage;
        Back = (ImageView) findViewById(R.id.back);
        Mypage = (ImageView) findViewById(R.id.mypage);

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
    }
}
