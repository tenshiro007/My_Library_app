package com.example.p003_mylibraly;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Util {
    private static Util instance;

    private static final String ALL_BOOK_KEY = "all_book";
    private static final String ALREADY_READ = "already_read_book";
    private static final String WANT_TOREAD = "want_toread_book";
    private static final String CURRENTLY_READING = "currently_reading_book";
    private static final String FAVORITE_BOOK = "favorite_book";

    private static ArrayList<Book> allbook;
    private static ArrayList<Book> alreadyReadBook;
    private static ArrayList<Book> wantToRead;
    private static ArrayList<Book> currentlyReadBook;
    private static ArrayList<Book> favoriteBook;

    private SharedPreferences sharedPreferences;

    private Util(Context context) {
        sharedPreferences = context.getSharedPreferences("alternative_db", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (null == allbook) {
            initData();
        }
        if (null == alreadyReadBook) {
            editor.putString(ALREADY_READ, gson.toJson(new ArrayList<>()));
            editor.commit();
        }
        if (null == currentlyReadBook) {
            editor.putString(CURRENTLY_READING, gson.toJson(new ArrayList<>()));
            editor.commit();
        }
        if (null == wantToRead) {
            editor.putString(WANT_TOREAD, gson.toJson(new ArrayList<>()));
            editor.commit();
        }
        if (null == favoriteBook) {
            editor.putString(FAVORITE_BOOK, gson.toJson(new ArrayList<>()));
            editor.commit();
        }
    }

    public static synchronized Util getInstance(Context context) {
        if (null != instance) {
            return instance;
        } else {
            instance = new Util(context);
            return instance;
        }
    }

    private void initData() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Last Thing He Told Me", "Hardcover"
                , "https://images-na.ssl-images-amazon.com/images/I/51b-JoV-1xS._SX329_BO1,204,203,200_.jpg"
                , "A “gripping” (Entertainment Weekly) mystery about a woman who thinks she’s found the love of her life—until he disappears."
                , "Before Owen Michaels disappears, he smuggles a note to his beloved wife of one year: Protect her. Despite her confusion and fear, Hannah Hall knows exactly to whom the note refers—Owen’s sixteen-year-old daughter, Bailey. Bailey, who lost her mother tragically as a child. Bailey, who wants absolutely nothing to do with her new stepmother."));

        books.add(new Book(2, "Where the Crawdads Sing", "Paperback", "https://images-na.ssl-images-amazon.com/images/I/513gc-hGy3L._SX331_BO1,204,203,200_.jpg"
                , "I can't even express how much I love this book! I didn't want this story to end!--Reese Witherspoon"
                , "For years, rumors of the \"Marsh Girl\" have haunted Barkley Cove, a quiet town on the North Carolina coast. So in late 1969, when handsome Chase Andrews is found dead,A brave and heartbreaking novel that digs its claws into you and doesn't let go, long after you've finished it' Anna Todd, author of the After series\n" +
                "'A glorious and touching read, a forever keeper' USA Today\n" +
                "'Will break your heart while filling you with hope' Sarah Pekkanen, Perfect Neighbors\n"));

        books.add(new Book(3, "The Nightingale", "Paperback", "https://images-na.ssl-images-amazon.com/images/I/51BqKV6TlpL._SX331_BO1,204,203,200_.jpg"
                , "New York Times bestseller, Wall Street Journal Best Book of the Year, and soon to be a major motion picture, this unforgettable novel of love and strength in the face of war has enthralled a generation."
                , "France, 1939 - In the quiet village of Carriveau, Vianne Mauriac says goodbye to her husband, Antoine, as he heads for the Front. She doesn't believe that the Nazis will invade France … but invade they do, in droves of marching soldiers"));

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOK_KEY, gson.toJson(books));
        editor.commit();
    }

    public ArrayList<Book> getAllbook() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOK_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBook() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ, null), type);
        return books;
    }

    public ArrayList<Book> getWantToRead() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TOREAD, null), type);
        return books;
    }

    public ArrayList<Book> getCurrentlyReadBook() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING, null), type);
        return books;
    }

    public ArrayList<Book> getFavoriteBook() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOK, null), type);
        return books;
    }

    public boolean addAlreadyRead(Book book) {
        ArrayList<Book>books = getAlreadyReadBook();
        if (null != books) {
            if (books.add(book)) {
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ);
                editor.putString(ALREADY_READ, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

    public boolean addCurrentRead(Book book) {
        ArrayList<Book>books = getCurrentlyReadBook();
        if (null != books) {
            Log.d("Before Adding",books.toString());
            if (books.add(book)) {
                Log.d("Add currently ",books.toString());
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING);
                editor.putString(CURRENTLY_READING, gson.toJson(books));
                editor.commit();
                return true;
            }
        }
        return false;
    }

//    public boolean removeAlreadyRead(Book book) {
//        allreadyBook = getAlreadyReadBook();
//        if (null != allreadyBook) {
//            if (allreadyBook.remove(book)) {
//                Gson gson = new Gson();
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString(ALREADY_READ, gson.toJson(alreadyReadBook));
//                editor.commit();
//                return true;
//            }
//        }
//        return false;
//    }

}
