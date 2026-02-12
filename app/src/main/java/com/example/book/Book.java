package com.example.book;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String publishDate;
    private String type;
    private String ISBN;
    private String description;
    private Integer pages;
    private String language;
    private String photo;


    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public Book() {
        // Required empty constructor for Firestore
    }
    public Book(String title, String author, String publisher, String publishDate, String type,
                String ISBN, String description, Integer pages, String language,String photo) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.type = type;
        this.ISBN = ISBN;
        this.description = description;
        this.pages = pages;
        this.language = language;
        this.photo=photo;
    }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getISBN() { return ISBN; }
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }


}
