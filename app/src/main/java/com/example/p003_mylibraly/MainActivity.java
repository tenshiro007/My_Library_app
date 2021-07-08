package com.example.p003_mylibraly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnSeeAll,btnCurrent,btnAlready,btnYourWish,btnSeeFav,btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // TODO: 7/9/2021 Create Onclick intent
        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AllBookActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initView() {
        btnSeeAll=findViewById(R.id.btnSeeAll);
        btnCurrent=findViewById(R.id.btnCurrentlyRead);
        btnAlready=findViewById(R.id.btnAllreadyRead);
        btnYourWish=findViewById(R.id.btnWishList);
        btnSeeFav=findViewById(R.id.btnSeeFav);
        btnAbout=findViewById(R.id.btnAbout);
    }
}