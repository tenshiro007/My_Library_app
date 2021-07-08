package com.example.p003_mylibraly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBookActivity extends AppCompatActivity {

    private ArrayList<Book> books=new ArrayList<>();
    private RecyclerView bookRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_book);

         bookRecycler= findViewById(R.id.allBookRecyclerView);

        createBooks();

        BookAdapterView adapter=new BookAdapterView(this);
        adapter.setBooks(books);
        bookRecycler.setAdapter(adapter);
//        bookRecycler.setLayoutManager(new GridLayoutManager(this,2));
        bookRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createBooks() {

        books.add(new Book(1,"The Last Thing He Told Me","Hardcover"
                ,"https://images-na.ssl-images-amazon.com/images/I/51b-JoV-1xS._SX329_BO1,204,203,200_.jpg"
                ,"A “gripping” (Entertainment Weekly) mystery about a woman who thinks she’s found the love of her life—until he disappears."
                ,"Before Owen Michaels disappears, he smuggles a note to his beloved wife of one year: Protect her. Despite her confusion and fear, Hannah Hall knows exactly to whom the note refers—Owen’s sixteen-year-old daughter, Bailey. Bailey, who lost her mother tragically as a child. Bailey, who wants absolutely nothing to do with her new stepmother."));

        books.add(new Book(2,"Where the Crawdads Sing","Paperback","https://images-na.ssl-images-amazon.com/images/I/513gc-hGy3L._SX331_BO1,204,203,200_.jpg"
                ,"I can't even express how much I love this book! I didn't want this story to end!--Reese Witherspoon"
                ,"For years, rumors of the \"Marsh Girl\" have haunted Barkley Cove, a quiet town on the North Carolina coast. So in late 1969, when handsome Chase Andrews is found dead,"));

        books.add(new Book(3,"The Nightingale","Paperback","https://images-na.ssl-images-amazon.com/images/I/51BqKV6TlpL._SX331_BO1,204,203,200_.jpg"
                ,"New York Times bestseller, Wall Street Journal Best Book of the Year, and soon to be a major motion picture, this unforgettable novel of love and strength in the face of war has enthralled a generation."
                ,"France, 1939 - In the quiet village of Carriveau, Vianne Mauriac says goodbye to her husband, Antoine, as he heads for the Front. She doesn't believe that the Nazis will invade France … but invade they do, in droves of marching soldiers"));

    }

}