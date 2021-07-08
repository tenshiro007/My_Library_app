package com.example.p003_mylibraly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import static com.example.p003_mylibraly.AllBookActivity.books;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY="bookId";
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

            Log.d("id",String.valueOf(id));

            for(Book a:books){
                if(a.getId()==id){
                    Log.d("Books",a.toString());
                    initInstant(a);
                }
            }
        }

    }

    private void initInstant(Book a) {
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

        imageView=findViewById(R.id.imageView);
        txtName=findViewById(R.id.txtName);
        txtAuthor=findViewById(R.id.txtAuthor);
        txtLong=findViewById(R.id.txtLongDesc);
        txtShort=findViewById(R.id.txtShortDesc);
    }
}