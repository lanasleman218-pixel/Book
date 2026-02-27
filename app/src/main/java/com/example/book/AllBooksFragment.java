package com.example.book;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class AllBooksFragment extends Fragment {
    private FirebaseServices fbs;
    private ArrayList<Book> books;
    private RecyclerView recyclerViewAllBook;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        // connect components
        fbs=FirebaseServices.getInstance();
        recyclerViewAllBook=getView().findViewById(R.id.recyclerViewAllBook);
        recyclerViewAllBook.setHasFixedSize(true);
        recyclerViewAllBook.setLayoutManager(new LinearLayoutManager(getActivity()));
        getBooks();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_book, container, false);
    }

    public ArrayList<Book> getBooks() {
        ArrayList<Book> books = new ArrayList<>();

        try {
            books.clear();
            fbs.getFire().collection("books").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            books.add(document.toObject(Book.class));
                        }
                        BookAdapter adapter = new BookAdapter(getActivity(), books);
                        recyclerViewAllBook.setAdapter(adapter);

                    } else {

                    }


                }
            });

        } catch (Exception e)
        {
            Log.e("getCompaniesMap():",e.getMessage());

        }
        return books;


    }


}