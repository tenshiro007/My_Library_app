package com.example.p003_mylibraly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

//import static com.example.p003_mylibraly.AllBookActivity.wishBook;

public class WishBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_book);
        RecyclerView recyclerView=findViewById(R.id.recylerView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        BookAdapterView adapter=new BookAdapterView(this);
        adapter.setBooks(Util.getInstance(this).getWantToRead());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(WishBookActivity.this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}