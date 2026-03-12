package com.example.book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BookCardFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookCardAdapterFragment adapter;

    // Create some dummy data to test
    private List<Book> bookList = new ArrayList<>();
    private FirebaseServices fbs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewCard);

        // Set the 2-column grid layout
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        bookList.add(new Book("The Great Gatsby", R.drawable.ddd));
       bookList.add(new Book("1984", R.drawable.ddd));
       bookList.add(new Book("The Hobbit", R.drawable.ddd));
       bookList.add(new Book("Android Design", R.drawable.ddd));

        // Initialize and set the adapter
        adapter = new BookCardAdapterFragment(bookList);
        recyclerView.setAdapter(adapter);

        return view;

    }
    public void onStart() {
        super.onStart();
        // connect components
        fbs=FirebaseServices.getInstance();
        recyclerView=getView().findViewById(R.id.recyclerViewCard);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        BookCardAdapterFragment adapter = new BookCardAdapterFragment(bookList);
        recyclerView.setAdapter(adapter);
    }
}
