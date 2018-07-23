package com.example.artur.hometask2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2  extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        ImageView image = findViewById(R.id.image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.untitled);
        RoundedBitmapDrawable roundedBitmapDrawableFactory = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawableFactory.setCircular(true);
        image.setImageDrawable(roundedBitmapDrawableFactory);

        Intent intent = getIntent();

        Student student = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);

        TextView firstname = findViewById(R.id.name);

        firstname.setText(student.toFname());

        TextView lastname = findViewById(R.id.lastname);

        lastname.setText(student.toLname());

        TextView age = findViewById(R.id.age);

        age.setText(student.toAge());


    }
}