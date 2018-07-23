package com.example.artur.hometask2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

private EditText mAge;
private EditText mFirst;
private EditText mLast;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        ImageView image = findViewById(R.id.image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.untitled);
        RoundedBitmapDrawable roundedBitmapDrawableFactory = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawableFactory.setCircular(true);
        image.setImageDrawable(roundedBitmapDrawableFactory);

        Intent intent = getIntent();

        final Student student = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);

        mFirst = findViewById(R.id.name2);
        mFirst.setText(student.toFname1());

        mLast  = findViewById(R.id.lastname2);
        mLast.setText(student.toLname1());

        mAge = findViewById(R.id.age2);
        mAge.setText(student.toAge1());


        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("TEST", new Student(mFirst.getText().toString(),mLast.getText().toString() + "", Integer.parseInt(mAge.getText().toString())));
                setResult(RESULT_OK, result);
                finish();
            }
        });

    }

    }

