package com.example.book;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import com.example.book.BookCardFragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    private FirebaseServices fbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void gotoLoginFragment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new LoginFragment());
        ft.commit();

    }
    public void gotoAllBooks() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new AllBooksFragment());
        ft.commit();

    }
    public void gotoBookCard() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new BookCardFragment());
        ft.commit();


    }

    @Override
    protected void onStart() {
        super.onStart();
        fbs = FirebaseServices.getInstance();
        if (fbs.getAuth().getCurrentUser() == null)
           gotoLoginFragment();
        else
            gotoBookCard();
    }

    private void gotoAddBookFragment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new AddBookFragment());
        ft.commit();
    }
}