package com.example.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {
    Context context;
    ArrayList<Book> booksList;

    public BookAdapter(Context context, ArrayList<Book> booksList)
    {
        this.context=context;
        this.booksList=booksList;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle,tvAuthor,tvDescription;
        public ImageView photo;
        public MyViewHolder(View v){
            super(v);
            tvTitle=v.findViewById(R.id.tvTitleBookRow);
            tvAuthor=v.findViewById(R.id.tvAuthorBookRow);
            tvDescription=v.findViewById(R.id.tvDescBookRow);
            photo=v.findViewById(R.id.ivImageView);

        }
    }

    @NonNull
    @Override
    public BookAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.simple_row,parent,false);
        return new BookAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.MyViewHolder holder, int position) {
        Book book=booksList.get(position);
        holder.tvTitle.setText(book.getTitle());
        holder.tvAuthor.setText(book.getAuthor());
        holder.tvDescription.setText(book.getDescription());

        if(book.getPhoto()==null||book.getPhoto().isEmpty())
        {
            Picasso.get().load(R.drawable.ic_launcher_background).into(holder.photo);
        }
        else
            Picasso.get().load(book.getPhoto()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }
}
