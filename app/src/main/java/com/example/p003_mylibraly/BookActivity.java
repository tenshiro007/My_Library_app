package com.example.p003_mylibraly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static com.example.p003_mylibraly.AllBookActivity.alreadyBook;
import static com.example.p003_mylibraly.AllBookActivity.books;
import static com.example.p003_mylibraly.AllBookActivity.currentBook;
import static com.example.p003_mylibraly.AllBookActivity.favBook;
import static com.example.p003_mylibraly.AllBookActivity.wishBook;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY="bookId";
    private Book bookx;
    private Button btnCurrent,btnWant,btnAlready,btnAddFav;
    private ImageView imageView;
    private TextView txtName,txtAuthor,txtShort,txtLong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initView();
        Intent intent=getIntent();
        if(null !=intent){
            int id=intent.getIntExtra(BOOK_ID_KEY,-1);
            for(Book a:books){
                if(a.getId()==id){
//                    Log.d("Books",a.toString());
                    bookx=a;
                    initInstant(a);
                }
            }
        }
        createEvent();

    }



    private void createEvent() {
        btnCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentBook.add(bookx);
                Log.d("Book Activity",bookx.toString());
                Intent intent=new Intent(BookActivity.this,CurrentlyReadActivity.class);
                Toast.makeText(BookActivity.this, "Books add", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btnAddFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favBook.add(bookx);
                Intent intent=new Intent(BookActivity.this,CurrentlyReadActivity.class);
                Toast.makeText(BookActivity.this, "Books add", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btnWant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wishBook.add(bookx);
                Intent intent=new Intent(BookActivity.this,CurrentlyReadActivity.class);
                Toast.makeText(BookActivity.this, "Books add", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btnAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alreadyBook.add(bookx);
                Intent intent=new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                Toast.makeText(BookActivity.this, "Books add", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private void initInstant(Book a) {

        for(Book x:currentBook){
            if(x.getId()==a.getId()){
                btnCurrent.setEnabled(false);
            }
        }

        for(Book x:alreadyBook){
            if(x.getId()==a.getId()){
                btnAlready.setEnabled(false);
            }
        }

        for(Book x:wishBook){
            if(x.getId()==a.getId()){
                btnWant.setEnabled(false);
            }
        }
        for(Book x:favBook){
            if(x.getId()==a.getId()){
                btnAddFav.setEnabled(false);
            }
        }

        txtName.setText(a.getName());
        txtAuthor.setText(a.getAuthor());
        txtShort.setText(a.getShortDes());
        txtLong.setText(a.getLongDes());
        Glide.with(BookActivity.this)
                .asBitmap().load(a.getImageUrl())
                .into(imageView);
    }

    private void initView() {
        btnCurrent=findViewById(R.id.btnCurrentlyRead);
        btnAddFav=findViewById(R.id.btnAddFav);
        btnWant=findViewById(R.id.btnWant);
        btnAddFav=findViewById(R.id.btnAddFav);
        btnAlready=findViewById(R.id.btnAllreadyRead);

        imageView=findViewById(R.id.imageView);
        txtName=findViewById(R.id.txtName);
        txtAuthor=findViewById(R.id.txtAuthor);
        txtLong=findViewById(R.id.txtLongDesc);
        txtShort=findViewById(R.id.txtShortDesc);
    }
}