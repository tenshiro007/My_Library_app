package com.example.p003_mylibraly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import static com.example.p003_mylibraly.AllBookActivity.currentBook;

public class CurrentlyReadActivity extends AppCompatActivity {

    private RecyclerView recyclerCurrently;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_read);

        recyclerCurrently=findViewById(R.id.recyclerCurrently);
        BookAdapterView adapter=new BookAdapterView(this);

        adapter.setBooks(currentBook);

        recyclerCurrently.setAdapter(adapter);
        recyclerCurrently.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent= new Intent(CurrentlyReadActivity.this, MainActivity.class);
        startActivity(intent);
    }
}