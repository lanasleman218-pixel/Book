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

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, new AddBookFragment())
                    .commit();
        }
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //gotoLoginFragment();
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
        //gotoAddBookFragment();
        fbs = FirebaseServices.getInstance();
        if (fbs.getAuth().getCurrentUser() == null)
           //gotoAddBookFragment();
          // gotoLoginFragment();
       // else
        //   gotoAllBooks();
            gotoBookCard();

    }

    private void gotoAddBookFragment() {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new AddBookFragment());
        ft.commit();
    }

    public void gotoChoose()
    {
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main,new AddBookFragment());
        ft.commit();
    }
}