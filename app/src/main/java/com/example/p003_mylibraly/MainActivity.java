package com.example.p003_mylibraly;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

        btnYourWish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,WishBookActivity.class);
                startActivity(intent);
            }
        });
        btnAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });
        btnCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CurrentlyReadActivity.class);
                startActivity(intent);
            }
        });
        btnSeeFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FavoriteBookActivity.class);
                startActivity(intent);
            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("My Library");
                builder.setMessage("Designed and Developed by Tenshiro \n" +
                        "This is the basic prototype of my mobile application \n" +
                        "Check my github for more application :");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(MainActivity.this,WebActivity.class);
                        intent.putExtra("url","https://github.com/waritthonAuttama");
                        startActivity(intent);
                    }
                });
                builder.create().show();
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