package com.example.dsuappacademy.nnnblogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                // Open About BlogPostsActivity
                Intent intent = new Intent(MainActivity.this, BlogPostsActivity.class);
                startActivity(intent);
            }

        });

        Button btn2 = (Button) findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                // Opens Comment Activity screen
                Intent intent = new Intent(MainActivity.this, CommentActivity.class);
                startActivity(intent);
            }

            });}

}