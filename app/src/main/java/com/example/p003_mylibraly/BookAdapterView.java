package com.example.p003_mylibraly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class BookAdapterView extends RecyclerView.Adapter<BookAdapterView.ViewHolder>{
    private Context context;
    private ArrayList<Book>books=new ArrayList<>();

    public BookAdapterView(Context context) {
        this.context = context;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.book_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  BookAdapterView.ViewHolder holder, int position) {
        holder.txtName.setText(books.get(position).getName());
        holder.txtAuthor.setText(books.get(position).getAuthor());
        Glide.with(context).asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName,txtAuthor;
        private ImageView image;
        private MaterialCardView parent;
        public ViewHolder( View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtAuthor=itemView.findViewById(R.id.txtAuthor);
            parent=itemView.findViewById(R.id.parent);
            image=itemView.findViewById(R.id.image);
        }
    }
}
