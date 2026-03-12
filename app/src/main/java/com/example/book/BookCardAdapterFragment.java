package com.example.book;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

class BookCardAdapterFragment extends RecyclerView.Adapter<BookCardAdapterFragment.BookViewHolder>{
    private List<Book> bookList;
    public BookCardAdapterFragment(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item_book.xml layout we created earlier
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookCardAdapterFragment.BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.tvBookName.setText(book.getTitle());
        holder.imgBook.setImageResource(Integer.parseInt(book.getPhoto()));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }public static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBook;
        TextView tvBookName;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBook = itemView.findViewById(R.id.imgBookCard);
            tvBookName = itemView.findViewById(R.id.tvBookNameCard);
        }
    }
}


