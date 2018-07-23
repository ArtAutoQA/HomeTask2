package com.example.artur.hometask2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_STUDENT = "com.example.student.android2.extra.STUDENT";
    public static final String RESULT = "test";

    public static final int REQUEST_CODE_ACTIVITY_2 = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView image = findViewById(R.id.image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.untitled);
        RoundedBitmapDrawable roundedBitmapDrawableFactory = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawableFactory.setCircular(true);
        image.setImageDrawable(roundedBitmapDrawableFactory);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.but: {
                Intent intent = new Intent(this, Activity2.class);
                intent.putExtra(EXTRA_STUDENT, new Student("Steve", "Johnson", 55));
                startActivity(intent);

            }
            break;

            case R.id.but2: {
                Intent intent = new Intent(this, Activity3.class);
                intent.putExtra(EXTRA_STUDENT, new Student("Steve", "Johnson", 55));
                startActivityForResult(intent, REQUEST_CODE_ACTIVITY_2);
            }
            break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ACTIVITY_2) {
                    if (resultCode == RESULT_OK) {
                        Student student = data.getExtras().getParcelable("TEST");
                        TextView name = findViewById(R.id.name3);
                        name.setText(student.toFname1());

                        TextView age = findViewById(R.id.age3);
                        age.setText(student.toAge1());

                        TextView lastname = findViewById(R.id.last3);
                        lastname.setText(student.toLname1());


                    }
                }
        }
    }