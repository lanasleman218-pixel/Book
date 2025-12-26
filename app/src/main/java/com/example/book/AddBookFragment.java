package com.example.book;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

public class AddBookFragment extends Fragment {
    private EditText etTitle,etAuthor,etPublisher,etPublishDate,etISBN,etType,etDescription,etPages,etLanguage;
    private Button btnAdd;
    private FirebaseServices fbs;
    private Utils utils;


    public void onStart(){
        super.onStart();
        connectComponents();
    }


    private void connectComponents() {
        etTitle=getActivity().findViewById(R.id.etTitleAddBook);
        etAuthor=getActivity().findViewById(R.id.etAuthorAddBook);
        etPublisher=getActivity().findViewById(R.id.etPublisherAddBook);
        etPublishDate=getActivity().findViewById(R.id.etPublishDateAddBook);
        etISBN=getActivity().findViewById(R.id.etISBNAddBook);
        etType=getActivity().findViewById(R.id.etTypeAddBook);
        etDescription=getActivity().findViewById(R.id.etDescriptionAddBook);
        etPages=getActivity().findViewById(R.id.etPagesAddBook);
        etLanguage=getActivity().findViewById(R.id.etLanguageAddBook);
        fbs=FirebaseServices.getInstance();
        utils = Utils.getInstance();
        btnAdd=getActivity().findViewById(R.id.btnAddAddBook);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, author, publisher, publishDate, type, ISBN, description, language;
                Integer pages;

                title = etTitle.getText().toString();
                author = etAuthor.getText().toString();
                publisher = etPublisher.getText().toString();
                publishDate = etPublishDate.getText().toString();
                type = etType.getText().toString();
                ISBN = etISBN.getText().toString();
                description = etDescription.getText().toString();
                language = etLanguage.getText().toString();
                 if (!etPages.getText().toString().isEmpty()&&TextUtils.isDigitsOnly(etPages.getText().toString()))
                     pages= Integer.parseInt(etPages.getText().toString());
                else
                    pages = 0;

                if (title.trim().isEmpty() || author.trim().isEmpty() || publisher.trim().isEmpty() ||
                        publishDate.trim().isEmpty() || type.trim().isEmpty() || ISBN.trim().isEmpty() ||
                        description.trim().isEmpty() || language.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), "Some fileds are empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Book book=new Book( title,  author,publisher,  publishDate, type,ISBN, description, pages,  language,"");


                fbs.getFire().collection("books").add(book).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT).show();
                        // TODO: goto all fragment
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Failure!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_book, container, false);
    }


}