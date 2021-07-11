package com.example.p003_mylibraly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

         web=findViewById(R.id.web);
        Intent intent=getIntent();
        if(null !=intent){
            String url=intent.getStringExtra("url");
            web.loadUrl(url);
            web.setWebViewClient(new WebViewClient());
        }

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(web.canGoBack()){
            web.goBack();
        }else{
            super.onBackPressed();
        }
    }
}