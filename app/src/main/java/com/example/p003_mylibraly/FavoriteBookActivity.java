package com.example.p003_mylibraly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import static com.example.p003_mylibraly.AllBookActivity.favBook;

public class FavoriteBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_book);

        RecyclerView recyclerView=findViewById(R.id.recylerView);
        BookAdapterView adapter=new BookAdapterView(this);
        adapter.setBooks(favBook);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent= new Intent(FavoriteBookActivity.this, MainActivity.class);
        startActivity(intent);
    }
}