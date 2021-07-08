package com.example.p003_mylibraly;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import static com.example.p003_mylibraly.BookActivity.BOOK_ID_KEY;

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
        holder.txtDes.setText(books.get(position).getShortDes());
        Glide.with(context).asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.image);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,books.get(position).getId());
                context.startActivity(intent);
            }
        });
        if(books.get(position).isExpand()){
            holder.icdown.setVisibility(View.GONE);
            holder.icup.setVisibility(View.VISIBLE);
            holder.showMore.setVisibility(View.VISIBLE);

        }else{
            holder.icup.setVisibility(View.GONE);
            holder.icdown.setVisibility(View.VISIBLE);
            holder.showMore.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName,txtAuthor,txtDes;
        private ImageView image,icdown,icup;
        private MaterialCardView parent;
        private RelativeLayout showMore;
        public ViewHolder( View itemView) {
            super(itemView);
            showMore=itemView.findViewById(R.id.showMore);
            txtDes=itemView.findViewById(R.id.txtDesc);
            icdown=itemView.findViewById(R.id.icdown);
            icup=itemView.findViewById(R.id.icup);
            txtName=itemView.findViewById(R.id.txtName);
            txtAuthor=itemView.findViewById(R.id.txtAuthor);
            parent=itemView.findViewById(R.id.parent);
            image=itemView.findViewById(R.id.image);

            icdown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book=books.get(getAdapterPosition());
                    book.setExpand(!book.isExpand());
                    notifyDataSetChanged();
                }
            });

            icup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book =books.get(getAdapterPosition());
                    book.setExpand(!book.isExpand());
                    notifyDataSetChanged();
                }
            });
        }
    }
}
